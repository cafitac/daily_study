package org.example;

import java.util.Objects;

public class RequestLine {

    private final String method;
    private final String urlPath;
    private String queryString;

    public RequestLine(final String method, final String urlPath, final String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    public RequestLine(final String requestLine) {
        final String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        final String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryString = urlPathTokens[1];
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath,
            that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
