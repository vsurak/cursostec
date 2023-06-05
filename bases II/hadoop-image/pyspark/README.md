## Repository for course: database II

This readme helps you to perform the intended labs using pyspark. Image courtesy of phD. Juan Esquivel

### docker related

To build the image and run it

```
docker build . -t pyspark

docker run -it --rm -v "C:\dev\cursostec\bases II\hadoop-image\pyspark\examples:/src" pyspark bash

docker run -it --name spark --rm -p 7077:7077 -v C:\dev\cursostec\bases II\hadoop-image\pyspark\examples:/src --net littlenet --ip 10.0.0.3 pyspark bash

```

### pyspark related

To run the examples use the spark-submit command, for example:

spark-submit read.py

### ejercicio de integracion con spark

spark-submit --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.0.0 streamfromkafka.py

```

```
