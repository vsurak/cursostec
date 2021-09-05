FROM openjdk:14-alpine

ENV SPARK_HOME=/usr/lib/python3.7/site-packages/pyspark

RUN apk add bash && \
  apk add nano && \
  apk add postgresql-client && \
  apk add python3 && \
  pip3 install --upgrade pip && \
  pip3 install pyspark && \
  pip3 install pytest && \
  ln /usr/bin/python3.7 /usr/bin/python

WORKDIR /src
