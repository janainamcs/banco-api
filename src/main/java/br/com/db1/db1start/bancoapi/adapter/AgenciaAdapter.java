package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.AgenciaInputDTO;
import br.com.db1.db1start.bancoapi.dto.AgenciaViewDTO;
import br.com.db1.db1start.bancoapi.dto.CidadeViewDTO;
import br.com.db1.db1start.bancoapi.entity.Agencia;
import br.com.db1.db1start.bancoapi.entity.Cidade;

public class AgenciaAdapter {

	public static AgenciaViewDTO transformaAgenciaParaViewDTO(Agencia agencia) {
		AgenciaViewDTO agenciaDTO =  new AgenciaViewDTO();
		CidadeViewDTO cidadeDTO = CidadeAdapter.transformaCidadeParaViewDTO(agencia.getCidade());
		
		agenciaDTO.setId(agencia.getId());
		agenciaDTO.setNumero(agencia.getNumero());
		agenciaDTO.setNumBanco(agencia.getNumeroBanco());
		agenciaDTO.setCidade(cidadeDTO);
		
		return agenciaDTO;
	}
	
	public static Agencia transformaInputDTOparaAgencia(AgenciaInputDTO agenciaDTO) {
		Agencia agencia =  new Agencia();
		Cidade cidade = CidadeAdapter.transformaInputDTOParaCidade(agenciaDTO.getCidadeDTO());
		
		agencia.setNumero(agenciaDTO.getNumero());
		agencia.setNumeroBanco(agenciaDTO.getNumBanco());
		agencia.setCidade(cidade);
		
		return agencia;
	}

}
