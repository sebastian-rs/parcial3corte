<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.esquema"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dao.Conexion"%>
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
        <h1>Tablas</h1>
        <img src="logo.PNG" border="4"  width="300" height="260"/>  
      

    </center>



    <center>
        <table >
            <tr >
                <th><strong>ID</strong></th>
                <th><strong>NOMBRE</strong></th>

            </tr>
            <form action="tabla" method="post"> 
            <tr >

                <td><input class="contact" type="text" name="ID" value="" /></td>
                <td><input class="contact" type="text" name="NOMBRE" value="" /></td>
                <td ><input style="background-color: #ffff33" class="submit" type="submit" name="crear"  value="Crear " onClick="value = 1" > <td> 
                <td> <input style="background-color: #ffff33" class="submit" type="submit" name="modificar"  value="Modificar" onClick="value = 2" > <td>
                <td> <input style="background-color: #ffff33" class="submit" type="submit" name="eliminar"  value="Eliminar" onClick="value = 3" > <td>
            
            </form>
            </tr>


        </table>

        <p>&nbsp;</p>


        <table >
            <tr>
                <td> <a href="Columna.jsp"> <input style="background-color: #33ffff" class="submit" type="submit" name="venta_registrada" value="Crear Columna" /> </td>
                <td> <a href="List.jsp" ><input style="background-color: #33ffff" class="submit" type="submit" name="venta_registrada" value="Listar todo" /> </td>              
                <td> <a href="About.jsp" ><input style="background-color: #33ffff" class="submit" type="submit" name="venta_registrada" value="About" /> </td>
            </tr>
        </table>

    </center>




</body>
</html>
