<%@page import="Controlador.esquema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Web Sql</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor="#ffffff" background="fondo.jpg">

    <center>
        <p>&nbsp;</p>
        <h1>Bienvenido</h1>
        <img src="logo.PNG" border="4"  width="300" height="260"/>
    </center>
    <p>&nbsp;</p>

    <center>
        <table >
            <tr >
                <th><strong>USUARIO</strong></th>
                <th><strong>CONTRASENA</strong></th>
            </tr>
            <form action="Principal.jsp" method="post">
                <tr >

                    <td><input class="contact" type="text" name="usuario" value="" /></td>
                    <td><input class="contact"  type="password" name="contrasena" value="" /></td>
                    <td ><input style="background-color: #ffff33" class="submit" type="submit" name="crear"  value="Crear" onClick="value = 1" > <td>
                    <td> <input style="background-color: #ffff33" class="submit" type="submit" name="entrar"  value="entrar" onClick="value = 2" > <td>

            </form>
            </tr>

        </table>


        <%

            if (request.getAttribute("message") == null) {

            } else {
                out.println("<h1> " + request.getAttribute("message") + "</h1>");

            }


        %>





    </center>







</body>
</html>

