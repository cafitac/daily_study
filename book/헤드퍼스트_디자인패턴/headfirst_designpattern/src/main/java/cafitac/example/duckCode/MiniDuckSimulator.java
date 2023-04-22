package cafitac.example.duckCode;

import cafitac.example.duckCode.behavior.fly.FlyRocketPowered;
import cafitac.example.duckCode.duck.Duck;
import cafitac.example.duckCode.duck.MallardDuck;
import cafitac.example.duckCode.duck.ModelDuck;

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
