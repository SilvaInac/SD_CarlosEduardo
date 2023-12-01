package br.inatel.labs.lab_rest_client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientDeleteProdutoPeloId {

	public static void main(String[] args) {
		
		try {
		
		ResponseEntity<Void> responseEntity = WebClient.create(Constantes.BASE_URL)
			.delete()
			.uri("/produto/3")
			.retrieve()
			.toBodilessEntity()
			.block();
		
		 
		System.out.println("Produto removido");
		System.out.println("Status da resposta: " + responseEntity.getStatusCode());
		
		}catch (WebClientResponseException e) {
			System.out.println(e.getStatusCode());
		}
	}
}