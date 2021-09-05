hdfs dfs -mkdir /tmp
hdfs dfs -chmod g+w /tmp
hdfs dfs -mkdir -p /user/hive/warehouse
hdfs dfs -chmod g+w /user/hive/warehouse
rm /opt/apache-hive-3.1.2-bin/lib/guava-19.0.jar
cp /opt/hadoop/hadoop-3.3.0/share/hadoop/hdfs/lib/guava-27.0-jre.jar /opt/apache-hive-3.1.2-bin/lib
schematool -dbType derby -initSchema