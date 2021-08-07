<%@page import="sample.mvc.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Users user = (Users) session.getAttribute("logUser");
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
 Welcome, <%= user.getName() %></h1>
<h3>
Your Password: <%= user.getPassword() %></h3>

<form action="Controller" method="POST">
            Name <input type="text" name="txtSearch" value="" /> <br/>
            <input type="submit" value="Search" name="btAction"/>
        </form>
<button><a href="LogoutServlet">Log Out</a></button>
    </body>
    
</html>
