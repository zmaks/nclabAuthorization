package com.nclab.authorization;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class AuthorizationServlet extends HttpServlet {

    Map<String,String> users = new HashMap<String,String>();

    void initUsers(){
        for(int i = 1;i<=5;i++){
            users.put("user"+i,"pass"+i);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        initUsers();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        if(users.containsKey(user)){
            if(users.get(user).equals(pass)){
                response.sendRedirect("labs");
            }
            else
                error(request, response, "Incorrect password!");

        }else
            error(request,response,"Username "+user+" doesn't exist!");

    }

    @Override
    protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        doGet(reqest,response);
    }

    void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
        PrintWriter out= response.getWriter();
        out.println("<font color=red>"+message+"</font>");
        rd.include(request, response);
    }
}
