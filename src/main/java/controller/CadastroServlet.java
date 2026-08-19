package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")

public class CadastroServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.getWriter().write("PÁGINA DE CADASTRO FUNCIONAMDO");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.getWriter().write("CADASTRO RECEBIDO VIA POST");
    }



}
