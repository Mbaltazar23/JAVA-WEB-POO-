<%-- 
    Document   : edit
    Created on : 05-02-2020, 13:27:01
    Author     : Arica
--%>
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
    <body>
        <div class="container"> 
            <div class="col-lg-6">
                <%
                    PersonaDao dao = new PersonaDao();
                    int id = Integer.parseInt((String) request.getAttribute("idper"));
                    Persona p = (Persona) dao.list(id);
                %>
                <h1>Modificar Persona</h1>
                <form action="Controlador">
                    DNI:<br>
                    <input class="form-control"type="text" name="txtDni" value="<%=p.getDni()%>"/><br>
                    Nombres:<br>
                    <input class="form-control" type="text" name="txtNom" value="<%=p.getNom()%>"/><br>
                    <input type="hidden" name="txtid" value="<%=p.getId()%>"/>
                    <input class="btn btn-primary"type="submit" name="accion" value="Actualizar"/>   
                    <br>
                    <a href="listar.jsp">Regresar</a>
                </form>
            </div>
        </div>    
    </body>
</body>
</html>
