package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.example.calculator.calculate.domain.Calculator;
import org.example.calculator.calculate.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/calculate")
public class CalculatorServlet implements Servlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        log.info("init");
        this.servletConfig = config;
    }

    @Override
    public void service(final ServletRequest request, final ServletResponse response)
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

    @Override
    public void destroy() {
        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
