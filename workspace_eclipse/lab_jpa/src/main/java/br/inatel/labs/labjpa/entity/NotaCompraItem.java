package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;

public class NotaCompraItem {
	
	private Long id;
	
	private BigDecimal valorCompraProduto;
	
	private Integer quantidade;
	
	
	private NotaCompra notaCompra;
	
	private Produto produto;
	
	//Calculo do total do item em tempo de execução;
	public BigDecimal getCalculoTotalItem() {
		return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
		
	}

}
