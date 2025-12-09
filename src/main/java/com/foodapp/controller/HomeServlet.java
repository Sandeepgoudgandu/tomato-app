package com.foodapp.controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        req.setAttribute("message", "Welcome to Food Delivery App!");
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
