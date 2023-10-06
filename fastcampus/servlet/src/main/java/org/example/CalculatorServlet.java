package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        log.info("service");
        final int operand1 = Integer.parseInt(request.getParameter("operand1"));
        final String operator = request.getParameter("operator");
        final int operand2 = Integer.parseInt(request.getParameter("operand2"));

        final int result = Calculator.calculate(new PositiveNumber(operand1), operator,
            new PositiveNumber(operand2));

        final PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}
