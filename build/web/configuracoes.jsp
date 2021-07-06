<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="User" type="Model.Usuario" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="apresentacao">
        <p><strong>Nome: </strong>${User.nome} </p>
        <p><strong>Email: </strong> ${User.email}</p>
        </div>
        <form class="form-group formulario alinha" action="mudar" method="POST">
            <input class="form-control" type="text" name="muda_nome" placeholder="mude seu nome">

            <br>
            <input class="form-control" type="text" name="muda_email" placeholder="mude seu email" >

            <br>
            <input class="form-control" type="text" name="muda_telefone" placeholder="mude seu telefone">

            <br>
            <label> Mude seu sexo:</label>
            <select class="form-control" name="muda_sexo"> 
                <option> Selecione </option>
                <option value="m">Masculino </option>
                <option value="f">Feminino </option>
            </select>
            <br>
            <button class="btn btn-primary" type="submit" place-holder="mude seu email"> mudar dados </button>
            <br>
        </form>    
    </body>
</html>
