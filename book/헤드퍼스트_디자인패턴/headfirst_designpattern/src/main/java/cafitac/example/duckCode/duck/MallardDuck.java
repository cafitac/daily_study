package cafitac.example.duckCode.duck;

import cafitac.example.duckCode.behavior.fly.FlyWithWings;
import cafitac.example.duckCode.behavior.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("저는 물오리입니다");
    }
}
