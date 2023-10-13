package org.example;

public class Customer {

    public Cook order(final String menuName, final Menu menu, final Cooking cooking) {
        final MenuItem menuItem = menu.choose(menuName);
        final Cook cook = cooking.makeCook(menuItem);
        return cook;
    }
}
