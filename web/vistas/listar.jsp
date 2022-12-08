<%-- 
    Document   : listar
    Created on : 05-02-2020, 13:26:40
    Author     : Arica       
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDao.PersonaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Personas</h1>
            <a class="btn btn-success"href="Controlador?accion=add">Agregar Persona</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PersonaDao dao = new PersonaDao();
                    List<Persona> list = dao.listar();
                    Iterator<Persona> inter = list.iterator();
                    Persona per = null;
                    while (inter.hasNext()) {
                        per = inter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%=per.getId()%></td>
                        <td class="text-center"><%=per.getDni()%></td>
                        <td class="text-center"><%=per.getNom()%></td>
                        <td>
                            <a class="btn btn-warning"href="Controlador?accion=edit&id=<%=per.getId()%>">Editar</a>
                            <a class="btn btn-danger"href="Controlador?accion=delete&id=<%=per.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
