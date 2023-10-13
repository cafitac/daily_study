package org.example;

public class Cooking {

    public Cook makeCook(final MenuItem menuItem) {
        final Cook cook = new Cook(menuItem);
        return cook;
    }
}
