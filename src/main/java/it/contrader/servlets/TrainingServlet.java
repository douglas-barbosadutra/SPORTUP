package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.model.Player;
import it.contrader.model.Training;
import it.contrader.model.TrainingCard;
import it.contrader.service.TrainingServiceDTO;


/**
 * La servlet si occupa di parlare con la JSP e utilizza i servizi opportuni.
 * Per chi farà User dovrà anche occuparsi del Login che abbiamo lasciato come struttura e va modificata in modo opportuno
 *
 */
public class TrainingServlet extends HttpServlet {
	
	private final TrainingServiceDTO trainingServiceDTO = new TrainingServiceDTO();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final HttpSession session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			if(request.getParameter("richiesta").toString().equals("createTraining")) {
				String info = request.getParameter("info");
				Training training = new Training(info);
				trainingServiceDTO.createTraining(training);
				getServletContext().getRequestDispatcher("/trainerTraining.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("createTrainingCard")) {
				int id_training = Integer.parseInt(request.getParameter("id_training"));
				TrainingCard t_card = new TrainingCard();
				t_card.setId_training(id_training);
				t_card.setMonday(request.getParameter("monday"));
				t_card.setTuesday(request.getParameter("tuesday"));
				t_card.setWednesday(request.getParameter("wednesday"));
				t_card.setThursday(request.getParameter("thursday"));
				t_card.setFriday(request.getParameter("friday"));
				t_card.setSaturday(request.getParameter("saturday"));
				t_card.setSunday(request.getParameter("sunday"));
				trainingServiceDTO.createTrainigCardFull(t_card);
				getServletContext().getRequestDispatcher("/trainerTraining.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("deleteTrainingCard")) {
				int id_training_card = Integer.parseInt(request.getParameter("id_training_card"));
				int id_training = Integer.parseInt(request.getParameter("id_training"));
				TrainingCard t_card = new TrainingCard();
				t_card.setId_training(id_training);
				t_card.setId_training_card(id_training_card);
				trainingServiceDTO.deleteTrainingCard(t_card);
				getServletContext().getRequestDispatcher("/trainerTraining.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("updateTrainingCard")) {
				int id_training = Integer.parseInt(request.getParameter("id_training"));
				int id_training_card = Integer.parseInt(request.getParameter("id_training_card"));
				TrainingCard t_card = new TrainingCard();
				t_card.setId_training(id_training);
				t_card.setId_training_card(id_training_card);
				t_card.setMonday(request.getParameter("monday"));
				t_card.setTuesday(request.getParameter("tuesday"));
				t_card.setWednesday(request.getParameter("wednesday"));
				t_card.setThursday(request.getParameter("thursday"));
				t_card.setFriday(request.getParameter("friday"));
				t_card.setSaturday(request.getParameter("saturday"));
				t_card.setSunday(request.getParameter("sunday"));
				trainingServiceDTO.updateTrainingCard(t_card);
				getServletContext().getRequestDispatcher("/trainerTraining.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("updateTraining")) {
				int id_training = Integer.parseInt(request.getParameter("id_training"));
				String info = request.getParameter("info_training");
				Training training = new Training();
				training.setTrainingId(id_training);
				training.setInfo(info);
				trainingServiceDTO.updateTraining(training);
				getServletContext().getRequestDispatcher("/trainerTraining.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("deleteTraining")) {
				int id_training = Integer.parseInt(request.getParameter("id_training"));
				trainingServiceDTO.deleteTraining(id_training);
				getServletContext().getRequestDispatcher("/trainerTraining.jsp").forward(request, response);
			}
			else if(request.getParameter("richiesta").toString().equals("assignTraining")) {
				int id_training = Integer.parseInt(request.getParameter("id_training"));
				int id_player = Integer.parseInt(request.getParameter("id_player"));
				Training training = new Training();
				training.setPlayerId(id_player);
				training.setTrainingId(id_training);
				trainingServiceDTO.assignTraining(training);
				getServletContext().getRequestDispatcher("/trainerTraining.jsp").forward(request, response);
			}
			
		}
	}
}
