package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class QueryStringTest {

    // operand=11
    @Test
    void createTest() {
        final QueryString queryString = new QueryString("operand", "11");

        assertThat(queryString).isNotNull();
    }
}
