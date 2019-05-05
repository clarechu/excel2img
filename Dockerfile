FROM sissyun/base-java:0.1
ENV  TZ="Asia/Shanghai"  \
     APP_OPTIONS="-Xms128m -Xmx512m -Xss512k"
WORKDIR ${APP_HOME:-/opt/app-root/src/}

COPY target/excel2img-0.0.1-SNAPSHOT.jar ${APP_HOME:-/opt/app-root/src}/app.jar
ENTRYPOINT  ["sh","-c","java -jar ${APP_HOME:-/opt/app-root/src}/app.jar $APP_OPTIONS"]