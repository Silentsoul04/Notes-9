# 迪米特法则（Law of Demeter）

[TOC]

迪米特法则又叫**最小知识原则**。

> 每一个软件单位对其他的单位都只有最少的知识，而且局限于哪些于本单位密切相关的软件单位。

简单来说，就是一个对象应当对其他对象有尽可能少的了解，不要和陌生人说话。（talk only to your immediate friends）

## 详解

只与直接的朋友通讯。

直接的朋友：每个对象都会与其他对象有耦合关系，只要两个对象有耦合关系，我们说着两个对象之间是朋友关系，耦合的方式很多：依赖、关联、组合、聚合等。其中，当前**对象本身（this）**、**成员变量**、以**参数形式**传入当前对象方法中的**对象**、**方法返回值中的类**，当前对象创建的对象为直接的朋友。

## 使用

1. 在类的划分上，应当尽量创建松耦合的类，类之间耦合度越低，就越有利于复用，一个处在松耦合中的类一旦被修改，不会对关联的类造成太大波及。
2. 在类的结构设计上，每一个类都应该尽量降低其成员变量和成员函数的访问权限。
3. 在类的设计上，只要有可能，一个类型应当设计成不变类。
4. 在对其他类的引用上，一个对象对其他对象的引用应当降低到最低。