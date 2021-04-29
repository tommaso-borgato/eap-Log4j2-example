package com.redhat.qe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test-servlet")
public class TestServlet extends HttpServlet {

    protected static final Logger LOGGER = LogManager.getLogger();

    static String PAGE_HEADER = "<html><head><title>TestServlet</title></head><body>";

    static String PAGE_FOOTER = "</body></html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String msg = req.getParameter("msg");

        String message = (msg == null || "".equals(msg)) ? "no message to log (e.g. 'test/test-servlet/?msg=PIPPOBAUDO')" : msg;
        LOGGER.info(message);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(PAGE_HEADER);
        writer.println("<h1>" + (message) + "</h1>");
        writer.println(PAGE_FOOTER);
        writer.close();
    }

}
