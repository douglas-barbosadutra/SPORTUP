package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.model.BiomedicalData;

public class ConverterBiomedicalData {

	public static BiomedicalDataDTO toDTO(BiomedicalData biomedicalData) {
		BiomedicalDataDTO biomedicalDataDTO = null;
		if (biomedicalData != null) {
			biomedicalDataDTO = new BiomedicalDataDTO();
			biomedicalDataDTO.setIdBiomedicalData(biomedicalData.getIdBiomedicalData());
			biomedicalDataDTO.setHearthbeat(biomedicalData.getHearthbeat());
			biomedicalDataDTO.setBloodPressure(biomedicalData.getBloodPressure());
			biomedicalDataDTO.setHeight(biomedicalData.getHeight());
			biomedicalDataDTO.setWeight(biomedicalData.getWeight());
			biomedicalDataDTO.setFatMass(biomedicalData.getFatMass());		
			
			biomedicalDataDTO.setFatFreeMass(biomedicalData.getFatFreeMass());
			biomedicalDataDTO.setDeleted(biomedicalData.getDeleted());
		}
		return biomedicalDataDTO;
	}

	public static BiomedicalData toEntity(BiomedicalDataDTO biomedicalDataDTO) {
		BiomedicalData biomedicalData = null;
		
		
		if (biomedicalDataDTO != null) {
			biomedicalData = new BiomedicalData();
			biomedicalData.setIdBiomedicalData(biomedicalDataDTO.getIdBiomedicalData());
			biomedicalData.setHearthbeat(biomedicalDataDTO.getHearthbeat());
			biomedicalData.setBloodPressure(biomedicalDataDTO.getBloodPressure());
			biomedicalData.setHeight(biomedicalDataDTO.getHeight());
			biomedicalData.setWeight(biomedicalDataDTO.getWeight());
			biomedicalData.setFatMass(biomedicalDataDTO.getFatMass());		
			
			biomedicalData.setFatFreeMass(biomedicalDataDTO.getFatFreeMass());
			biomedicalData.setDeleted(biomedicalDataDTO.getDeleted());
		}
		return biomedicalData;
	}

	public static List<BiomedicalDataDTO> toListDTO(List<BiomedicalData> list) {
		List<BiomedicalDataDTO> listBiomedicalDataDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (BiomedicalData biomedicalData : list) {
				listBiomedicalDataDTO.add(ConverterBiomedicalData.toDTO(biomedicalData));
			}
		}
		return listBiomedicalDataDTO;
	}

	public static List<BiomedicalData> toListEntity(List<BiomedicalDataDTO> listBiomedicalDataDTO) {
		List<BiomedicalData> list = new ArrayList<>();
		if (!listBiomedicalDataDTO.isEmpty()) {
			for (BiomedicalDataDTO biomedicalDataDTO : listBiomedicalDataDTO) {
				list.add(ConverterBiomedicalData.toEntity(biomedicalDataDTO));
			}
		}
		return list;
	}
}
