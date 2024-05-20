<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <%-- <h1><%
String error=(String)session.getAttribute("error");
if(error!=null){
	out.append(error);
	session.setAttribute("error" ,null);
}
%>
 --%>
</h1>
        
    <%-- form method="POST" action='Controler' >
       Firstname : <input type="text" name="firstname"
            value="<c:out value="${user.firstname}" />" /> <br /> 
        Lastname : <input
            type="text" name="lastname"
            value="<c:out value="${user.lastname}" />" /> <br /> 
       username : <input
            type="text" name="username"
            value="<c:out value="${user.username}" />" /> <br /> 
      
       Password: <input
            type="text" name="password"
            value="<c:out value="${user.password}" />" /> <br />
       id: <input
            type="text" name="id"
            value="<c:out value="${user.id}" />" /> <br /> <input
            type="submit" value="Submit" />
      
    </form> --%>
    <div class="modal" id="modalDialog">
    <form action="Controler" method="post">
    <input type="hidden" name="modalForm" value="modalFormPush"/>
Firstname:<input type="text"name="firstname"><br>
Lastname:<input type="text"name="lastname"><br>
username:<input type="text"name="username"><br>
Password:<input type="text"name="password"><br>
id:<input type="text"name="id"><br>
<input type="submit">
</form>
  </div>  
<a href="sucess.jsp"></a>
</body>
</html>