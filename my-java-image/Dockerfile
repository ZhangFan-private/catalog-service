# 新镜像基于Ubuntu的官方镜像，版本为22.04
FROM ubuntu:22.04
# 安装jre
RUN apt-get update && apt-get install -y default-jre
# 为运行的容器定义执行入口点
ENTRYPOINT ["java", "--version"]