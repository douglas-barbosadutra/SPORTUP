package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.model.BiomedicalData;

public class ConverterBiomedicalData {

	public static BiomedicalDataDTO toDTO(BiomedicalData b_data) {
		BiomedicalDataDTO b_dataDTO = null;
		if (b_data != null) {
			b_dataDTO = new BiomedicalDataDTO();
			b_dataDTO.setId_b_data(b_data.getId_b_data());
			b_dataDTO.setBlood_pressure(b_data.getBlood_pressure());
			b_dataDTO.setDeleted(b_data.getDeleted());
			b_dataDTO.setFat_free_mass(b_data.getFat_free_mass());
			b_dataDTO.setFat_mass(b_data.getFat_mass());
			b_dataDTO.setHearthbeat(b_data.getHearthbeat());
			b_dataDTO.setHeight(b_data.getHeight());
			b_dataDTO.setWeight(b_data.getWeight());
		}
		return b_dataDTO;
	}

	public static BiomedicalData toEntity(BiomedicalDataDTO b_dataDTO) {
		BiomedicalData b_data = null;
		if (b_dataDTO != null) {
			b_data = new BiomedicalData();
			b_data.setId_b_data(b_dataDTO.getId_b_data());
			b_data.setBlood_pressure(b_dataDTO.getBlood_pressure());
			b_data.setDeleted(b_dataDTO.getDeleted());
			b_data.setFat_free_mass(b_dataDTO.getFat_free_mass());
			b_data.setFat_mass(b_dataDTO.getFat_mass());
			b_data.setHearthbeat(b_dataDTO.getHearthbeat());
			b_data.setHeight(b_dataDTO.getHeight());
			b_data.setWeight(b_dataDTO.getWeight());
		}
		return b_data;
	}

	public static List<BiomedicalDataDTO> toListDTO(List<BiomedicalData> list) {
		List<BiomedicalDataDTO> listB_dataDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (BiomedicalData b_data : list) {
				listB_dataDTO.add(ConverterBiomedicalData.toDTO(b_data));
			}
		}
		return listB_dataDTO;
	}

	public static List<BiomedicalData> toList(List<BiomedicalDataDTO> listDTO) {
		List<BiomedicalData> listB_data = new ArrayList<>();
		if (!listDTO.isEmpty()) {
			for (BiomedicalDataDTO b_dataDTO : listDTO) {
				listB_data.add(ConverterBiomedicalData.toEntity(b_dataDTO));
			}
		}
		return listB_data;
	}
}