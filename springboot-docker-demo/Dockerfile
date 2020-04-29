FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
#暴露端口
EXPOSE 8088
ENV JVM_OPTS="-Xmx2688M -Xms2688M -Xmn960M -XX:MaxMetaspaceSize=512M -XX:MetaspaceSize=512M -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses -XX:+CMSClassUnloadingEnabled -XX:+ParallelRefProcEnabled -XX:+CMSScavengeBeforeRemark -XX:+PrintGCDetails -Xloggc:/data/log/demo-jvm.log -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps  -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintClassHistogramBeforeFullGC -XX:+PrintClassHistogramAfterFullGC -XX:+PrintCommandLineFlags -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime -XX:+PrintTenuringDistribution -XX:+PrintHeapAtGC  -XX:HeapDumpPath=/tmp/demo-heapdump.hprof  -Dfile.encoding=utf-8  -Duser.timezone=Asia/Shanghai "

ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar