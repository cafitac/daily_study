package cafitac.example.chapter1.duckCode;

import cafitac.example.chapter1.duckCode.behavior.fly.FlyRocketPowered;
import cafitac.example.chapter1.duckCode.duck.Duck;
import cafitac.example.chapter1.duckCode.duck.MallardDuck;
import cafitac.example.chapter1.duckCode.duck.ModelDuck;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        final Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        final Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
