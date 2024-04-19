#!/bin/bash
#wget https://archive.apache.org/dist/kafka/2.7.0/kafka_2.13-2.7.0.tgz
curl -O https://archive.apache.org/dist/kafka/2.7.0/kafka_2.13-2.7.0.tgz
tar -xzf kafka_2.13-2.7.0.tgz
cd kafka_2.13-2.7.0

./bin/zookeeper-server-start.sh config/zookeeper.properties &

sleep 5s

osascript -e 'tell app "Terminal" to do script "./bin/kafka-server-start.sh config/server.properties"'

