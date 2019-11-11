package com.appuf.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appuf.config.EnvironmentProperties;
import com.appuf.model.dao.UnidadeFederativaDAO;
import com.appuf.model.dto.UnidadeFederativaDTO;
import com.appuf.model.entity.UnidadeFederativa;

@Service
public class UnidadeFederativaService {
	
	@Autowired
	private UnidadeFederativaDAO unidadeFederativaDAO;
	
	@Autowired
	private ModelMapper modelMapper; // dependencia utilizada para converter entity para dto
	
	public UnidadeFederativaDTO inserir(UnidadeFederativaDTO ufDTO) {
		
		UnidadeFederativa uf = convertToEntity(ufDTO);

		// Por seguranca, cria um novo objeto caso se tenha passado o atributo id na requisicao
		UnidadeFederativa ufInserida = new UnidadeFederativa();
		ufInserida.setNomeEstado(uf.getNomeEstado());
		ufInserida.setUf(uf.getUf());
		ufInserida.setDataCadastro(getDateFromTimeZoneId());

		unidadeFederativaDAO.saveAndFlush(ufInserida);

		return convertToDto(ufInserida);
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeFederativaDTO> listar() {
		
		List<UnidadeFederativa> ufs = unidadeFederativaDAO.findAllByOrderByIdDesc();
		
		List<UnidadeFederativaDTO> ufDTOs = ufs.stream()
				.map(uf -> convertToDto(uf))
				.collect(Collectors.toList());
		
		return ufDTOs;
	}
	
	/** 
	 * Retorna a data e hora atual de uma timezone (fuso horario) definida 
	 * como uma propriedade de configuracao. Util para evitar que a time 
	 * zone da data a ser inserida/atualizada seja a do servidor.
	 * 
	 * Web Source: https://stackoverflow.com/questions/19431234/converting-between-java-time-localdatetime-and-java-util-date 
	 * 
	 * @return Date
	 */
	private Date getDateFromTimeZoneId() {
		
		String timezoneProperty = EnvironmentProperties.getProperty("timezone");
		
		// caso propriedade timezone nao tenha um valor, eh usada a timezone do servidor
		ZoneId timezone = (timezoneProperty != null && !timezoneProperty.isEmpty())
				? ZoneId.of(timezoneProperty) : ZoneId.systemDefault();

		// converter LocalDateTime atual com timezone para Date
        LocalDateTime localDateTime = LocalDateTime.now(timezone);
        Date dateNow = java.sql.Timestamp.valueOf(localDateTime);
        
        return dateNow;
	}
	
	/* ==== Conversores ==== */
	
	/** 
	 * Converter entity para dto 
	 * 
	 * @return UnidadeFederativaDTO
	 */
	private UnidadeFederativaDTO convertToDto(UnidadeFederativa uf) {
		UnidadeFederativaDTO ufDTO = modelMapper.map(uf, UnidadeFederativaDTO.class);
		return ufDTO;
	}

	/** 
	 * Converter dto para entity 
	 *  
	 * @return UnidadeFederativa
	 */
	private UnidadeFederativa convertToEntity(UnidadeFederativaDTO ufDTO) {
		UnidadeFederativa uf = modelMapper.map(ufDTO, UnidadeFederativa.class);
		return uf;
	}

}
