<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>See how the others compare</title>
</head>

<%@ page import="java.util.*" %>
<%@ page import="model.User" %>
<%@ page import="controller.Comparator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>

<% ArrayList  others  = (ArrayList)session.getAttribute("people"); 
pageContext.setAttribute("people", others);
%>
<%
  // Create an ArrayList with test data
  ArrayList list = new ArrayList();
  Map author1 = new HashMap();
  author1.put("name", "Hello");
  author1.put("id", "I");
  list.add(author1);
  Map author2 = new HashMap();
  author2.put("name", "World");
  author2.put("id", "am");
  list.add(author2);
  Map author3 = new HashMap();
  author3.put("name", "yes");
  author3.put("id", "frustrated");
  list.add(author3);
  pageContext.setAttribute("authors", list);
%>
		Here are all authors matching your search critera:
    <table>
      <TH>Name</th>
      <TH>Id</th>
      <c:forEach items="${authors}" var="current">
        <tr>
          <td><c:out value="${current.name}" /><td>
          <td><c:out value="${current.id}" /><td>
        </tr>
      </c:forEach>
    </table>
    
    
    	Here are all authors matching your search critera:
    <table>
      <TH>Name</th>
      <TH>Id</th>
      <c:forEach items="${people}" var="person">
        <tr>
          <td><c:out value="${person.realName}" /><td>
          <td><c:out value="${person.percent}" /><td>
        </tr>
      </c:forEach>
    </table>

<p>If you want to edit your profile info <a href="Profile.jsp">Edit</a></p><br>
<p><a href="logout">Logout</a></p>


</body>
</html>