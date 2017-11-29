
<%@page import="Vo.recolector"%>
<%@page import="java.util.List"%>
<%@page import="Dao.Crud_recolector"%>
<%@page import="java.util.Iterator"%>
<%@page import="Dao.operaciones"%>


<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Inventario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor="#ffffff" background="fondo.jpg">

    <center>
        <p>&nbsp;</p>
        <h1>Inventario</h1>
    </center>



    <center>

        <h1>  Colmena  -------- kilos</h1>

        <%

            operaciones op = new operaciones();

            Iterator it = op.listar().keySet().iterator();

            while (it.hasNext()) {
                Integer key = (Integer) it.next();
                out.println("<h1> " + op.listar().get(key) + "----------------" + key + "</h1>");

            }


        %>





        <p>&nbsp;</p>


        <table >
            <tr>
                <td> <a  href="recoleccion.jsp" ><input style="background-color: #33ffff"  class="submit" type="submit" name="Volver" value="Volver a visitar" /> </td>

            </tr>
        </table>



    </center>







</body>
</html>

