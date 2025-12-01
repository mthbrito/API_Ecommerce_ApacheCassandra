package ifpb.ecommerce_bd2_cassandra.pedido.controller;

import ifpb.ecommerce_bd2_cassandra.pedido.dto.*;
import ifpb.ecommerce_bd2_cassandra.pedido.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/ecommerce/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> cadastrarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.cadastrarPedido(pedidoRequestDTO));
    }

    //pedidos_por_cliente
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<List<PedidoPorClienteResponseDTO>> buscarPedidosPorCliente(@PathVariable UUID clienteId) {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorCliente(clienteId));
    }

    //pedidos_por_status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<PedidoPorStatusResponseDTO>> buscarPedidosPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorStatus(status));
    }

    //produtos_por_pedido
    @GetMapping("{pedidoId}/produtos")
    public ResponseEntity<List<ProdutoPorPedidoResponseDTO>> buscarProdutosPorPedido(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok(pedidoService.buscarProdutosPorPedido(pedidoId));
    }


}
