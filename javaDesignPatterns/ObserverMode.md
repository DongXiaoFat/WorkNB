# 观察者模式

> 观察者模式又称作订阅模式，主要用于被观察者来通知观察者进行操作。比如天气气象站数据进行了更新需要通知所有天气网站进行更新,再比如定期通知刷新等行为。

## 代码实现
这里实现是在 Java1.8 接口新特性的基础上。

```java
public Interface Stub {
    Arraylist<Stub> aList = new ArrayList<>();
    default private void NotifyUpdate() {
        for (int i = 0; i < aList.size(); i++){
            aList[i].update();
        }
    }

    public void update();
}

public class ObserverOne implements Stub {
    public ObserverOne (){
        aList.add(this);
    }

    public void update(){
        //do
    }
}

public class ObserverSen implements Stub {
    public ObserverSen (){
        aList.add(this);
    }

    public void update(){
        //do
    }
}

public class MainClass {
    public static void main (int count, String[] args){
        new ObserverOne();
        Stub stub = new ObserverSen();
        stub.NotifyUpdate();
    }
}
```