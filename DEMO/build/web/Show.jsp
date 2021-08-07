<%-- 
    Document   : Show
    Created on : May 6, 2021, 3:57:20 PM
    Author     : ThangVo
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Show</h1>
        
          <h1>List of students</h1>
                <table border="1">

                    <tr>
                        <th>No.</th>
                        <th>User Name</th>
                        <th>Last Name</th>
                        <th>Roles</th>
                        <th>Delete</th>
                        <th>Update</th>
                        
                    </tr>
                    <c:set var ="count" value="0" />
                    <c:forEach var="tempStudent" items="${myStudents}">
                        <form action="Controller">
                        <c:set var="count" value="${count+1}" />
                        <tr>
                            <td>${count}.</td>
                              <td>${tempStudent.name}
				<input type="hidden" name="txtUsername" value="${tempStudent.name}">
				</td>
                            <td><input type="text" name="txtLast" value="${tempStudent.lastname}"></td>
                           <td>
				<input type="checkbox" name="chkAdmin" value="ADMIN"
                                       <c:if test="${tempStudent.roles}">checked</c:if> >
				</td>
                              
                            <c:url var="delete" value="Controller">
				<c:param name="btAction" value="Delete" />
				<c:param name="username" value="${tempStudent.name}" />
				<c:param name="txtSearch" value="${param.txtSearch}" />
                                       
			    </c:url>
			    <td><a href="${delete}"> Delete</a></td>
                           <td>
                               <input type="hidden" name="txtSearch" value="${param.txtSearch}">
                              
                               <input type="submit" name="btAction" value="Update">
                         
				</td>
                        </tr>
                        </form>
                    </c:forEach>

                </table>

    </body>
</html>
