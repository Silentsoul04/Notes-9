# Wrapper组件

Wrapper容器是Tomcat中4个级别的容器中最小的，与之相对应的是Servlet，一个Wrapper对应一个Servlet。它包含如下组件。

- Servlet组件：Servlet即Web应用开发常用的Servlet，我们会在Servlet中编写好请求的逻辑处理。
- ServletPool组件：Servlet对象池，当Web应用的Servlet实现了SingleThreadModel接口时则会在Wrapper中产生一个Servlet对象池。线程执行时，需先从对象池中获取到一个Servlet对象，ServletPool组件能保证Servlet对象的线程安全。
- Pipeline组件：Wrapper容器对请求进行处理的管道。