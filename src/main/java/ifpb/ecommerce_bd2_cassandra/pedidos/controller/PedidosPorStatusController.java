package ifpb.ecommerce_bd2_cassandra.pedidos.controller;

import ifpb.ecommerce_bd2_cassandra.pedidos.dto.PedidosPorStatusRequestDTO;
import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorStatus;
import ifpb.ecommerce_bd2_cassandra.pedidos.service.PedidosPorStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.pedidos.mapper.PedidosPorStatusMapper.toPedidosPorStatus;

@RestController
@RequestMapping("api/ecommerce")
public class PedidosPorStatusController {

    private final PedidosPorStatusService pedidosPorStatusService;

    public PedidosPorStatusController(PedidosPorStatusService pedidosPorStatusService) {
        this.pedidosPorStatusService = pedidosPorStatusService;
    }

    @PostMapping("/pedidos/status")
    public ResponseEntity<PedidosPorStatus> salvarPedidosPorStatus(@RequestBody PedidosPorStatusRequestDTO  pedidosPorStatusRequestDTO){
        PedidosPorStatus pedidosPorStatus = toPedidosPorStatus(pedidosPorStatusRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidosPorStatusService.salvarPedido(pedidosPorStatus));
    }

    @GetMapping("/pedidos/{pedidoId}/status/{status}")
    public ResponseEntity<PedidosPorStatus> procurarPedidoPorStatus(@PathVariable String status, @PathVariable UUID pedidoId) {
        return ResponseEntity.ok(pedidosPorStatusService.procurar(status, pedidoId));
    }

    @DeleteMapping("/pedidos/{pedidoId}/status/{status}")
    public ResponseEntity<Void> deletarPedidoPorStatus(@PathVariable String status, @PathVariable UUID pedidoId) {
        pedidosPorStatusService.deletar(status, pedidoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/pedidos/status/{status}")
    public ResponseEntity<List<PedidosPorStatus>> listarPedidosPorCliente(@PathVariable String status) {
        return ResponseEntity.ok(pedidosPorStatusService.listar(status));
    }

}
