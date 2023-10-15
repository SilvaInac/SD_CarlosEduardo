package br.inatel.labs.labjpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.service.ProdutoService;

@SpringBootTest
class DataLoader {

	@Autowired
	private ProdutoService produtoService;
	@Test
	void load() {
		//1.produto
		Produto p1 = new Produto("Furadeira");
		Produto p2 = new Produto("Lixadeira");
		Produto p3 = new Produto("Plaina");
		Produto p4 = new Produto("Tupia");
		Produto p5 = new Produto("Serra Circular");
		
		p1 = produtoService.salvart(p1);
		p2 = produtoService.salvart(p2);
		p3 = produtoService.salvart(p3);
		p4 = produtoService.salvart(p4);
		p5 = produtoService.salvart(p5);
		
		List<Produto> produtos = produtoService.listar()
;
		produtos.forEach(System.out::print);
		
	}

}
