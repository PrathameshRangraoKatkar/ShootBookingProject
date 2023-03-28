
<%@page import="booking.*"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="booking.*"%>
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
<style type="text/css">
label{
    width:100px;
    display:inline-block;
}
#form{
     border-radius:10px;
     background:black;
     color:white;
     width:290px;
     padding:4px;
     }
     h2{
     text-align:center;
     }
     #submit{
     width:100%;
     margin-top:10px;
     }
     body{
background-image: url('https://thumbs.dreamstime.com/b/drone-professional-flight-gps-83829913.jpg');
background-repeat: no-repeat;
background-size: cover;
background-attachment: fixed;
}
     
</style>
</head>
<body>
<%
String customer_id=request.getParameter("customer_id");
int customer_id1=Integer.parseInt(customer_id);
EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathameshk");
EntityManager em=emf.createEntityManager();
CustomerDetails c=em.find(CustomerDetails.class, customer_id1);
if(c==null)
{
	PrintWriter pw=response.getWriter();
	pw.write("No Customer Found");
	RequestDispatcher rd=request.getRequestDispatcher("UpdateCustomer.html");
	rd.include(request, response);
}	
%>
<div id="form">
<h2>You can Delete </h2>
<form action="CDelete" method="post">
        <label> customer_id</label>
	    <input type="number" value="<%=c.getCustomer_id()%>" name="getCustomer_id"><br><br>
	    <label>customer_name</label>
		<input type="text" value="<%=c.getCustomer_name()%>" name="Customer_name"><br><br>
		<label>email</label>
		<input type="text" value="<%=c.getEmail()%>" name="Email"><br><br>
		<label>phone_number</label>
		<input type="number" value="<%=c.getPhone_number()%>" name="Phone_number"><br><br>
		<label>drone_shot_name</label>
		<input type="text" value="<%=c.getDrone_shot_name()%>" name="drone_shot_name"><br><br>
			<label>booking_id</label>
		<input type="text" value="<%=c.getBooking_id()%>" name="booking_id"><br><br>
		<label>created_time</label>
		<input type="text" value="<%=c.getCreated_time()%>" name="created_time"><br><br>
	
	
		<input type="submit" value="Delete" id="submit">
	</form>
</div>
</body>
</html>