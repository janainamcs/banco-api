package br.com.db1.db1start.bancoapi.service;

import br.com.db1.db1start.bancoapi.entity.Estado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EstadoServiceTest {

    @Autowired
    private EstadoService estadoService;

    @Test
    public void deve_criar_um_estado() {
        String nomeEsperado = "Mato Grosso";
        Estado estado = estadoService.criar(nomeEsperado);
        Assertions.assertEquals(estado.getNome(), nomeEsperado);
    }

}
