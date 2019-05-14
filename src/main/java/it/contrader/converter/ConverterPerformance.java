package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PerformanceDTO;
import it.contrader.model.Performance;

public class ConverterPerformance {

	public static PerformanceDTO toDTO(Performance perf) {
		PerformanceDTO perfDTO = null;
		if (perf != null) {
			perfDTO = new PerformanceDTO();
			perfDTO.setIdPerformance(perf.getIdPerformance());
			perfDTO.setMaxCorsaMin(perf.getMaxCorsaMin());
			perfDTO.setMaxAddominali(perf.getMaxAddominali());
			perfDTO.setMaxFlessioni(perf.getMaxFlessioni());
		}
		return perfDTO;
	}

	public static Performance toEntity(PerformanceDTO perfDTO) {
		Performance perf = null;
		
		if (perfDTO != null) {
			perf = new Performance();
			perf.setIdPerformance(perfDTO.getIdPerformance());
			perf.setMaxCorsaMin(perfDTO.getMaxCorsaMin());
			perf.setMaxAddominali(perfDTO.getMaxAddominali());
			perf.setMaxFlessioni(perfDTO.getMaxFlessioni());
		}
		return perf;
	}

	public static List<PerformanceDTO> toListDTO(List<Performance> list) {
		List<PerformanceDTO> listPerfDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Performance perf : list) {
				listPerfDTO.add(ConverterPerformance.toDTO(perf));
			}
		}
		return listPerfDTO;
	}

	public static List<Performance> toListEntity(List<PerformanceDTO> listPerfDTO) {
		List<Performance> list = new ArrayList<>();
		if (!listPerfDTO.isEmpty()) {
			for (PerformanceDTO perfDTO : listPerfDTO) {
				list.add(ConverterPerformance.toEntity(perfDTO));
			}
		}
		return list;
	}
}
