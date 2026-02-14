package kz.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("""
            <!DOCTYPE html>
            <html>
            <body>
                <h2>GET request received</h2>

                <form method="post" action="data">
                    <input type="text" name="name" placeholder="Enter name">
                    <input type="text" name="group" placeholder="Enter group">
                    <button type="submit">Send</button>
                </form>
            </body>
            </html>
        """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");
        String group = req.getParameter("group");

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("""
            <!DOCTYPE html>
            <html>
            <body>
                <h2>POST request processed</h2>
                <p>Name: %s</p>
                <p>Group: %s</p>
                <p>Date: 2026-02-13</p>

                <a href="data">Back</a>
            </body>
            </html>
        """.formatted(name, group));
    }
}
