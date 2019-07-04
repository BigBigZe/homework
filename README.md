## 分布式计算环境大作业
- server为Eureka实现的注册中心，剩余的都为EurekaClient
- client为一个简单的web应用实例（倒计时计数器），client-duplicate为其副本（注册中心的id一样），模拟分布式环境
- ribbon-server通过ribbon为client实现了负载均衡，通过hystrix实现了熔断以及降级，最后通过zuul实现了流量控制
- config-server为clinet实现了自动配置的功能
