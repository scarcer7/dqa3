#!/bin/bash

# 进入脚本所在目录
cd "$(dirname "$0")"

# 定义Java程序的主类
MAIN_CLASS="com.razor.dqa.DqaApplication"

# 定义classpath，假设你的应用程序JAR文件位于当前目录下，并且所有依赖项都在同一目录
# CLASSPATH="/home/dev01/dqa/sep/classes:/home/dev01/dqa/sep/*.jar"
CLASSPATH="/home/dev01/dqa/sep/classes:\
/home/dev01/dqa/sep/mybatis-spring-boot-starter-2.2.2.jar:\
/home/dev01/dqa/sep/spring-boot-starter-2.6.13.jar:\
/home/dev01/dqa/sep/spring-boot-2.6.13.jar:\
/home/dev01/dqa/sep/spring-context-5.3.23.jar:\
/home/dev01/dqa/sep/spring-aop-5.3.23.jar:\
/home/dev01/dqa/sep/spring-expression-5.3.23.jar:\
/home/dev01/dqa/sep/spring-boot-autoconfigure-2.6.13.jar:\
/home/dev01/dqa/sep/spring-boot-starter-logging-2.6.13.jar:\
/home/dev01/dqa/sep/log4j-to-slf4j-2.17.2.jar:\
/home/dev01/dqa/sep/log4j-api-2.17.2.jar:\
/home/dev01/dqa/sep/jul-to-slf4j-1.7.36:\
/home/dev01/dqa/sep/jakarta.annotation-api-1.3.5.jar:\
/home/dev01/dqa/sep/snakeyaml-1.29:\
/home/dev01/dqa/sep/spring-boot-starter-jdbc-2.6.13:\
/home/dev01/dqa/sep/HikariCP-4.0.3:\
/home/dev01/dqa/sep/spring-jdbc-5.3.23.jar:\
/home/dev01/dqa/sep/spring-beans-5.3.23.jar:\
/home/dev01/dqa/sep/spring-tx-5.3.23.jar:\
/home/dev01/dqa/sep/mybatis-spring-boot-autoconfigure-2.2.2.jar:\
/home/dev01/dqa/sep/mybatis-3.5.9.jar:\
/home/dev01/dqa/sep/mybatis-spring-2.0.7.jar:\
/home/dev01/dqa/sep/mysql-connector-j-8.0.31.jar:\
/home/dev01/dqa/sep/lombok-1.18.24.jar:\
/home/dev01/dqa/sep/logback-classic-1.2.6.jar:\
/home/dev01/dqa/sep/logback-core-1.2.11.jar:\
/home/dev01/dqa/sep/slf4j-api-1.7.36.jar:\
/home/dev01/dqa/sep/tlog-all-spring-boot-starter-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-spring-boot-configuration-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-dubbo-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-core-1.3.6.jar:\
/home/dev01/dqa/sep/dom4j-1.6.1.jar:\
/home/dev01/dqa/sep/xml-apis-1.0.b2.jar:\
/home/dev01/dqa/sep/javassist-3.22.0-GA.jar:\
/home/dev01/dqa/sep/aspectjweaver-1.9.7.jar:\
/home/dev01/dqa/sep/guava-19.0.jar:\
/home/dev01/dqa/sep/fastjson-1.2.70.jar:\
/home/dev01/dqa/sep/QLExpress-3.2.0.jar:\
/home/dev01/dqa/sep/commons-beanutils-1.8.2.jar:\
/home/dev01/dqa/sep/log4j-1.2.16.jar:\
/home/dev01/dqa/sep/commons-logging-1.1.1.jar:\
/home/dev01/dqa/sep/commons-lang-2.4.jar:\
/home/dev01/dqa/sep/tlog-dubbox-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-feign-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-webroot-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-gateway-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-webflux-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-common-1.3.6.jar:\
/home/dev01/dqa/sep/commons-lang3-3.12.0.jar:\
/home/dev01/dqa/sep/hutool-core-5.7.16.jar:\
/home/dev01/dqa/sep/hutool-json-5.7.16.jar:\
/home/dev01/dqa/sep/hutool-cache-5.7.16.jar:\
/home/dev01/dqa/sep/transmittable-thread-local-2.12.2.jar:\
/home/dev01/dqa/sep/tlog-httpclient-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-okhttp-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-hutool-http-1.3.6.jar:\
/home/dev01/dqa/sep/hutool-http-5.7.16.jar:\
/home/dev01/dqa/sep/tlog-forest-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-rest-template-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-task-1.3.6.jar:\
/home/dev01/dqa/sep/tlog-xxl-job-1.3.6.jar:\
/home/dev01/dqa/sep/spring-boot-starter-validation-2.6.13.jar:\
/home/dev01/dqa/sep/tomcat-embed-el-9.0.68.jar:\
/home/dev01/dqa/sep/hibernate-validator-6.2.5.Final.jar:\
/home/dev01/dqa/sep/jakarta.validation-api-2.0.2.jar:\
/home/dev01/dqa/sep/jboss-logging-3.4.3.Final.jar:\
/home/dev01/dqa/sep/classmate-1.5.1.jar:\
/home/dev01/dqa/sep/spring-core-5.3.23.jar:\
/home/dev01/dqa/sep/spring-jcl-5.3.23.jar"

# 定义配置文件的位置
ONLINE_CONFIG_FILE="/home/dev01/dqa/application-online.properties"

# 定义JVM内存参数，设置初始堆大小和最大堆大小为2GB
JAVA_OPTS="-Xms2G -Xmx4G"

# 运行Java程序
java $JAVA_OPTS -cp "$CLASSPATH" -Dspring.config.additional-location="$ONLINE_CONFIG_FILE" "$MAIN_CLASS"
