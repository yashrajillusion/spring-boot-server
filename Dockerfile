#
# Build stage
#
From openjdk:19
#
# Package stage
#
# ENV PORT=3001
EXPOSE 3001
ADD target/springserver.jar springserver.jar
ENTRYPOINT ["java","-jar","springserver.jar"]
