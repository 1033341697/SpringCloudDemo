#这是基础镜像
FROM java:8
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
#作者
MAINTAINER chiliuliu
#复制jar包到镜像中
ADD eureka-0.0.1-SNAPSHOT.jar /tmp/eureka-0.0.1-SNAPSHOT.jar
#在容器启动的时候运行命令，来启动我们的项目（这其实就是一段Linux命令）
ENTRYPOINT ["java","-jar","/tmp/eureka-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761
CMD echo "镜像构建成功"
