package cafitac.example.chapter1.duckCode.behavior.quack;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("삑");
    }
}
