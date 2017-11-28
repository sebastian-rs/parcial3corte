<%@page import="Vo.Application"%>
<%@page import="Dao.Crud_Application"%>
<%@page import="Vo.Columna"%>
<%@page import="Vo.Tabla"%>
<%@page import="Vo.Esquema"%>
<%@page import="java.util.List"%>
<%@page import="Dao.Crud_Columna2"%>
<%@page import="Dao.Crud_tablas"%>
<%@page import="Dao.Crud_esquemas"%>
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
        <h1>Lista</h1>
        <img src="logo.PNG" border="4"  width="300" height="260"/>  


        <h1>-----------------------------NAME-------------Descripcion     </h1>
        <h2>ID-----------------------------NAME-------------FOREING ID     </h2>

        <%

            Crud_Application app = new Crud_Application();
            Crud_esquemas esq = new Crud_esquemas();
            Crud_tablas tab = new Crud_tablas();
            Crud_Columna2 col = new Crud_Columna2();
            List<Application> application1 = app.findAll();
            List<Esquema> esquemas = esq.findAll();
            List<Tabla> tablas = tab.findAll();
            List<Columna> columnas = col.findAll();

            for (int i2 = 0; i2 < application1.size(); i2++) {
                out.println("<h1>" + application1.get(i2).getName() + "----" + application1.get(i2).getDecription() + "</h1>");

                for (int i = 0; i < esquemas.size(); i++) {
                    out.println("<h1>" + esquemas.get(i).getIdEsquema() + "----" + esquemas.get(i).getNameEsquema() + "</h1>");
                    for (int j = 0; j < tablas.size(); j++) {
                        if (esquemas.get(i).getIdEsquema() == tablas.get(j).getDesicion()) {
                            out.println("<h1> " + tablas.get(j).getIdTabla() + "----" + tablas.get(j).getNameTabla() + "----" + tablas.get(j).getDesicion() + "</h1>");
                        }

                    }

                    for (int j = 0; j < columnas.size(); j++) {

                        if (tablas.get(j).getIdTabla() == columnas.get(j).getDesicion()) {
                            out.println("<h1> " + columnas.get(j).getIdColumna() + "----" + columnas.get(j).getNameColumna() + "----" + columnas.get(j).getDesicion() + "</h1>");
                        }

                    }

                }
            }

        %>




    </center>


</body>
</html>
