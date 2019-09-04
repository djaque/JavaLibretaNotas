<%-- 
    Document   : index
    Created on : 29-ago-2019, 19:17:41
    Author     : dany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cuaderno de apuntes</h1>
        <h2>Crear apuntes!</h2>
        <form method="POST" action="NotasController">
            
            <input type="text" name="name" placeholder="Clase actual"><br />
            Apuntes de la clase:<br>
            <textarea rows="4" cols="50" name="text"></textarea><br />
            <input type="submit" value="Guardar">

            
        </form>
        <hr>
          <h2>Listado de apuntes!</h2>
          
          <ul>
          <c:forEach items="${requestScope.notas}" var="item"> 
              <li> 
                  ${item.date}<br>
                  ${item.name}<br>
                  ${item.text}<br>
              </li>        
          </c:forEach>
          </ul>
        
    </body>
</html>
