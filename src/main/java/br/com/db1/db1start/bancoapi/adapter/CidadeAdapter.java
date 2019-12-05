package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.CidadeInputDTO;
import br.com.db1.db1start.bancoapi.dto.CidadeViewDTO;
import br.com.db1.db1start.bancoapi.dto.EstadoViewDTO;
import br.com.db1.db1start.bancoapi.entity.Cidade;

public class CidadeAdapter {

	public static CidadeViewDTO transformaCidadeParaViewDTO(Cidade cidade) {
		CidadeViewDTO cidadeDTO =  new CidadeViewDTO();
		EstadoViewDTO estadoDTO = new EstadoViewDTO();
		
		estadoDTO = EstadoAdapter.transformaEstadoParaViewDTO(cidade.getEstado());
		
		cidadeDTO.setId(cidade.getId());
		cidadeDTO.setNome(cidade.getNome());
		cidadeDTO.setEstado(estadoDTO);
		
		return cidadeDTO;
	}
	
	public static Cidade transformaInputDTOParaCidade(CidadeInputDTO cidadeDTO) {
		Cidade cidade = new Cidade();
		
		cidade.setNome(cidadeDTO.getNome());
		cidade.setEstado(cidadeDTO.getEstado());
		
		return cidade;
	}

}
