package br.com.db1.db1start.bancoapi.adapter;

import br.com.db1.db1start.bancoapi.dto.AgenciaViewDTO;
import br.com.db1.db1start.bancoapi.dto.CidadeViewDTO;
import br.com.db1.db1start.bancoapi.entity.Agencia;

public class AgenciaAdapter {

	public static AgenciaViewDTO transformaAgenciaParaViewDTO(Agencia agencia) {
		AgenciaViewDTO dto =  new AgenciaViewDTO();
		CidadeViewDTO cidadeDTO = new CidadeViewDTO();
		
		cidadeDTO = CidadeAdapter.transformaCidadeParaViewDTO(agencia.getCidade());
		
		dto.setId(agencia.getId());
		dto.setNumero(agencia.getNumero());
		dto.setNumBanco(agencia.getNumeroBanco());
		dto.setCidade(cidadeDTO);
		
		return dto;
	}

}
