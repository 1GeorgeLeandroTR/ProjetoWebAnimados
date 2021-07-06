/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Usuario;
import dao.Operacoes;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mudar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
        mudanca("muda_nome", request, "nome");                
        mudanca("muda_sexo", request, "sexo");
        mudanca("muda_telefone", request, "telefone");       
        mudanca("muda_email".trim(), request, "email");        
        response.sendRedirect("index.html");
    }
    static void mudanca(String handler, HttpServletRequest request, String OqueMuda) {
        if (request.getParameter(handler) != null && request.getParameter(handler) != "") {
            String novoValor = request.getParameter(handler);
            try {
                Operacoes.atualizarAlgo(OqueMuda, novoValor, Usuario.user.getId());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(configurar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
