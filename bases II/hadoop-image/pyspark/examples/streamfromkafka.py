from datetime import datetime
from pyspark.sql import DataFrame, SparkSession
from pyspark.streaming import StreamingContext

spark = SparkSession.builder.appName("Integracion con Kafka").getOrCreate()

spark.sparkContext.setLogLevel("ERROR")

df = spark \
  .readStream \
  .format("kafka") \
  .option("kafka.bootstrap.servers", "10.0.0.2:9092") \
  .option("subscribe", "newsales") \
  .load()

df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")


query = df.writeStream \
  .outputMode("append") \
 .format("console") \
  .start()
query.awaitTermination()


# antes de hacer start debe haber algun output streaming operation
ssc = StreamingContext(spark.sparkContext, 1)
ssc.start()
ssc.awaitTermination()
