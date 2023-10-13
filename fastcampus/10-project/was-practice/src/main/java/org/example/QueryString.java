package org.example;

public class QueryString {

    private final String key;
    private final String value;

    public QueryString(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    public boolean exists(final String key) {
        return this.key.equals(key);
    }

    public String getValue() {
        return this.value;
    }
}
