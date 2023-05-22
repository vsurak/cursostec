## Repository for course: database II

This readme helps you to perform the intended labs in classroom regarding topics such as mapreduce with hadoop, hive, spark and kafka.

### docker related

Build the image, create an internal network and run the image using a local volumen
path to share files and jars from the host computer

```
    docker build . -t hadoop

docker network create --driver bridge --subnet 10.0.0.0/27 disponet

docker run -it -p 9000:9000 -p 9092:9092 -p 22:22 -v "C:\dev\cursostec\bases II\hadoop-image\mapr":/home/hadoopuser/mapr --name hadoopserver --net disponet --ip 10.0.0.2 hadoop
```

### ssh related

The image includes a default user setup, the user "hadoopuser" must grant passwordless access by ssh, this is required for the hadoop server

```
su - hadoopuser
cd /home/hadoopuser
ssh-keygen -t rsa -P '' -f /home/hadoopuser/.ssh/id_rsa
ssh-copy-id hadoopuser@localhost
exit
```

### hadoop related

Go to your /home/hadoopuser folder and run the script
This script needs to be run everytime the container is restarted

```
./start.sh
```

### to process a job in hadoop

This is an example of how to manually copy files from the host to the container

```
docker cp ejemplobases2.jar hadoopserver:/home/hadoopuser
docker cp datadates.csv  hadoopserver:/home/hadoopuser
```

These are example of instructions to prepare hdfs folders and run a map reduce example
hadoop fs -ls /
hadoop fs -mkdir /data
hadoop fs -copyFromLocal datasales.db /data
hadoop fs -copyFromLocal sample.db /data

hadoop jar yearsales.jar mapr.maprunner
hadoop jar metaverse.jar mapr.maprunner

### hive related

To setup the hive environment just run the `hive-setup.sh` script located in hadoopuser home folder

Then access the hive console with `hive`

The following is an example of instructions in hive console to test your hive environment. The example loads the content of the CSV file datasales.dat into a temporary table where all the fields are string. Following the transfer of the data to the correct table using data types.

```
create schema <name>; // to create an schema
create database ventas_bases2;

create table tmp_metaspent(metaverse string, year int, hours int, coins int) row format delimited fields terminated by ',';

load data inpath '/metaverse/part-00000' into table tmp_metaspent;

CREATE TABLE IF NOT EXISTS metaspent (metaverse string, year int, hours int, coins int)
COMMENT 'Las horas y los coins invertidos por metaverso por año'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
STORED AS TEXTFILE;

insert into table metaspent select trim(metaverse), year, hours, coins from tmp_metaspent;
```

Once data is loaded, run some queries to test the performance

```
SELECT MONTH(fecha), YEAR(fecha), SUM(monto) from sales group by YEAR(fecha), MONTH(fecha);

SELECT anyo, MAX(monto) from (
    SELECT MONTH(fecha) mes, YEAR(fecha) anyo, SUM(monto) monto from sales group by YEAR(fecha), MONTH(fecha)
) as tabla
group by anyo;
```

/////
create table presupuesto (anyo INT, idDivision INT, division string, idpartida int, partida string, idsubpartida int, subpartida string, monto decimal(10,2), idestado int) row format delimited fields terminated by ',';

load data inpath '/data/input/presupuesto.csv' into table presupuesto;

select subpartida, sum(monto) from presupuesto group by division, subpartida;
select subpartida, sum(monto) from presupuesto group by division, subpartida order by sum(monto);
select division, subpartida, sum(monto) from presupuesto group by division, subpartida order by sum(monto);

SELECT division, subpartida, monto rank() over (partition by division order by sum(monto) desc) rank FROM (
select division, subpartida, sum(monto) monto
from presupuesto group by division, subpartida
) result where rank<4;

SELECT \* FROM (
SELECT division, subpartida, monto, rank() over (partition by division order by monto desc) rank FROM (
select division, subpartida, sum(monto) monto
from presupuesto group by division, subpartida
) result
) resultfinal
WHERE rank<4
ORDER BY division, rank;

select subpartida, sum(monto) from presupuesto
where subpartida = "Servicio de agua y alcantarillado"
group by division, subpartida;

### Kakfa related

To start the kafkta server just run the script `/home/hadoopuser/start-kafka.sh` located in the hadoopuser home folder from the folder /opt/kafka_2.13-3.0.0/

To test your Kafka environment follow the [kafka quickstart guide](https://kafka.apache.org/quickstart)

./kafka-topics.sh --create --topic bases2 --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
./kafka-console-producer.sh --topic bases2 --bootstrap-server localhost:9092
./kafka-console-consumer.sh --topic bases2 --from-beginning --bootstrap-server localhost:9092

### integration with spark

./kafka-topics.sh --create --topic newsales --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092

./kafka-topics.sh --list --bootstrap-server localhost:9092

./kafka-console-producer.sh --topic newsales --bootstrap-server localhost:9092

./kafka-console-consumer.sh --topic newsales --from-beginning --bootstrap-server localhost:9092

./kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:9092 --add --allow-principal User:ANONYMOUS --operation All --topic=_ --group=_ --cluster

1. https://www.youtube.com/watch?v=UcWi3-FODjs ; se recomienda usarlo hasta tener el producer de datos en java
   code of the video https://github.com/binodsuman/kafka-spark-streaming-integration

2. Luego integrar con Spark Streaming direct,
   https://spark.apache.org/docs/latest/structured-streaming-kafka-integration.html#deploying
   https://spark.apache.org/docs/latest/streaming-programming-guide.html

3. Si por alguna incompatibilidad de versiones no funciona el direct streaming con kafka, primero tratar de tener las mismas versiones de los jar en todos los ambientes y programas; y volver a probar. Si no, ir al punto #1 y hacer el consumer de spark en java

# Complementos

4. Ejemplo completo con direct streaming y docker https://medium.com/data-arena/enabling-streaming-data-with-spark-structured-streaming-and-kafka-93ce91e5b435

5. Link de suplemento https://hevodata.com/learn/spark-streaming-and-kafka-integration/
