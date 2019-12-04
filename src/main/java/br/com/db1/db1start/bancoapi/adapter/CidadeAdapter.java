package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.CidadeViewDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoViewDTO;
import br.com.db1.db1start.bancoapi.entity.Cidade;

public class CidadeAdapter {

	public static CidadeViewDTO transformaCidadeParaViewDTO(Cidade cidade) {
		CidadeViewDTO dto =  new CidadeViewDTO();
		EstadoViewDTO estadoDTO = new EstadoViewDTO();
		
		estadoDTO = EstadoAdapter.transformaEstadoParaViewDTO(cidade.getEstado());
		
		dto.setId(cidade.getId());
		dto.setNome(cidade.getNome());
		dto.setEstado(estadoDTO);
		
		return dto;
	}

}
