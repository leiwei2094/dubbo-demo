# dubbo-demo

这里有3个Demo，分别是    
1. Dubbox 2.8.4 + Spring3 + Dubbo协议    
2. Dubbox 2.8.4 + Spring3 + Hessian协议    
3. dubbox 2.8.4 + Spring3 + HTTP协议    

三个Demo都可以成功运行。使用了gradle Gretty插件，提供了内嵌的Jetty容器，运行demo不用安装额外的Tomcat或jetty等servlet容器。

使用方法如下：    
**1. 运行Zookeeper**    
安装，配置Zookeeper，然后启动Zookeeper的server。[Install, configure and sratr Zookeeper server](https://github.com/Leo-Lei/blog/blob/master/source/_posts/zookeeper.md)    
**2. 运行Provoder**    
进入`provider`目录，执行`gradle appRun`。会启动web容器并运行应用。    
**3. 运行Consumer**    
进入`consumer`目录，执行`gradle appRun`。    
浏览器中访问`http://localhost:8082/hello` 或`http://localhost:8082/user`.其中`/hello`是传递简单String作为参数，`/user`是传递自定义类型*User*作为接口参数。


一些问题：    
1. 现在是在xml中一个个声明dubbo暴露的服务(`dubbo:service`)和依赖的远程引用(`dubbo:reference`)。这方式显然不好，最好是使用spring的自动扫描和自动装配。Dubbo提供了这样的annotation，比如@Service和@Reference。当使用的时候，出现了一些问题。客户端调用IHelloService的sayHello方法时，结果调用了远程服务IUserService的sayHello方法去了，抛出异常IUserService没有提供sayHello方法。    
2. 如果一个服务有部署多个实例，那么服务暴露的端口是不一样的。如何灵活配置。hessian的端口是要和web容器暴露的端口一致的。    


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

Dubbox Spring v4 可以参考 [update-dubbo-to-spring-4](http://www.cnblogs.com/yjmyzz/p/update-dubbo-to-spring-4-and-add-log4j2-support.html)

Dubbo也可以和新版本的spring集成，需要排除自身的spring依赖，如下，   
```java
        compile("com.alibaba:dubbo:2.5.3"){
            exclude(module: 'spring')
            exclude(module: 'netty')
        }
```    
Dubbo和Dubbox在配置方面是否有差异，2者兼容性如何?

# 服务治理
Zookeeper配置

# RPC协议
* Hession
* HTTP
* REST
* Dubbo

|           协议            |   传输协议 |  数据格式    |        性能       |             跨平台/语言            |
| ------------------------- | ---------- | ------------ | ----------------- | ---------------------------------- |
| Dubbo + Dubbo序列化       |  TCP       |   二进制     |                   |                                    |
| Dubbo + Hessian序列化     |  TCP       |   二进制     |                   |                                    |
| Dubbo + Java序列化        |  TCP       |   二进制     |                   | Java序列化二进制数据不能跨语言     |                             
| Hessian + Hessian序列化   |  HTTP      |   二进制     |                   | Hessian序列化二进制数据可跨语言    |          

# Dubbo Admin    
Dubbo提供了Admin的监控中心，研究它的使用。如何部署，能提供什么数据的监控。

# Dubbo 异常捕获    
客户端调用远程服务，如果远程服务抛出了异常，客户端能否捕获到异常，捕获到什么类型的异常?    
总的结果就是:
1. 不管怎样，客户端都能捕获到异常，只是异常的类型在不同场景下会有所不同。    
2. 如果服务端抛出的异常，客户端认识，那么可以正确的获得具体的异常类型。比如JDK自带的异常，客户端当然是有这些类的元数据的，可以获得准确的异常。如果该异常在服务的借口中声明了，客户端也可以拿到具体的异常。    
3. 如果服务端抛出的是自定义异常，且该异常在服务接口中没定义，那么客户端就只能捕获一个`com.caucho.hessian.io.HessianServiceException`.但是原始异常的error message在`HessianServiceException`中会保留。    

# Zookeeper监控和管理
Zookeeper的图形化管理工具:    
* [node-zk-browser](https://github.com/killme2008/node-zk-browser)    
* [zk-web](https://github.com/qiuxiafei/zk-web)    

# 配置管理

**使用Zookeeper做配置管理**    
如何更Zookeeper中的数据，是否需要有一个配置管理界面可以管理更新数据，然后Zookeeer会将更改通知到各个Zookeeper节点。
Zookeeper节点接收到更新通知，节点所在的应用如何去使用新的数据。比如，如果应用只是在第一次启动时去读Zookeeper节点的数据，然后缓存。这样即使Zookeeper节点接收到通知，更新了数据，应用依然读的是缓存中的老数据，所以需要添加一个layer来管理这些数据的更新。 

# Resources      
[Dubbox-REST-Demo](http://dangdangdotcom.github.io/dubbox/rest.html)         
[dubbox-2.8.4-demo ](https://github.com/sxyx2008/dubbo-example)
