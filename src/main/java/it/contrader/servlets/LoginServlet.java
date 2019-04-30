package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.UserDTO;
import it.contrader.service.UsersServiceDTO;
import it.contrader.utils.Request;

public class LoginServlet extends HttpServlet {

	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			final String nomeUtente = request.getParameter("username").toString();
			final String password = request.getParameter("password").toString();
			// recuperiamo l'utente
			final Request r = usersServiceDTO.login(nomeUtente, password);

			if (r != null)
			// verifichiamo che tipo di ruolo ha all'interno dell'applicazione
			// e lo reindirizziamo nella jsp opportuna
			
			switch (r.get("type").toString()) {
			case "admin":
				getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
				break;
			case "trainer":
				getServletContext().getRequestDispatcher("/homeTrainer.jsp").forward(request, response);
				break;
			case "player":
				getServletContext().getRequestDispatcher("/homePlayer.jsp").forward(request, response);
				break;
			default:
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
		}
	}

}
