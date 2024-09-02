package servlets;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;

import crud.CRUDEventos;

import javax.sql.DataSource;

import entities.*;

/**
 * Servlet implementation class MainController
 */
@WebServlet(urlPatterns = "*.html")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ticketsell8205")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	@Resource(name = "jdbc/mysql")

	private DataSource ds;

	private ServletContext context;

	public MainController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forwardToJSP = "Error.jsp";

		String pathAskedFor = request.getServletPath();
		System.out.print(
				"MainController >>> PATH REQUESTED: " + pathAskedFor + " REQUEST METHOD :" + request.getMethod());

		switch (pathAskedFor) {
		case "/index.html":
			forwardToJSP = "Login.jsp";
			break;
		case "/SignUpUser.html":
			forwardToJSP = registerNewUser(request, response);
			break;
		case "/LoginUser.html":
			forwardToJSP = loginUser(request, response);
			break;
		case "/LogoutUser.html":
			forwardToJSP = logoutUser(request, response);
			break;
		case "/Guest.html":
			forwardToJSP = loginAsGuest(request, response);
			break;
		case "/CreateEvent.html":
			forwardToJSP = createEventHandler(request, response);
			break;
		case "/ReadEvent.html":
			forwardToJSP = readAllEventsHandler(request, response);
			break;
		case "/UpdateEvent.html":
			forwardToJSP = updateEventHandler(request, response);
			break;
		case "/DeleteEvent.html":
			forwardToJSP = deleteEventHandler(request, response);
			break;
		case "/AdvancedSearch.html":
			forwardToJSP = recieveSearch(request, response);
			break;
		case "/PublishTickets.html":
			forwardToJSP = "";
			break;
		
		}

		// forward to JSP
		System.out.println("MainController >>> Forwarding to JSP --> " + forwardToJSP);
		RequestDispatcher rd = request.getRequestDispatcher("/" + forwardToJSP);
		rd.forward(request, response);
//		context.getRequestDispatcher("/" + forwardToJSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// Necessary methods to manage requests
	private String registerNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestMethod = request.getMethod();
		if (requestMethod == "GET") {
			return "Formulario.jsp";
		}
		Usuarios newUser = new Usuarios();

		newUser.setNombre(request.getParameter("name"));
		newUser.setAp1(request.getParameter("first_surname"));
		newUser.setAp2(request.getParameter("second_surname"));
		newUser.setTlf(Integer.parseInt(request.getParameter("phone")));
		newUser.setDir(request.getParameter("address"));
		newUser.setUsuario(request.getParameter("username"));
		newUser.setPass(request.getParameter("password"));

		try {

			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO usuarios(nombre,ap1,ap2,usuario,pass,dir,tlf,administrador) values(?,?,?,?,?,?,?)");
			ps.setString(1, newUser.getNombre());
			ps.setString(2, newUser.getAp1());
			ps.setString(3, newUser.getAp2());
			ps.setString(4, newUser.getUsuario());
			ps.setString(5, newUser.getPass());
			ps.setString(6, newUser.getDir());
			ps.setInt(7, newUser.getTlf());
			ps.setBoolean(8, false); // set to 0 as new users won't be admins
			ps.executeUpdate();
			con.close();

			request.setAttribute("user", newUser);

			return "mainPage.jsp";

		} catch (Exception e) {
			response.getWriter().append("Error in user registration:" + e.getMessage());
			System.out.print("Error in user registration:" + e.getMessage());
			return null;
		}

//		try {
//			ut.begin();
//			em.persist(newUser);
//			ut.commit();
//
//			request.setAttribute("user", newUser);
//
//			return "mainPage.jsp";
//		} catch (Exception e) {
//			response.getWriter().append("Error in user registration:" + e.getMessage());
//			System.out.print("Error in user registration:" + e.getMessage());
//			return null;
//		}
	}

	private String loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestMethod = request.getMethod();

		if (requestMethod == "GET") {
			return "Login.jsp";
		}

		try {
			Usuarios loginUser = em.find(Usuarios.class, request.getAttribute("username"));
			boolean isLoggedIn = false;

			if (loginUser.getPass().equals(request.getAttribute("password"))) {
				isLoggedIn = true;

				request.setAttribute("isLoggedIn", isLoggedIn);
				request.setAttribute("loginUser", loginUser);
				
				if(loginUser.isAdministrador() == false) {
					return "mainPage.jsp";
				} else {
					return "MainPageAdmin.jsp";
				}
				
			} else {
				isLoggedIn = false;
				String errorMsg = "Error: there is no user with such password!";

				request.setAttribute("isLoggedIn", isLoggedIn);
				request.setAttribute("errorMsg", errorMsg);

				return "Login.jsp";
			}

		} catch (Exception e) {
			response.getWriter().append("Error in user login:" + e.getMessage());
			System.out.print("Error in user login:" + e.getMessage());
			return null;
		}
	}

	private String logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			boolean isLoggedIn = false;

			request.setAttribute("isLoggedIn", isLoggedIn);

			return "Login.jsp";
		} catch (Exception e) {
			response.getWriter().append("Error in user logout:" + e.getMessage());
			System.out.print("Error in user logout:" + e.getMessage());
			return null;
		}
	}

	private String loginAsGuest(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			boolean isLoggedIn = false;
			request.setAttribute("isLoggedIn", isLoggedIn);

			return "mainPage.jsp";

		} catch (Exception e) {
			return null;
		}
	}

	/*************************/
	/* EVENTS' CRUD HANDLERS */
	/*************************/

	private String createEventHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestMethod = request.getMethod();
		if (requestMethod == "GET") {
			return "publicarEvento.jsp";
		}

		try {
			String event_title = request.getParameter("title");
			if (event_title == null) {
				System.err.println("Event title is null");
				return "publicarEvento.jsp";
			}
			String event_category = request.getParameter("category");
			if (event_category == null) {
				System.err.println("Event category is null");
				return "publicarEvento.jsp";
			}
			String event_date = request.getParameter("date");
			if (event_date == null) {
				System.err.println("Event title is null");
				return "publicarEvento.jsp";
			}
			String event_city = request.getParameter("city");
			if (event_city == null) {
				System.err.println("Event title is null");
				return "publicarEvento.jsp";
			}
			String event_room = request.getParameter("room");
			if (event_room == null) {
				System.err.println("Event title is null");
				return "publicarEvento.jsp";
			}
			String event_image = request.getParameter("image");
			if (event_image == null) {
				System.err.println("Event title is null");
				return "publicarEvento.jsp";
			}

			CRUDEventos crudEvents = new CRUDEventos(em, ut);
			Eventos newEvent = crudEvents.createEvent(event_title, event_category, event_date, event_city,
					Integer.parseInt(event_room), event_image);

			request.setAttribute("newEvent", newEvent);

			return "mainPage.jsp";

		} catch (Exception e) {
			response.getWriter().append("Error in event creation:" + e.getMessage());
			System.out.print("Error in event creation:" + e.getMessage());
			return null;
		}

	}
	
	private String recieveSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestMethod = request.getMethod();
		if (requestMethod == "GET") {
			return "publicarEvento.jsp";
		}

		try {
			String event_title = request.getParameter("title");
			String event_category = request.getParameter("category");
			String event_date = request.getParameter("date");
			String event_city = request.getParameter("city");
			String event_room = request.getParameter("room");
			String event_image = request.getParameter("image");
			if (event_title == null && event_category == null && event_date == null && event_city == null && event_room == null && event_image == null) {
				System.err.println("All inputs are null");
				return "BusquedaAvanzada.jsp";
			}
			/*
			CRUDEventos crudEvents = new CRUDEventos(em, ut);
			Eventos newEvent = crudEvents.createEvent(event_title, event_category, event_date, event_city,
					Integer.parseInt(event_room), event_image);
			request.setAttribute("newEvent", newEvent);
			*/
			//aquí está reciviendo los datos de la búsqueda, luego se comunicaría con el microservicio
			
			

			return "BusquedaAvanzada.jsp";

		} catch (Exception e) {
			response.getWriter().append("Error in event creation:" + e.getMessage());
			System.out.print("Error in event creation:" + e.getMessage());
			return null;
		}

	}

	private String readAllEventsHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestMethod = request.getMethod();
		if (requestMethod == "GET") {
			return "mainPage.jsp";
		}

		try {
			CRUDEventos crudEvents = new CRUDEventos(em, ut);
			List<Eventos> eventsList = crudEvents.getEventList();

			request.setAttribute("eventsList", eventsList);

			return "mainPage.jsp";

		} catch (Exception e) {
			response.getWriter().append("Error in events list retrieval:" + e.getMessage());
			System.out.print("Error in events list retrieval:" + e.getMessage());
			return null;
		}
	}

	private String updateEventHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestMethod = request.getMethod();
		if (requestMethod == "GET") {
			return "mainPage.jsp";
		}

		try {
			CRUDEventos crudEvents = new CRUDEventos(em, ut);
			String event_title = request.getParameter("title");
			String event_category = request.getParameter("category");
			String event_date = request.getParameter("date");
			String event_city = request.getParameter("city");
			String event_room = request.getParameter("room");
			String event_image = request.getParameter("image");
			if (crudEvents.updateEvent(event_title, event_category, event_date, event_city,
					Integer.parseInt(event_room), event_image) == true) {
				System.out.println("Successfully modified the event!");
			} else {
				String errorMsg = "There was an error modifying the event! :(";
				request.setAttribute("errorMsg", errorMsg);
				return "Error.jsp";
			}

			return "mainPage.jsp";
		} catch (Exception e) {
			response.getWriter().append("Error in event modification:" + e.getMessage());
			System.out.print("Error in event modification:" + e.getMessage());
			return null;
		}
	}

	private String deleteEventHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String requestMethod = request.getMethod();
//		if (requestMethod == "GET") {
//			return "mainPage.jsp";
//		}
		
		try {
			CRUDEventos crudEvent = new CRUDEventos(em, ut);
			String event_title = request.getParameter("title");

			if(crudEvent.deleteEvent(event_title) == true) {
				System.out.println("Successfully removed the event!");
			} else {
				String errorMsg = "There was an error removing the event! :(";
				request.setAttribute("errorMsg", errorMsg);
				return "Error.jsp";
			}
			return "mainPage.jsp";
		} catch (Exception e) {
			response.getWriter().append("Error in event deletion:" + e.getMessage());
			System.out.print("Error in event deletion:" + e.getMessage());
			return null;
		}
	}
	
	
}
