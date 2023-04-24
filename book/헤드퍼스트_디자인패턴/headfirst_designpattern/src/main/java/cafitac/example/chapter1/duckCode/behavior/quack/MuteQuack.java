package cafitac.example.chapter1.duckCode.behavior.quack;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("<< 조용~ >>");
    }
}
