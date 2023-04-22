package cafitac.example.duckCode;

import cafitac.example.duckCode.duck.Duck;
import cafitac.example.duckCode.duck.MallardDuck;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        final Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }
}
