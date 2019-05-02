package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import it.contrader.converter.UsersConverter;
//import it.contrader.dto.UsersDTO;
import it.contrader.service.UsersServiceDTO;
import it.contrader.model.Team;
import it.contrader.service.TeamServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class TeamServlet extends HttpServlet {
	
	private final TeamServiceDTO teamServiceDTO = new TeamServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("team", null);

		if (request != null) {
//			System.out.println(request.getParameter("richiesta").toString());
			if(request.getParameter("richiesta").toString().equals("createTeam")) {
				
				final String info = request.getParameter("info").toString();
				Team team = new Team();
				team.setInfo(info);
				teamServiceDTO.createTeam(team);
				getServletContext().getRequestDispatcher("/trainerTeamCreate.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("deleteTeam")) { 
				final int id_team = Integer.parseInt(request.getParameter("id_team"));
				teamServiceDTO.delete(id_team);
				getServletContext().getRequestDispatcher("/trainerTeamDelete.jsp").forward(request, response);
			}
			
			else if(request.getParameter("richiesta").toString().equals("updateTeam")) {
				 String info = request.getParameter("info").toString();
				final int id_team = Integer.parseInt(request.getParameter("id_team"));
				Team team = new Team(id_team, info);
				teamServiceDTO.updateTeam(team);
				//teamServiceDTO.updateTeam(Integer.parseInt(request.getParameter("id_team")), "info");
				getServletContext().getRequestDispatcher("/trainerTeamUpdate.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("assignTeam")) {
				int id_player=Integer.parseInt(request.getParameter("id_player"));
				int id_team=Integer.parseInt(request.getParameter("id_team"));
				final Team teamToAssign = new Team(id_team,id_player);
				teamServiceDTO.assignTeam(teamToAssign);
				getServletContext().getRequestDispatcher("/homeTrainer.jsp").forward(request, response);
			}
		}
	}
//
//	private final UsersServiceDTO usersServiceDTO = new UsersServiceDTO();
//	private List<UsersDTO> allUsers= new ArrayList<>();
//
//	@Override
//	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		final String scelta = request.getParameter("richiesta");
//		final HttpSession session = request.getSession(true);
//
//		switch (scelta) {
//
//		case "UsersManager":
//			allUsers = this.usersServiceDTO.getAllUsers();
//			request.setAttribute("allUsers", allUsers);
//			getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
//			break;			
//
//		case "insert":
//			final Integer id = Integer.parseInt(request.getParameter("id"));
//			final String username = request.getParameter("username");
//			final String password = request.getParameter("password");
//			final String ruolo = request.getParameter("ruolo");
//			final UsersDTO users = new UsersDTO(id,username, password, ruolo);
//			usersServiceDTO.insertUsers(users);
//			showAllUsers(request, response);
//			break;
//					
//		case "update":
//			System.out.println("id: "+Integer.parseInt(request.getParameter("id")));
//			System.out.println("username: "+request.getParameter("username"));
//			System.out.println("password: "+request.getParameter("password"));
//			System.out.println("ruolo: "+request.getParameter("ruolo"));
//
//		     	
//			final Integer idUpdate = Integer.parseInt(request.getParameter("id"));
//			final String usernameUpdate = request.getParameter("username");
//			final String passwordUpdate = request.getParameter("password");
//			final String ruoloUpdate = request.getParameter("ruolo");
//			final UsersDTO user = new UsersDTO(idUpdate, usernameUpdate,passwordUpdate, ruoloUpdate);
//					
//				
//					
//			usersServiceDTO.updateUsers(user);
//			showAllUsers(request, response);
//			break;
//
//		case "delete":
//			final Integer idUpdat = Integer.parseInt(request.getParameter("id"));
//			
//			final UsersDTO use = new UsersDTO(idUpdat,"" ,"","");
//			usersServiceDTO.deleteUsers(use);
//			showAllUsers(request, response);
//			break;
//
//		case "Indietro":
//			response.sendRedirect("home.jsp");
//			break;
//
//		case "LogsMenu":
//			response.sendRedirect("homeLogs.jsp");
//			break;
//
//				}
//
//			}
//
//		
//
//	
//
//private void showAllUsers(HttpServletRequest request, HttpServletResponse response)
//		throws ServletException, IOException {
//	allUsers = this.usersServiceDTO.getAllUsers();
//	request.setAttribute("allUsers", allUsers);
//	getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
//}
}
