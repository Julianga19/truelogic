# truelogic

For run the program.

Download kafka:

Kafka version
2.3.0
https://archive.apache.org/dist/kafka/2.3.0/kafka_2.11-2.3.0.tgz

just need to unzip and run it zookeeper & kafka servers, for run 
move to the bin folder of unzipped folder and open a CMD and execute the following command

For zookeeper:
zookeeper-server-start.bat ../../config/zookeeper.properties

in another CMD
For kafka:
kafka-server-start.bat ../../config/server.properties

in the same bin folder, open another CMD and execute the following command for create a new topic

kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic novice-players

After of run zookeeper and kafka, you can execute this project.

you can use the following commands in a CMD for execute.

to build project
maven package

to start project
mvn spring-boot:run

Additional tips:

For consume the service you can use Postman and send a request to:
localhost:8080/Controller/processPlayers 

DATA EXAMPLE
[
    {
      "name": "Sub zero",
      "type": "expert"
    },
    {
      "name": "Scorpion",
      "type": "novice"
    },
    {
      "name": "Scorpion2",
      "type": "novice"
    },
    {
      "name": "Reptile",
      "type": "meh"
    }
  ]
