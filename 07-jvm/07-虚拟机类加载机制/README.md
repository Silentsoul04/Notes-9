# 07-虚拟机类加载机制

[TOC]

Java 虚拟机把描述类的数据从 Class 文件加载到内存,并对数据进行进行

- 校验
- 转换解析
- 初始化

最终形成可以被虚拟机直接使用的Java 类型,这个过程被称作虚拟机的类加载机制

#### 值得注意的是

- Java 语言,类的加载,连接和初始化过程都是在程序运行期间完成,这种策略让 Java 语言增加了性能开销
- 但是,也极大地增加了系统的灵活性以及拓展性

Java天生可以动态拓展语言特性就是依赖运行期动态加载和动态连接这个特点实现的

例如:

- 编写一个面向接口的应用程序,可以通过运行时再指定其实际的实现类
- 用户可以通过 Java 预置的或者自定义的类加载器,让某个本地程序在运行时从网络或者其他地方加载一个二进制流作为其程序代码,这种动态组装应用的方式已经广泛使用
  - Applet
  - JSP
  - OSGI

都是依赖于 Java 语言运行期间类加载才得以诞生
