#!/bin/bash

# 进入脚本所在目录
cd "$(dirname "$0")"

# 定义Java程序的主类
MAIN_CLASS="com.razor.dqa.DqaApplication"

# 定义classpath，假设你的应用程序JAR文件位于当前目录下，并且所有依赖项都在同一目录
CLASSPATH="/home/dev01/dqa/shade/dqa-1.0.3.jar"

# 定义配置文件的位置
ONLINE_CONFIG_FILE="/home/dev01/dqa/application-online.properties"

# 定义JVM内存参数，设置初始堆大小和最大堆大小为2GB
JAVA_OPTS="-Xms2G -Xmx4G"

# 运行Java程序
java $JAVA_OPTS -cp "$CLASSPATH" -Dspring.config.additional-location="$ONLINE_CONFIG_FILE" "$MAIN_CLASS"
