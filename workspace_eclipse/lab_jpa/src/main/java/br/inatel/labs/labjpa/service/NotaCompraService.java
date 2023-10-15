package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.repository.NotaCompraItemRepository;
import br.inatel.labs.labjpa.repository.NotaCompraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class NotaCompraService {
	
	//@PersistenceContext
	//private EntityManager em;
	//notacompra
	
	@Autowired
	private NotaCompraRepository notaCompraRepository;
	
	@Autowired
	private NotaCompraItemRepository notaCompraItemRepository;
	
	public NotaCompra salvar(NotaCompra nc) {
		//return em.merge(nc);
		return notaCompraRepository.save(nc);
	}
	
	public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
		//return em.find(NotaCompra.class, id);
		return notaCompraRepository.findById(id);
	}
	
	public NotaCompra buscarNotaCompraItemPeloIdComListaItem(Long id) {
		//NotaCompra notaCompra = em.find(NotaCompra.class,id);
		//notaCompra.getListaNotaCompraItem().size();
		//return notaCompra;
		
		Optional<NotaCompra> opNotaCompra = notaCompraRepository.findById(id);
		if(opNotaCompra.isPresent()) {
			NotaCompra notaCompra = opNotaCompra.get();
			notaCompra.getListaNotaCompraItem().size();
			return notaCompra;
		}else {
			throw new RuntimeException("Nenhuma nota encontrada");
		}
		
		
	}
	
	public List<NotaCompra> listNotaCompra(){
		//return em.createQuery("select nc from NotaCompra nc",NotaCompra.class)
		//		.getResultList();
		return notaCompraRepository.findAll();
	}
	
	//NotacompraItem
	public NotaCompraItem salvar(NotaCompraItem item) {
		//return em.merge(item);
		return notaCompraItemRepository.save(item);
	}
	
	public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
		//return em.find(NotaCompraItem.class, id);
		return notaCompraItemRepository.findById(id);
	}
		
	public List<NotaCompraItem> listaNotaCompraItems(){
		return notaCompraItemRepository.findAll();
		//return em.createQuery("select i from NotaCompraItem i",NotaCompraItem.class)
		//		.getResultList();
	}
}
