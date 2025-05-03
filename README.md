# kafka-quick-start
A simple Spring Boot app to explore basic Kafka features

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
- We created a topic with name **quickstart-events**.

# Start the Spring Boot app
- `git clone https://github.com/eoral/kafka-quick-start.git`
- `cd kafka-quick-start`
- Set Java 17 to JAVA_HOME environment variable temporarily in current console session.
  - Example (Windows): `set JAVA_HOME=C:\Program Files\Java\jdk-17`
  - Example (Unix): `export JAVA_HOME=/usr/lib/jvm/java-17`
- `mvnw.cmd clean install`
- `mvnw.cmd spring-boot:run`
