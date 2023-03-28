package booking;


import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/create")
public class CustomerDetailsDriver extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String customer_id=req.getParameter("customer_id");
		int customer_id1=Integer.parseInt(customer_id);
		
		String customer_name=req.getParameter("customer_name");
		
		
		String email=req.getParameter("email");
		
		String phone_number=req.getParameter("phone_number");
		long phone_number1=Long.parseLong(phone_number);
		
		String booking_id=req.getParameter("booking_id");
		int booking_id1=Integer.parseInt(booking_id);
		
		String created_time=req.getParameter("created_time");
		
		String drone_shot_name=req.getParameter("drone_shot_name");
		
		CustomerDetails c=new CustomerDetails();
		c.setCustomer_id(customer_id1);
		c.setCustomer_name(customer_name);
		c.setEmail(email);
		c.setPhone_number(phone_number1);
		c.setBooking_id(booking_id1);
		c.setCreated_time(created_time);
		c.setDrone_shot_name(drone_shot_name);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathameshk");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Your Details Are Submited");
		RequestDispatcher rd=req.getRequestDispatcher("SelectionPage.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
	
	
}

