package controller;

import dao.Operacoes;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "cadastro", urlPatterns = {"/cadastro"})
public class cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("inscricao_nome");
        String sexo = request.getParameter("inscricao_sexo");
        String dataNascimento = request.getParameter("data_nascimento");
        String email = request.getParameter("inscricao_email").trim();
        String validarEmail = request.getParameter("inscricao_email_confirma").trim();        
        if(email.equals(validarEmail)){
            System.out.println("\n\nEmail válido");
        }
        else{
            System.out.println("\n\nEmail inválido");
        }
        String codigoPais = request.getParameter("codigo_pais");
        String numero = request.getParameter("inscricao_telefone");
        String cpf = request.getParameter("inscricao_cpf");
        String senha = request.getParameter("inscricao_senha");
        String ConfirmaSenha = request.getParameter("inscricao_senha_confirma");
        
        if(senha.equals(ConfirmaSenha)){System.out.println("\n\nSenha incorreta");}
        else{System.out.println("\n\nSenha incorreta");}
        
        try {
            Operacoes.inserir("usuario_animados",
                               nome, 
                               senha, 
                               email, 
                               sexo, 
                               dataNascimento, 
                               numero, 
                               cpf );
            String pagina = "/index.html";
            request.setAttribute("STRnome", nome);
            request.setAttribute("STRcpf", cpf);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


}
