# 工厂模式

> 工厂模式是用来创建某一类具体示例的，具体使用场景比如QQ换皮肤。这里选择构建什么产品的时候可以根据具体的事务进行选择，我们可以直接通过名称字符也可以给产品创建数据结构，我们通过关键索引来选择。

## 代码实现

```java
//创建形状接口
public Interface Shape{
    void draw();
}

//创建形状具体类
public class Circle implements Shape{
    void draw(){
        //doing
    }
}

public class Rect implements Shape{
    void draw(){
        //doing
    }
}

//创建形状工厂
public class ShapeFactory extends Factory{
    public Shape getShape(String ShapeName){
        switch(ShapeName){
            case 'Circle':
            return new Circle();
            case 'Rect':
            return new Rect();
            default:
            return null;
        }
    }

    public Color getColor(String colorName){return null;}
}

//创建颜色接口
public Interface Color{
    void fill();
}

//创建颜色具体类
public class Red implements Color{
    void fill(){
        //do
    }
}

public class Blue implements Color{
    void fill(){
        //do
    }
}
//创建颜色工厂
public class ColorFactory extends Factory{
    public Color getColor(String colorName){
        switch(colorName){
            case 'Red':
            return new Red();
            case 'Blue':
            return new Blue();
            default:
            return null;
        }
    }

    public Shape getShape(String shapeName){return null;}
}

//创建抽象工厂
public abstract class Factory{
    public abstract Color getColor(String colorName);
    public abstract Shape getShape(String shapeName);
}

//工厂制造类
public class BuildFactory{
    public Factory getFactory(String FactoryName){
        switch(FactoryName){
            case 'Shape':
            return new ShapeFactory();
            case 'Color':
            return new ColorFactory();
            default:
            return null;
        }
    }
}
```
