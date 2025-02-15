FROM openjdk:17-jdk-slim
ADD target/D387_sample_code-0.0.2-SNAPSHOT.jar D387_sample_code-0.0.2-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -jar /D387_sample_code-0.0.2-SNAPSHOT.jar"]
