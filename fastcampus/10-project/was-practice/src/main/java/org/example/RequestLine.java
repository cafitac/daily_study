package org.example;

import java.util.Objects;

public class RequestLine {

    private final String method;
    private final String urlPath;
    private QueryStrings queryStrings;

    public RequestLine(final String method, final String urlPath, final String queryStrings) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryStrings);
    }

    public RequestLine(final String requestLine) {
        final String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        final String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        }
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(final String requestPath) {
        return this.urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
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
            that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }
}
