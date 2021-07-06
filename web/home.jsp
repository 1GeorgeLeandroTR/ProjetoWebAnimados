<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Usuario" %>
<jsp:useBean id="User" type="Model.Usuario" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
             
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="apresentacao">
            <h4>nome: ${STRnome}</h4>
            <h4>cpf: ${STRcpf}</h4>
        </div>
        <h3> <a href="configurar">Configura perfil </a> </h3>
        <video controls class="my-videos">
            <source src="jujutsu-kaisen-opening-2-vivid-vice.mp4">
        </video> 
        <div class="tabelas">

            <table class="table table-bordered table-hover my-table">
                ${User.setCount(0)}
                <h1 class="text-sm-center">Tabela de usuários inscritos </h1>
                <%                     
                    for(int i=0; i<Usuario.getContaTotal();){%>
                <tr> <td> ${User.totalNome}<%i++;%></td> <td>${User.totalNome}<%i++;%></td> <td>${User.totalNome}<%i++;%></td> </tr>
                <%}%>              
                
                        <audio controls style="width: auto;">
                            <source src="white-lies.mp3"> 
                        </audio>
                    
                
            </table>
        </div>
    </body>
</html>
