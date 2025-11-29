package ifpb.ecommerce_bd2_cassandra.pagamentos.controller;

import ifpb.ecommerce_bd2_cassandra.pagamentos.dto.PagamentosPorPedidoRequestDTO;
import ifpb.ecommerce_bd2_cassandra.pagamentos.service.PagamentosPorPedidoService;
import ifpb.ecommerce_bd2_cassandra.pagamentos.model.PagamentosPorPedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.pagamentos.mapper.PagamentosPorPedidoMapper.toPagamentosPorPedido;

@RestController
@RequestMapping("api/ecommerce")
public class PagamentosPorPedidoController {

    private final PagamentosPorPedidoService pagamentosPorPedidoService;

    public PagamentosPorPedidoController(PagamentosPorPedidoService pagamentosPorPedidoService) {
        this.pagamentosPorPedidoService = pagamentosPorPedidoService;
    }

    @PostMapping("/pedidos/{pedidoId}/pagamentos")
    public ResponseEntity<PagamentosPorPedido> salvar(@PathVariable UUID pedidoId, @RequestBody PagamentosPorPedidoRequestDTO dto) {
        PagamentosPorPedido pagamentosPorPedido = toPagamentosPorPedido(pedidoId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentosPorPedidoService.salvarPagamento(pagamentosPorPedido));
    }

    @GetMapping("/pedidos/{pedidoId}/pagamentos/{dataPagamento}")
    public ResponseEntity<PagamentosPorPedido> procurarPagamentosPorPedido(@PathVariable Instant dataPagamento, @PathVariable UUID pedidoId) {
        return ResponseEntity.ok(pagamentosPorPedidoService.procurarPagamento(dataPagamento, pedidoId));
    }

    @DeleteMapping("/pedidos/{pedidoId}/pagamentos/{dataPagamento}")
    public ResponseEntity<Void> deletarPagamentosPorPedido(@PathVariable String dataPagamento, @PathVariable UUID pedidoId) {
        pagamentosPorPedidoService.deletarPagamento(dataPagamento, pedidoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/pedidos/{pedidoId}/pagamentos")
    public ResponseEntity<PagamentosPorPedido> listarPagamentosPorPedido(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok(pagamentosPorPedidoService.listarPagamentos(pedidoId));
    }

}
