package ifpb.ecommerce_bd2_cassandra.pedidos.controller;

import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorCliente;
import ifpb.ecommerce_bd2_cassandra.pedidos.dto.PedidosPorClienteRequestDTO;
import ifpb.ecommerce_bd2_cassandra.pedidos.service.PedidosPorClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.pedidos.mapper.PedidosPorClienteMapper.toPedidosPorCliente;

@RestController
@RequestMapping("api/ecommerce")
public class PedidosPorClienteController {

    private final PedidosPorClienteService pedidosPorClienteService;

    public PedidosPorClienteController(PedidosPorClienteService pedidosPorClienteService) {
        this.pedidosPorClienteService = pedidosPorClienteService;
    }

    @PostMapping("/clientes/{clienteId}/pedidos")
    public ResponseEntity<PedidosPorCliente> salvarPedidoPorCliente(@PathVariable UUID clienteId, @RequestBody PedidosPorClienteRequestDTO pedidosPorClienteRequestDTO) {
        PedidosPorCliente pedidosPorCliente = toPedidosPorCliente(clienteId, pedidosPorClienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidosPorClienteService.salvar(pedidosPorCliente));
    }

    @GetMapping("/clientes/{clienteId}/pedidos/{pedidoId}")
    public ResponseEntity<PedidosPorCliente> procurarPedidoPorCliente(@PathVariable UUID clienteId, @PathVariable UUID pedidoId) {
        return ResponseEntity.ok(pedidosPorClienteService.procurar(clienteId, pedidoId));
    }

    @DeleteMapping("/clientes/{clienteId}/pedidos/{pedidoId}")
    public ResponseEntity<Void> deletarPedidoPorCliente(@PathVariable UUID clienteId, @PathVariable UUID pedidoId) {
        pedidosPorClienteService.deletar(clienteId, pedidoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/clientes/{clienteId}/pedidos")
    public ResponseEntity<List<PedidosPorCliente>> listarPedidosPorCliente(@PathVariable UUID clienteId) {
        return ResponseEntity.ok(pedidosPorClienteService.listar(clienteId));
    }
}
