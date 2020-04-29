**一: 构建镜像**

``mvn clean package dockerfile:build``

**二:运行镜像**

``docker run -d -p 8088:8080 --name docker-demo  admol/docker-demo:docker-demo``

**三:检测结果**
- 浏览器验证
    - 访问 ``http://localhost:8088/hello```
- docker 验证
    - 运行``docker ps`` 命令查看运行中的容器
- docker 容器日志验证
    - docker logs containerid -f