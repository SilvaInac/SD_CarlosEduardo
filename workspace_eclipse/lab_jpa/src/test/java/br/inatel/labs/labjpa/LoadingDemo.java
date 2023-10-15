package br.inatel.labs.labjpa;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.service.NotaCompraService;

@SpringBootTest
public class LoadingDemo {

	@Autowired
	private NotaCompraService service;
	
	@Test
	public void demoEagerLoading() {
		try {
			NotaCompraItem item = service.buscarNotaCompraItemPeloId(1L);
			LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();
			System.out.println(dataEmissao);
			System.out.println("Aconteceu o carregamento EAGER");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
