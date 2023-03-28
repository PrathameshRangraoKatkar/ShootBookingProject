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
@WebServlet("/CustomerU2")
public class CustomerUpdate2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathameshk");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String customer_id=req.getParameter("Customer_id");
		String customer_name=req.getParameter("Customer_name");
		String email=req.getParameter("Email");
		String Phone_number=req.getParameter("Phone_number");
		String drone_shot_name=req.getParameter("drone_shot_name");
		String created_time=req.getParameter("created_time");
		String B_id=req.getParameter("bid");
		CustomerDetails c=new CustomerDetails();
		c.setCustomer_id(Integer.parseInt(customer_id));
		c.setCustomer_name(customer_name);
		c.setEmail(email);
		c.setPhone_number(Long.parseLong(Phone_number));
		c.setDrone_shot_name(drone_shot_name);
		c.setBooking_id(Integer.parseInt(B_id));
		c.setCreated_time(created_time);
		
		
		et.begin();
		em.merge(c);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Updated Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("OperationOnCustomer.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}

}

