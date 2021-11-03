from datetime import datetime
from pyspark.sql import SparkSession
from pyspark.sql.functions import col, date_format, to_date, year
from pyspark.sql.types import (DateType, IntegerType, FloatType, StructField,
                               StructType, TimestampType, StringType)

spark = SparkSession.builder.appName("probabdo spark").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

file_location = "presupuesto.csv"
df = spark.read.format("csv").option("inferSchema", 
           False).option("header", False).load(file_location).toDF("anyo", "divisionid", "divisionname", "partidaid", "partida", "subpartidaid", "subpartida", "monto", "nada")

# Select subset of features and filter for balance > 0
filtered_df = df.select("divisionname", "partida", "subpartida", "monto").filter("monto > 4000000.00")

# Generate summary statistics
filtered_df.summary().show()
filtered_df.show()

filtered_df.createOrReplaceTempView("presu_table")

queryConSparkSQL = spark.sql("""
  select divisionname
  from presu_table
  limit 5
""")

#queryConSparkSQL.show()

queryConSparkSQL = spark.sql("""
    select divisionname, subpartida, cast(sum(monto) as decimal(15, 2)) subtotal from presu_table 
    group by divisionname, subpartida
    order by 3 desc
""")

queryConSparkSQL.show()

