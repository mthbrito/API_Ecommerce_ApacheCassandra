package ifpb.ecommerce_bd2_cassandra.produtos.controller;

import ifpb.ecommerce_bd2_cassandra.produtos.dto.ProdutosPorPedidoRequestDTO;
import ifpb.ecommerce_bd2_cassandra.produtos.service.ProdutosPorPedidoService;
import ifpb.ecommerce_bd2_cassandra.produtos.model.ProdutosPorPedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.produtos.mapper.ProdutosPorPedidoMapper.toProdutosPorPedido;

@RestController
@RequestMapping("api/ecommerce")
public class ProdutosPorPedidoController {

    private final ProdutosPorPedidoService ProdutosPorPedidoService;

    public ProdutosPorPedidoController(ProdutosPorPedidoService ProdutosPorPedidoService) {
        this.ProdutosPorPedidoService = ProdutosPorPedidoService;
    }

    @PostMapping("/pedidos/{pedidoId}/produtos")
    public ResponseEntity<ProdutosPorPedido> salvarProdutosPorPedido(@PathVariable UUID pedidoId, @RequestBody ProdutosPorPedidoRequestDTO ProdutosPorPedidoRequestDTO) {
        ProdutosPorPedido ProdutosPorPedido = toProdutosPorPedido(pedidoId, ProdutosPorPedidoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutosPorPedidoService.salvar(ProdutosPorPedido));
    }

    @GetMapping("/pedidos/{pedidoId}/produtos/{produtoId}")
    public ResponseEntity<ProdutosPorPedido> procurarProdutosPorPedido(@PathVariable UUID pedidoId, @PathVariable UUID produtoId) {
        return ResponseEntity.ok(ProdutosPorPedidoService.procurar(pedidoId, produtoId));
    }

    @DeleteMapping("/pedidos/{pedidoId}/produtos/{produtoId}")
    public ResponseEntity<Void> deletarProdutosPorPedido(@PathVariable UUID pedidoId, @PathVariable UUID produtoId) {
        ProdutosPorPedidoService.deletar(pedidoId, produtoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pedidos/{pedidoId}/produtos")
    public ResponseEntity<List<ProdutosPorPedido>> listarProdutosPorPedido(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok().body(ProdutosPorPedidoService.listar(pedidoId));
    }

}
