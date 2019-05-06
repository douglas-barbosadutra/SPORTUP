package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.LoginDAO;
import it.contrader.dao.RegisterDAO;
import it.contrader.dao.TeamDAO;

import it.contrader.converter.ConverterTeam;
import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.BiomedicalData;
import it.contrader.model.Player;
import it.contrader.utils.Request;

import it.contrader.dao.BiomedicalDataDAO;


public class BiomedicalDataServiceDTO {

	private final BiomedicalDataDAO biomedicalDataDAO;


	public BiomedicalDataServiceDTO() {
		this.biomedicalDataDAO = new BiomedicalDataDAO();
	
	}
	
	public boolean updatePlayerBData(Player player, BiomedicalData b_data) {
		return this.biomedicalDataDAO.updatePlayerBData(player, b_data);
	}
	
	public boolean deleteBiomedicalData(Player player) {
		return this.biomedicalDataDAO.deleteBiomedicalData(player);
	}
	
	public boolean insertPlayerBData(Player player, BiomedicalData b_data) {
		return this.biomedicalDataDAO.insertPlayerBData(player, b_data);
	}
	
	public BiomedicalData getPlayerBData(Player player) {
		return this.biomedicalDataDAO.getPlayerBData(player);
	}

	
	
	
}
