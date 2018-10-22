FROM findepi/graalvm

EXPOSE 8080 8080

COPY build/libs/grpc-server-on-graalvm.jar /usr/local/app/lib/app.jar
COPY graal-app.json /usr/local/app/lib/

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y build-essential && \
    apt-get install zlib1g-dev
#    native-image --verbose -H:Name=app \
#      --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,org.springframework.core.io.VfsUtils \
#      -H:ReflectionConfigurationFiles=graal-app.json \
#      -Dio.netty.noUnsafe=true \
#      -H:+ReportUnsupportedElementsAtRuntime \
#      -Dfile.encoding=UTF-8 -cp ".:$(echo spring-fu-on-graalvm/BOOT-INF/lib/*.jar | tr ' ' ':')":spring-fu-on-graalvm/BOOT-INF/classes me.soushin.app.ApplicationKt
#
#ENTRYPOINT /usr/local/app/lib/app

#native-image -H:Name=app -jar app.jar -H:ReflectionConfigurationResources=graal-app.json
