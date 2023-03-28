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
@WebServlet("/CDelete")
public class CustomerDelete  extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("prathameshk");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			CustomerDetails c=em.find(CustomerDetails.class,Integer.parseInt(req.getParameter("customer_id")));
			
			et.begin();
			em.remove(c);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("Customer deleted successfully");
			RequestDispatcher rd=req.getRequestDispatcher("OperationOnCustomer.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}

	}


