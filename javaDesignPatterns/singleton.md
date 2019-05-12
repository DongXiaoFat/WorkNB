# 单例模式 （singleton）

## 概述

> Singleton 是一种为了保证类的实例化对象有且仅有一个的一种设计模式，保证了对象的唯一，减少了内存开销，利于Java 的内存回收，此类不便于扩展。单例模式的利用场景比如：计数器、日志、打印机、数据库连接池等。

## 单例模式使用

1. 饿汉式

```

public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
}
```

2. 懒汉式

```
public class Singleton {
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
```

3. 懒汉式 synchronized

```
public class Singleton {
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        synchronized(Singleton.class){
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}

//或者

public class Singleton {
    private static Singleton singleton;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
```

4. DCL双重锁

```
public class Singleton {
    //volatile 保证原子醒操作，防止返回不完整对象。
    private static volatile Singleton singleton;
    private Singleton(){}
    public Singleton getInstance(){
        if (singleton == null) {
            synchronized(Singleton.class){
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
```

5. 静态内部类

```
public class Singleton {
    private static class Singleton_Static{
        private Singleton singleton = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return Singleton_Static.aingleton;
    }
}
```

6. ThreadLocal

```
public class Singleton {
    private static ThreadLocal<Singleton> threadLocal = new ThreadLocal<Singleton>();
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if(threadLocal.get() == null) {
            synchronized(singleton.class){
                singleton = new Singleton();
                threadLocal.set(singleton);
            }
        }
        return threadLoca.get();
    }
}
```

7. 枚举

使用枚举既能防止反射也能防止反序列化。
```
public enum Singleton {
    INSTANCE;
    public void whateverMethod() {

    }
}
```