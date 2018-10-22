FROM findepi/graalvm

EXPOSE 50051 50051

COPY build/libs/grpc-server-on-graalvm.jar /usr/local/app/lib/app.jar
COPY graal-app.json /usr/local/app/lib/

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y build-essential && \
    apt-get install zlib1g-dev && \
    cd /usr/local/app/lib && \
    native-image --verbose -H:Name=app -jar app.jar -H:ReflectionConfigurationResources=graal-app.json

ENTRYPOINT /usr/local/app/lib/app
