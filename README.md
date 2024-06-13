# 一个springcloud项目（完全开源）



## 作者留言

这个项目会不断更新和迭代，让想学习java的新手，可以快速上手项目。

## 适合人群

没有做过项目或做过一些简单的项目，或想学习spring新技术和第三方框架等人群。

## 技术栈（已包含）

下面是官网学习地址，学新技术，还是要看官网，请保持良好的学习习惯。

[springBoot](https://docs.spring.io/spring-boot/index.html)

[springAI](https://docs.spring.io/spring-ai/reference/index.html)

[springSecurity](https://docs.spring.io/spring-security/reference/index.html)

[springCloudConsul](https://spring.io/projects/spring-cloud-consul)

[springCloudOpenfeign](https://spring.io/projects/spring-cloud-openfeign)



## 学习笔记

### train-consul

#### 实现功能

```
服务注册与发现： 
使用 Consul 作为服务注册中心，Spring Boot 应用可以向 Consul 注册自己提供的服务，并从 Consul 中发现其他服务的实例，实现了微服务架构中的服务注册与发现功能。

配置管理：
Consul 提供了 Key-Value 存储的功能，Spring Cloud Consul 可以将应用的配置信息存储在 Consul 中，并实时监控配置的变化，使得应用可以动态地获取最新的配置信息。

分布式锁： （未实现）
Consul 提供了分布式锁的功能，Spring Cloud Consul 可以在分布式环境中使用 Consul 实现分布式锁，保证多个实例之间的数据一致性和互斥操作。

健康检查：
Consul 具有健康检查的功能，Spring Cloud Consul 可以定期检查应用的健康状态，并将结果反馈给 Consul，从而实现对服务实例的健康监控和自动故障恢复。
```

#### 总结

```
总的来说，Spring Cloud Consul 主要用于构建基于微服务架构的分布式系统，在该系统中实现服务注册与发现、配置管理、分布式锁等功能，以提高系统的可伸缩性、可靠性和灵活性。
```



### train-openfeign

#### 实现功能

```
微服务间的服务调用：
在微服务架构中，不同的服务可能需要相互调用，例如一个服务需要调用另一个服务的接口获取数据或执行业务逻辑。Spring Cloud OpenFeign 可以帮助开发者在服务之间建立起简洁、高效的通信机制，通过定义接口和注解来描述服务之间的调用关系，从而减少手动编写 HTTP 请求的工作量。

声明式的客户端调用：
Spring Cloud OpenFeign 提供了一种声明式的客户端调用方式，开发者只需要定义一个接口并添加相应的注解，就可以像调用本地方法一样调用远程服务，而无需关心底层的 HTTP 请求细节。这种方式使得服务之间的调用代码更加清晰简洁，提高了代码的可读性和可维护性。

负载均衡和容错处理： 
Spring Cloud OpenFeign 集成了 Ribbon 负载均衡器和 Hystrix 断路器，可以通过配置实现对服务调用的负载均衡和容错处理。开发者可以通过简单的配置来实现对服务调用的负载均衡和故障转移，提高了系统的可用性和可靠性。

与服务发现集成： 
Spring Cloud OpenFeign 可以与服务发现组件（如 Eureka、Consul 等）进行集成，从而实现动态的服务实例发现和注册。开发者可以通过服务名来调用远程服务，而无需硬编码具体的服务实例地址，从而使得服务之间的调用更加灵活和可扩展。
```

#### 总结

```
总的来说，Spring Cloud OpenFeign 主要用于简化微服务架构中服务之间的通信，提高开发效率和系统可维护性，同时还具备负载均衡、容错处理等功能，使得服务调用更加稳定和可靠。
```



### train-circuitBreaker

#### 实现功能

```
远程服务调用：在微服务架构中，一个服务调用远程服务时，如果远程服务出现故障或响应时间过长，Circuit Breaker 可以保护调用方服务，防止其资源耗尽。

第三方服务集成：当应用集成第三方服务时，如果第三方服务不可用，Circuit Breaker 可以提供降级处理逻辑，保证核心功能的可用性。

网络不稳定：在网络不稳定的情况下，Circuit Breaker 可以防止因网络问题导致的频繁重试，从而减少网络负载和资源消耗。

数据库访问：在访问数据库时，如果数据库响应缓慢或不可用，Circuit Breaker 可以防止大量请求涌入数据库，避免数据库崩溃。

批处理任务：在执行批处理任务时，如果某个任务失败，Circuit Breaker 可以跳过失败的任务部分，继续处理后续任务，从而提高批处理的效率和可靠性。
```

#### 总结

```
通过应用 Spring Cloud Circuit Breaker，可以有效提高微服务系统的稳定性和可靠性，增强系统在面对故障时的弹性和恢复能力。
```



## 其他项目链接（练手项目）

[预留位]()



## 项目日志

```
#模块对应的服务端口
train-test:8889
train-ai:8001
train-rabbitMQ:8002
train-redis:8003
train-consul:8004
train-openfeign:8005
train-circuit:8006
train-gateway:8007
train-cloud:8008
```



