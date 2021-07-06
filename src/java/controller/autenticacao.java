/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Usuario;
import dao.Operacoes;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class autenticacao extends HttpServlet {
    
   
            //user.setNome(Operacoes.selecionarNome(login));
            //user.setId(Operacoes.selecionarID(login));


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        String page = "/home.jsp";
        try {
            if(Operacoes.verificar(login)== false ){
                page = "/index.html";                                
            }
            else{
                
            Usuario.user.setNome(Operacoes.contaAlgo("nome", "email", login));
            Usuario.user.setId(Operacoes.contaAlgo("id", "email", login));
            Usuario.user.setSexo(Operacoes.contaAlgo("sexo", "email", login));
            Usuario.user.setTelefone(Operacoes.contaAlgo("telefone", "email", login));
            Usuario.user.setEmail(login);
            
            String nome = Operacoes.contaAlgo("nome", "email", login);
            String cpf = Operacoes.contaAlgo("cpf", "email", login);
            request.setAttribute("User", Usuario.user);//REFERENCIAMOS USANDO id=User e indicamos a classe Usuario que será usada
            request.setAttribute("STRnome", nome);
            request.setAttribute("STRcpf", cpf);
            }
        } catch (SQLException ex) {
            request.setAttribute("nomeSTR", "código do erro: " + ex.getErrorCode()
                    + ", estado sql: " + ex.getSQLState()
                    + ", " + ex.toString());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            request.setAttribute("nomeSTR", "classe nao encontrada");
        }
           
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
    
}
