package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NotaCompra {
	
	private Long id;
	
	private LocalDate dataEmissao;
	
	
	private Fornecedor fornecedor;
	
	private List<NotaCompraItem> listaNotaCompraItem;
	
	//Calcula o total da nota somando os totais de cada item
	
	public BigDecimal getCalculoTotalNota() {
		BigDecimal totalNota = listaNotaCompraItem.stream()
			.map( i -> i.getCalculoTotalItem() )
			.reduce( BigDecimal.ZERO,BigDecimal::add);
		
		return totalNota;
	}

}
