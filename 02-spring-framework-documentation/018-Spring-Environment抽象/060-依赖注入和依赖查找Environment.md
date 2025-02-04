# 060-依赖注入和依赖查找Environment

[TOC]

## 一言蔽之

在日常使用中我们可以直接依赖注入或者是间接依赖注入,Environment属于Spring内建单例对象,支持依赖查找和依赖注入,但是没有元信息

 [010-依赖查找的来源.md](../006-SpringIoC依赖来源/010-依赖查找的来源.md) 

## 依赖注入的两种方式

- 直接依赖注入
  - 通过EnvironmentAware接口回调
  - 通过@Autowired注入 Environment

- 间接依赖注入
  - 通过AppliocationContextAware接口回调
  - 通过@Autowired注入 Application

 [040-单例对象作为依赖来源.md](../006-SpringIoC依赖来源/040-单例对象作为依赖来源.md) 

### 依赖注入-直接依赖注入

```java
public class InjectingEnvironmentDemo implements EnvironmentAware {
    private Environment environment;

    @Autowired
    private Environment environment2;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(InjectingEnvironmentDemo.class);

        // 启动 Spring 应用上下文
        context.refresh();

        // 关闭 Spring 应用上下文
        context.close();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
```

### 依赖注入-间接依赖注入

```java
public class InjectingEnvironmentDemo implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationContext applicationContext2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(InjectingEnvironmentDemo.class);

        // 启动 Spring 应用上下文
        context.refresh();

        // 关闭 Spring 应用上下文
        context.close();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}



```

## 依赖查找方式Environment

通过 Environment Bean 名称 依赖查找

```java
public class LookupEnvironmentDemo implements EnvironmentAware {
    private Environment environment;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(LookupEnvironmentDemo.class);

        // 启动 Spring 应用上下文
        context.refresh();

        LookupEnvironmentDemo lookupEnvironmentDemo = context.getBean(LookupEnvironmentDemo.class);

        // 通过 Environment Bean 名称 依赖查找
        Environment environment = context.getBean(ENVIRONMENT_BEAN_NAME, Environment.class);

        System.out.println(lookupEnvironmentDemo.environment);

        System.out.println(lookupEnvironmentDemo.environment == environment);

        // 关闭 Spring 应用上下文
        context.close();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}


```

