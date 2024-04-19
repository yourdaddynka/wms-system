## Структура проекта:

### Логика с хранением в бд

wget https://archive.apache.org/dist/kafka/2.7.0/kafka_2.13-2.7.0.tgz

tar -xzf kafka_2.13-2.7.0.tgz

cd kafka_2.13-2.7.0

./bin/zookeeper-server-start.sh config/zookeeper.properties

./bin/kafka-server-start.sh config/server.properties

