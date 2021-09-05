from datetime import datetime
from pyspark.sql import SparkSession
from pyspark.sql.functions import col, date_format, to_date, year
from pyspark.sql.types import (DateType, IntegerType, FloatType, StructField,
                               StructType, TimestampType, StringType)

spark = SparkSession.builder.appName("Read Transactions").getOrCreate()

csv_schema = StructType([StructField('fecha', StringType()),
                         StructField('amount', FloatType())
                         ])

dataframe = spark.read.csv("datasales.dat",
                           schema=csv_schema,
                           header=True)

dataframe = dataframe.withColumn('fecha',to_date(col('fecha'), 'MM/dd/yyyy'))
dataframe.show()


# Group By and Select the data already aggregated
dataframe = dataframe.withColumn('year',year('fecha'))
dataframe.show()

sum_df = dataframe.groupBy("year").sum()

dataframe = \
    sum_df.select(
        col('year'),
        col('sum(amount)').alias('amountperyear'))

dataframe.printSchema()
dataframe.show()
