package ifpb.ecommerce_bd2_cassandra.rever.pagamentos.controller;

import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.dto.PagamentosPorPedidoRequestDTO;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.service.PagamentosPorPedidoService;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model.PagamentosPorPedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.rever.pagamentos.mapper.PagamentosPorPedidoMapper.toPagamentosPorPedido;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentosPorPedidoService.salvar(pagamentosPorPedido));
    }

    @GetMapping("/pedidos/{pedidoId}/pagamentos/{pagamentoId}")
    public ResponseEntity<PagamentosPorPedido> procurarPagamentosPorPedido(@PathVariable UUID pedidoId, @PathVariable UUID pagamentoId) {
        return ResponseEntity.ok(pagamentosPorPedidoService.procurar(pedidoId, pagamentoId));
    }

    @DeleteMapping("/pedidos/{pedidoId}/pagamentos/{pagamentoId}")
    public ResponseEntity<Void> deletarPagamentosPorPedido(@PathVariable UUID pedidoId, @PathVariable UUID pagamentoId) {
        pagamentosPorPedidoService.deletar(pedidoId, pagamentoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/pedidos/{pedidoId}/pagamentos")
    public ResponseEntity<List<PagamentosPorPedido>> listarPagamentosPorPedido(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok(pagamentosPorPedidoService.listar(pedidoId));
    }

}
