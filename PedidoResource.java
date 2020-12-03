package br.com.desafio.vr.beneficios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.vr.beneficios.model.PedidoListarDTO;
import br.com.desafio.vr.beneficios.model.PedidoVO;
import br.com.desafio.vr.beneficios.model.ServicePageableResponse;
import br.com.desafio.vr.beneficios.model.ServiceResponse;
import br.com.desafio.vr.beneficios.model.StatusDTO;
import br.com.desafio.vr.beneficios.model.VencimentoPedidoDTO;
import br.com.desafio.vr.beneficios.services.PedidoServices;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/pedido")
public class PedidoResource {

	@Autowired
	private PedidoServices service;
	
	@GetMapping("/{idPedido}")
	public ResponseEntity<ServiceResponse<PedidoVO>> consultar(@PathVariable("idPedido") String idPedido) {
		try {
			ServiceResponse<PedidoVO> response = service.consultar(idPedido);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Server Error: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/listar")
	public ResponseEntity<ServicePageableResponse<List<PedidoVO>>> listar(@RequestBody PedidoListarDTO pedidoListarDTO) {
		try {
			ServicePageableResponse<List<PedidoVO>> response = service.listar(pedidoListarDTO);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Server Error: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	@PostMapping
	public ResponseEntity<ServiceResponse<Void>> criar(@RequestBody PedidoVO pedido) {
		try {
			ServiceResponse<Void> response = service.criar(pedido);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Server Error: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{idPedido}")
	public ResponseEntity<ServiceResponse<Void>> alterar(
			@PathVariable("idPedido") String idPedido,
			@RequestBody PedidoVO pedido) {
		
		try {
			ServiceResponse<Void> response = service.alterar(idPedido, pedido);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Server Error: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{idPedido}")
	public ResponseEntity<ServiceResponse<Void>> excluir(
			@PathVariable("idPedido") String idPedido,
			@RequestBody PedidoVO pedido) {
		
		try {
			ServiceResponse<Void> response = service.excluir(idPedido, pedido);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Server Error: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{idPedido}/status")
	public ResponseEntity<ServiceResponse<Void>> atualizarStatus(
			@PathVariable("idPedido") String idPedido,
			@RequestBody StatusDTO statusDTO) {
		
		try {
			ServiceResponse<Void> response = service.atualizarStatus(idPedido, statusDTO);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Server Error: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{idPedido}/vencimento")
	public ResponseEntity<ServiceResponse<Void>> atualizarVencimentoPedido(
			@PathVariable("idPedido") String idPedido,
			@RequestBody VencimentoPedidoDTO vencimentoPedidoDTO) {
		
		try {
			ServiceResponse<Void> response = service.atualizarVencimentoPedido(idPedido, vencimentoPedidoDTO);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			log.error("Server Error: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
