package com.udea;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            System.out.println(username);
            System.out.println(password);
            System.out.println("usuario logueado");
            //proceso de validacion de usuario y contraseña
            //redireccion a la pagina de home si todo fue exitoso
            //en caso de error llevarlo a la ventana de login indicandole el error
            response.sendRedirect("http://www.google.com");            
        }catch(Exception e){

        }
    } 
}




