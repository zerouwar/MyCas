# MyCas
A Customize Simple Cas Server

一个实现SSO的简单Cas服务，其中认证部分模仿spring security的认证架构

## 主要的组件:
**MainServlet**:Cas服务的入口，调用CasController  
**CasController**:Cas的调度器，但本身不做身份认证工作，身份认证交由其成员AuthenticationManager完成  
**AuthenticationManager**:身份认证管理器，但具体的认证交给AuthenticationProvider完成  
**AuthenticationProvider**:身份认证提供者，例如读取服务器并比对身份密码，这里只写了一个admin的简单provider  
**TicketManager**:保存票据用，由一个ConcurrentHashMap容器保存票据，票据id是一个随机UUID，期限是两个小时  

运行：
普通的java web项目，扔到tomcat，首先模拟登录，访问/?username=admin&password=admin，如果返回数据带有票据，则以后只需传递票据认证，即访问/?ticket=票据值，其中用户名，密码，票据的name都可以通过修改config.properties文件改变参数名
