## Repository for course: database II
This readme helps you to perform the intended labs using pyspark. Image courtesy of phD. Juan Esquivel

### docker related  
To build the image and run it 
```
docker build . -t pyspark

docker run -it --rm -v C:\Dev\docker\hadoop\pyspark\examples:/src pyspark bash
```

### pyspark related
To run the examples use the spark-submit command, for example:

```
spark-submit read.py
```