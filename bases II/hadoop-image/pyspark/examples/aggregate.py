from datetime import datetime
from pyspark.sql import SparkSession
from pyspark.sql.functions import col, date_format, to_date, year
from pyspark.sql.types import (DateType, IntegerType, FloatType, StructField,
                               StructType, TimestampType, StringType)

spark = SparkSession.builder.appName("Funcion agregada").getOrCreate()

spark.sparkContext.setLogLevel("ERROR")

csv_schema = StructType([StructField('fecha', StringType()),
                         StructField('amount', FloatType())
                         ])

dataframe = spark.read.csv("datasales.dat",
                           schema=csv_schema,
                           header=True)

dataframe = dataframe.withColumn('fecha',to_date(col('fecha'), 'MM/dd/yyyy'))


# Group By and Select the data already aggregated
dataframeAfterYearColumn = dataframe.withColumn('year',year('fecha'))

#al no especificar las columnas del sum, procede a sumar todas excepto el cambio de group by
#sum_df = dataframeAfterYearColumn.groupBy("year").sum()

sum_df = dataframeAfterYearColumn.groupBy("year").sum("amount")

dataframe = \
    sum_df.select(
        col('year'),
        col('sum(amount)').alias('amountperyear'))

print("dataframe after adding the year column")
dataframeAfterYearColumn.show()
print("dataframe after executing the sum and group")
sum_df.show()
print("final dataframe after the select and project operation")
dataframe.printSchema()
dataframe.show()
