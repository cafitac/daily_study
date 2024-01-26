import java.util.ArrayList;
import java.util.List;

public class Main {

    private final List<Main> children = new ArrayList<>();
    private final Main parent = null;

    public Main() {
    }

    @Override
    public String toString() {
        return "Main{" +
            "children=" + children +
            ", parent=" + parent +
            '}';
    }

    public void add(final Main child) {
        this.children.add(child);
    }

    public static void main(String[] args) {
        final Main parent = new Main();
        parent.add(parent);
        System.out.println(parent);
    }
}
