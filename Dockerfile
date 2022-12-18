# Build our image based off of java open jdk image
# aka provide java 11 for our application to run
FROM openjdk:11

# Copy the jar we built of our application, and put it on our image so we can run it
COPY MiniProjectBackend-0.0.1-SNAPSHOT.jar miniproject.jar

# Run the jar on the imag
CMD ["java", "-jar", "/miniproject.jar"]