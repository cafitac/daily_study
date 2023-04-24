package cafitac.example.chapter1.duckCode.duck;

import cafitac.example.chapter1.duckCode.behavior.fly.FlyNoWay;
import cafitac.example.chapter1.duckCode.behavior.quack.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 모형 오리입니다.");
    }
}
