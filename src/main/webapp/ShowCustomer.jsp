<%@page import="booking.CustomerDetails"%>
<%@page import="java.io.PrintWriter"%>

<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<%
String customer_id =request.getParameter("customer_id");
int customer_id1=Integer.parseInt(customer_id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathameshk");
EntityManager em=emf.createEntityManager();

CustomerDetails c=em.find(CustomerDetails.class, customer_id1);
if(c==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Customer Found");
	RequestDispatcher rd=request.getRequestDispatcher("ShowCustomer.html");
	rd.include(request, response);
}	
%>
<table align="center" cellpadding="20px" border="1">
<tr>
<th>customer_id</th>
<th>customer_name</th>
<th>email</th>
<th>phone_number</th>
<th>booking_id</th>
<th>created_time</th>
<th>drone_shot_name</th>
</tr>
<tr align="center">
<td><%=c.getCustomer_id()%></td>
<td><%=c.getCustomer_name() %></td>
<td><%=c.getEmail() %></td>
<td><%=c.getPhone_number() %></td>
<td><%=c.getBooking_id() %></td>
<td><%=c.getCreated_time() %></td>
<td><%=c.getDrone_shot_name() %></td>
</tr>
</table>
<form action="OperationOnCustomer.html" method="post">
<br>
<center>
<input type="submit"  value="Menu">

</center>
</form>
</body>
</html>