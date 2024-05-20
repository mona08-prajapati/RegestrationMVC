package contoler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import util.DbUtil;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;
import dao.ProductDao;
import dao.UserDao;

/**
 * Servlet implementation class Controler
 */
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_PRODUCT = "/productDetail.jsp";
//	private static String LIST_PRODUCT1 = "/sucess.jsp";
//	private static String LIST_PRODUCT2 = "/RegistrationPage.jsp";
	private ProductDao dao;
	private UserDao dao1;
	private UserService userService=new UserService();
private HttpServletRequest request;
	
public Controler() {
	super();
	dao= new ProductDao();

	dao1= new UserDao();
	}	
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String forward=LIST_PRODUCT;
         request.setAttribute("products", dao.getAllProducts());
         RequestDispatcher view = request.getRequestDispatcher(forward);
         view.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action = request.getParameter("modalForm");
			System.out.print("Monaaaaaaaaaaaaaaaaa888888888");
			HttpSession session=request.getSession();
		 
		 if("modalFormPush".equals(action)) {
		String error1=DbUtil.validateRequest1(request);
	
        
		 User user = new User();
	      user.setFirstname(request.getParameter("firstname"));        
	      user.setLastname(request.getParameter("lastname"));
	       user.setUsername(request.getParameter("username"));
	        user.setPassword(request.getParameter("password"));
	        user.setId(request.getParameter("id"));
	        
	        
		 
		 
	        System.out.print("Monaaaaaaaaaaaaaaaaa5");
	        
	        if(error1==null) 
	        {
	        	
				 dao1.addUser(user);
				 
				 
				 if(error1==null) 
					 
				    {
					 System.out.print("Monaaaaaaaaaaaaaaaaa999999999999999999999999");
					 session.setAttribute("firstname", user.getFirstname());
						RequestDispatcher requestdispatcher1=request.getRequestDispatcher("sucess.jsp");
						requestdispatcher1.forward(request,response);
			
			
			}
				 System.out.print("Monaaaaaaaaaaaaaaaaa777777777777777");
				 session.setAttribute("error1", error1);
					RequestDispatcher requestdispatcher1=request.getRequestDispatcher("RegistrationPage.jsp");
					requestdispatcher1.include(request,response);

	        
	        }
		 }
		
		String error=DbUtil.validateRequest(request);
		System.out.print("Monaaaaaaaaaaaaaaaaaa1");
		
		
		
		if(error==null) {
			System.out.print("Monaaaaaaaaaaaaaaaaaa2");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user1=new User(username,password);
		
		 error=userService.authenticateAndPopulateUser(user1);
		
			if (error==null)
			{
				System.out.print("Monaaaaaaaaaaaaaaaaa3");
			session.setAttribute("firstname", user1.getFirstname());
			RequestDispatcher requestdispatcher=request.getRequestDispatcher("loginSucess.jsp");
			requestdispatcher.forward(request,response);
			
			}
		
		}
		        System.out.print("Monaaaaaaaaaaaaaaaaa4");
				session.setAttribute("error", error);
				RequestDispatcher requestdispatcher=request.getRequestDispatcher("loginPage.jsp");
				requestdispatcher.forward(request,response);
}}




//		  User user = new User();
//      user.setFirstname(request.getParameter("firstname"));        
//      user.setLastname(request.getParameter("lastname"));
//       user.setUsername(request.getParameter("username"));
//        user.setPassword(request.getParameter("password"));
//        user.setId(request.getParameter("id"));
//        
      
       
//        String error1=DbUtil.validateRequest1(request);
//        System.out.print("Monaaaaaaaaaaaaaaaaa5");
//        
//        if(error1==null) 
//        {
//        	
//			 dao1.addUser(user);
//			 
//			 
//			 if(error1==null) 
//				 
//			    {
//				 
//				 session.setAttribute("firstname", user.getFirstname());
//					RequestDispatcher requestdispatcher1=request.getRequestDispatcher("Sucess.jsp");
//					requestdispatcher1.forward(request,response);
//		
//		
//		}
//			
//			 session.setAttribute("error1", error1);
//				RequestDispatcher requestdispatcher1=request.getRequestDispatcher("RegistrationPage.jsp");
//				requestdispatcher1.forward(request,response);
//
//        }}}
        
//        String error1=DbUtil.validateRequest1(request);
//        if(error1==null) {
//    		String firstname=request.getParameter("firstname");
//    		String lastname=request.getParameter("lastname");
//    		String username=request.getParameter("username");
//    		User user1=new User(firstname,lastname,username);
//        }
//    		session.setAttribute("error", error1);
//			RequestDispatcher requestdispatcher1=request.getRequestDispatcher("RegistrationPage.jsp");
//			requestdispatcher.forward(request,response);
//	}
//	}


