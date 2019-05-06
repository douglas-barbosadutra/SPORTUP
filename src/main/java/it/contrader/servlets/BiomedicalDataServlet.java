package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.model.BiomedicalData;
import it.contrader.model.Player;
//import it.contrader.converter.UsersConverter;
//import it.contrader.dto.UsersDTO;
import it.contrader.service.BiomedicalDataServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class BiomedicalDataServlet extends HttpServlet {
	
	private final BiomedicalDataServiceDTO biomedicalDataServiceDTO = new BiomedicalDataServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);
		System.out.println(request.getParameter("richiesta"));
		
		if (request != null) {
			if(request.getParameter("richiesta").toString().equals("deleteBiomedicalData")) {
				
				System.out.println("delete");
				
				Player player = new Player(Integer.parseInt(request.getParameter("id_player")));
				biomedicalDataServiceDTO.deleteBiomedicalData(player);
				getServletContext().getRequestDispatcher("/trainerBiomedicalData.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("updateBiomedicalData")) {
					
					System.out.println("dentro" + request.getParameter("id_player"));
					
					Player player = new Player(Integer.parseInt(request.getParameter("id_player")));
					BiomedicalData b_data = new BiomedicalData();
					b_data.setBlood_pressure(Integer.parseInt(request.getParameter("blood_pressure")));
					b_data.setHearthbeat(Integer.parseInt(request.getParameter("heartbeat")));
					b_data.setHeight(Float.parseFloat(request.getParameter("height")));
					b_data.setWeight(Float.parseFloat(request.getParameter("weight")));
					b_data.setFat_mass(Float.parseFloat(request.getParameter("fat_mass")));
					b_data.setFat_free_mass(Float.parseFloat(request.getParameter("fat_free_mass")));
					
					
					biomedicalDataServiceDTO.updatePlayerBData(player, b_data);
					getServletContext().getRequestDispatcher("/trainerBiomedicalData.jsp").forward(request, response);
				}
			else if(request.getParameter("richiesta").toString().equals("insertBiomedicalData")) {
				
				System.out.println("dentro" + request.getParameter("id_player"));
				
				Player player = new Player(Integer.parseInt(request.getParameter("id_player")));
				BiomedicalData b_data = new BiomedicalData();
				b_data.setBlood_pressure(Integer.parseInt(request.getParameter("blood_pressure")));
				b_data.setHearthbeat(Integer.parseInt(request.getParameter("heartbeat")));
				b_data.setHeight(Float.parseFloat(request.getParameter("height")));
				b_data.setWeight(Float.parseFloat(request.getParameter("weight")));
				b_data.setFat_mass(Float.parseFloat(request.getParameter("fat_mass")));
				b_data.setFat_free_mass(Float.parseFloat(request.getParameter("fat_free_mass")));
				
				
				biomedicalDataServiceDTO.insertPlayerBData(player, b_data);
				getServletContext().getRequestDispatcher("/trainerBiomedicalData.jsp").forward(request, response);
			}
			
			
	}

}
}
