package com.nclab.authorization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LabsTableServlet extends HttpServlet {
    Map<String,String> labs;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        initMap();
        request.setAttribute("labs", labs);
        request.getRequestDispatcher("labs.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        doGet(reqest,response);
    }

    private void initMap() {
        labs = new HashMap<String, String>();
        labs.put("3 first labs", "https://github.com/zmaks/nclab");
        labs.put("JDBC", "https://github.com/zmaks/nclabDB");
        labs.put("Threads", "https://github.com/zmaks/nclabThreads");
        labs.put("Annotations", "https://github.com/zmaks/nclabAnnotations");
        labs.put("Servlets", "https://github.com/zmaks/nclabServlets");
    }
}
