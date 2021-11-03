from pyspark.sql import SparkSession
from pyspark.sql.types import (IntegerType, FloatType, StructField,
                               StructType, TimestampType, StringType)
from pyspark.sql.functions import col, to_date

spark = SparkSession.builder.appName("Ejemplo 1 bases2").getOrCreate()

csv_schema = StructType([StructField('fecha', StringType()),
                         StructField('amount', FloatType())
                         ])

dataframe = spark.read.csv("datasales.dat",
                           schema=csv_schema,
                           header=False)

dataframe = dataframe.withColumn('fecha',to_date(col('fecha'), 'MM/dd/yyyy'))

dataframe.show()

