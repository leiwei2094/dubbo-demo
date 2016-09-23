# dubbo-demo


# Run Provider    
1. Sratr Zookeeper
2. go to `dubbox-hessian-demo/provider` directory, run `gradle appRun`. The embeded Jetty server started successfully, 
3. Access `http://localhost:8081/index.html`, but it will have 404 error. Need to investigate on it. It should be a Spring MVC configuration mistake, not from Dubbo side. But it is better to fix it.


========================================================
========================================================
=======================================================
# Dubbo or Dubbox
•Dubbo:[Dubbo](http://dubbo.io/)               
•Dubbox:[Dubbox](https://github.com/dangdangdotcom/dubbox)

|              |       Dubbo       |       Dubbox      |
| ------------ | ----------------- | ----------------- |
| Spring 版本  | 2                 | 3                 |
| 是否维护     | no                | dangdang          |

Dubbo和Dubbox在配置方面是否有差异，2者兼容性如何?

# 服务治理
•Zookeeper配置

# RPC协议
•Hession
•HTTP
•REST
•Dubbo

|      协议      |   传输协议         |       数据格式      |      性能       |       跨平台/语言       |
| -------------- | ------------------ | ------------------- | --------------- | ----------------------- |
| Hession        | http               | 二进制              |                 |                         |
| Dubbo          | TCP                | 二进制              |                 |                         |
| REST           | http               | text                |                 |                         |

# Admin

Dubbo提供了Admin的监控中心，研究它的使用。如何部署，能提供什么数据的监控。

# 配置管理

使用Zookeeper做配置管理
如何更Zookeeper中的数据，是否需要有一个配置管理界面可以管理更新数据，然后Zookeeer会将更改通知到各个Zookeeper节点。
Zookeeper节点接收到更新通知，节点所在的应用如何去使用新的数据。比如，如果应用只是在第一次启动时去读Zookeeper节点的数据，然后缓存。这样即使Zookeeper节点接收到通知，更新了数据，应用依然读的是缓存中的老数据，所以需要添加一个layer来管理这些数据的更新。 

# Resources      
[Dubbox-REST-Demo](http://dangdangdotcom.github.io/dubbox/rest.html)         
[dubbox-2.8.4-demo ](https://github.com/sxyx2008/dubbo-example)
