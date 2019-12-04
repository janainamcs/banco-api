package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.EstadoViewDTO;
import br.com.db1.db1start.bancoapi.entity.Estado;

public class EstadoAdapter {

	public static EstadoViewDTO transformaEstadoParaViewDTO(Estado estado) {
		EstadoViewDTO dto =  new EstadoViewDTO();
		dto.setId(estado.getId());
		dto.setNome(estado.getNome());
		return dto;
	}
}
