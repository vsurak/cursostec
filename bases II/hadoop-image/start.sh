cd /etc
source .bashrc

/etc/init.d/ssh start

cd /opt/hadoop/hadoop-3.2.3/sbin
./start-all.sh

cd /home/hadoopuser
bash