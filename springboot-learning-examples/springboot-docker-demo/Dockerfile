FROM java:latest
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
#暴露端口
EXPOSE 8088
ENV JVM_OPTS="-Xmx1344M -Xms1344M -Xmn448M -Xloggc:/data/log/demo-jvm.log -XX:+UseConcMarkSweepGC -Dfile.encoding=utf-8 -Duser.timezone=Asia/Shanghai -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70  -XX:+CMSClassUnloadingEnabled -XX:+ParallelRefProcEnabled -XX:+CMSScavengeBeforeRemark -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintClassHistogramAfterFullGC -XX:+PrintCommandLineFlags -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime -XX:+PrintTenuringDistribution -XX:+PrintHeapAtGC -XX:HeapDumpPath=/tmp/demo-heapdump.hprof -XX:MaxMetaspaceSize=256M -XX:MetaspaceSize=256M"

ENTRYPOINT java ${JVM_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar