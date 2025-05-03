# Intro
- This is a simple Spring Boot app to explore basic Kafka integration features:
  - Publishing messages to a topic
  - Listening to a topic and consuming incoming messages
- I recommend reading this very short introduction before continuing to next steps: https://kafka.apache.org/intro
- **KafkaProducer** class has a method that sends a message to a topic named **quickstart-events**.
- **KafkaProducerConfig** class is where we configure the things required for **KafkaProducer** class.
- **KafkaConsumer** class has a method that listens for incoming messages from topic **quickstart-events**. Once a message is received, it is printed to the console.
- **KafkaConsumerConfig** class is where we configure the things required for **KafkaConsumer** class.
- In **DefaultController** class, we have a REST endpoint. When we send a GET request, we send a message to topic **quickstart-events** using **KafkaProducer** class.
- In **application.properties** file, we have config params for the Kafka server.

# Prerequisites
- Docker
- Java 17
- Maven

# Set up a Kafka server
- `docker pull apache/kafka:4.0.0`
- `docker run -p 9092:9092 apache/kafka:4.0.0`
- Our Kafka server is running on port **9092**.

# Create a Kafka topic
- Download the latest Kafka release. We will use some utility scripts that are included in the release. As of current date, latest release is here: https://www.apache.org/dyn/closer.cgi?path=/kafka/4.0.0/kafka_2.13-4.0.0.tgz
- Extract the downloaded file: `tar -xzf kafka_2.13-4.0.0.tgz`
- Set Java 17 to JAVA_HOME environment variable temporarily in current console session.
  - Example (Windows): `set JAVA_HOME=C:\Program Files\Java\jdk-17`
  - Example (Unix): `export JAVA_HOME=/usr/lib/jvm/java-17`
- Use kafka-topics utility to create a topic with name **quickstart-events**.
  - Windows: `kafka_2.13-4.0.0\bin\windows\kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092`
  - Unix: `kafka_2.13-4.0.0/bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092`
- We have created a topic with name **quickstart-events**.

# Start the Spring Boot app
- `git clone https://github.com/eoral/kafka-quick-start.git`
- `cd kafka-quick-start`
- Set Java 17 to JAVA_HOME environment variable temporarily in current console session.
  - Example (Windows): `set JAVA_HOME=C:\Program Files\Java\jdk-17`
  - Example (Unix): `export JAVA_HOME=/usr/lib/jvm/java-17`
- `mvnw.cmd clean install`
- `mvnw.cmd spring-boot:run`
- Open your browser and go to `http://localhost:8080/send-message`. Refresh the page a few times.
- Open application logs, and you should see lines similar to these.
```
Received message: This message was created at 2025-05-03T20:13:38.968648900
Received message: This message was created at 2025-05-03T20:13:40.804020100
Received message: This message was created at 2025-05-03T20:13:42.047670900
```
