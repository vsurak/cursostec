from ubuntu

RUN apt update && apt upgrade -y
RUN apt-get install -y default-jre
RUN apt-get install -y openjdk-8-jdk
RUN apt install -y wget
RUN apt install -y iproute2
RUN apt install -y iputils-ping
RUN apt-get install -y openssh-server openssh-client
RUN apt-get install -y rsync
RUN apt-get -y install nano
RUN apt install git -y
RUN apt-get -y install yarn
RUN apt-get install -y nodejs
RUN apt-get install -y libtidy-dev

RUN mkdir /opt/hadoop
WORKDIR /opt/hadoop

RUN wget https://dlcdn.apache.org/hadoop/common/hadoop-3.2.3/hadoop-3.2.3.tar.gz && \
    tar -xzf hadoop-3.2.3.tar.gz

WORKDIR /opt
RUN wget https://dlcdn.apache.org/hive/hive-3.1.2/apache-hive-3.1.2-bin.tar.gz  && \
    tar -xzf apache-hive-3.1.2-bin.tar.gz && \
    rm apache-hive-3.1.2-bin.tar.gz

#RUN wget https://dlcdn.apache.org/kafka/3.0.0/kafka_2.13-3.0.0.tgz && \
#    tar -xzf kafka_2.13-3.0.0.tgz && \
#    rm kafka_2.13-3.0.0.tgz

RUN adduser --disabled-password --gecos "" hadoopuser
RUN echo "hadoopuser:hadoop" | chpasswd

RUN mkdir /home/hadoopuser/tmpdata && \
    mkdir /home/hadoopuser/tmpdata/dfs  && \
    mkdir /home/hadoopuser/tmpdata/dfs/name  && \
    mkdir /home/hadoopuser/tmpdata/dfs/name/current  && \
    mkdir /home/hadoopuser/dfsdata  && \
    mkdir /home/hadoopuser/dfsdata/namenode  && \
    mkdir /home/hadoopuser/dfsdata/datanode  && \
    chmod a+rw -R /home/hadoopuser/tmpdata  && \
    chmod a+rw -R /home/hadoopuser/dfsdata  && \
    mkdir /home/hadoopuser/mapr && \
    mkdir /opt/apache-hive-3.1.2-bin/aux && \
    chmod a+rxw -R /opt/apache-hive-3.1.2-bin/aux

COPY ./etc/bashrc /etc
COPY ./etc/bashrc /home/hadoopuser/.bashrc

WORKDIR /etc
RUN cat bashrc > .bashrc
RUN chmod +x .bashrc

WORKDIR /home/hadoopuser
RUN chmod +x .bashrc

COPY /hadoop/etc/hadoop-env.sh /opt/hadoop/hadoop-3.2.3/etc/hadoop
COPY /hadoop/etc/core-site.xml /opt/hadoop/hadoop-3.2.3/etc/hadoop
COPY /hadoop/etc/hdfs-site.xml /opt/hadoop/hadoop-3.2.3/etc/hadoop
COPY /hadoop/etc/mapred-site.xml /opt/hadoop/hadoop-3.2.3/etc/hadoop
COPY /hadoop/etc/yarn-site.xml /opt/hadoop/hadoop-3.2.3/etc/hadoop

COPY /hive/bin/hive-config.sh /opt/apache-hive-3.1.2-bin/bin
COPY /hive/conf/hive-site.xml /opt/apache-hive-3.1.2-bin/conf
#RUN cp /opt/kafka_2.13-3.0.0/libs/*.jar /opt/apache-hive-3.1.2-bin/aux
#COPY /kafka/kafka-handler-3.1.3000.7.2.12.2-5.jar /opt/apache-hive-3.1.2-bin/aux
#COPY /kafka/kafka-handler-3.1.3000.7.2.12.2-5.jar /opt/apache-hive-3.1.2-bin/aux/kafka-handler.jar

WORKDIR /home/hadoopuser
COPY /start.sh /home/hadoopuser
RUN chmod +x start.sh
COPY /init.sh /home/hadoopuser
RUN chmod +x init.sh
COPY /hive-setup.sh /home/hadoopuser
RUN chmod +x hive-setup.sh

# COPY /start-kafka.sh /home/hadoopuser

RUN mkdir /opt/hadoop/hadoop-3.2.3/logs
RUN chmod ugo+rwx /opt/hadoop/hadoop-3.2.3/logs
RUN chmod ugo+rwx /opt/apache-hive-3.1.2-bin

WORKDIR /opt/hadoop/hadoop-3.2.3/bin
#RUN ./hdfs namenode -format -force -nonInteractive

RUN chown -R hadoopuser /home/hadoopuser/tmpdata
RUN chown -R hadoopuser /home/hadoopuser/dfsdata

# COPY /kafka/server.properties /opt/kafka_2.13-3.0.0/config

WORKDIR /home/hadoopuser
RUN cd /home/hadoopuser

CMD ["bash", "-C", "/home/hadoopuser/init.sh"]
