package ifpb.ecommerce_bd2_cassandra.pedido.mapper;

import ifpb.ecommerce_bd2_cassandra.pedido.dto.PedidoPorClienteResponseDTO;
import ifpb.ecommerce_bd2_cassandra.pedido.dto.PedidoPorStatusResponseDTO;
import ifpb.ecommerce_bd2_cassandra.pedido.dto.PedidoRequestDTO;
import ifpb.ecommerce_bd2_cassandra.pedido.dto.ProdutoPorPedidoResponseDTO;
import ifpb.ecommerce_bd2_cassandra.produto.ProdutoRequestDTO;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorCliente;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorClienteKey;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatus;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatusKey;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.model.ProdutosPorPedido;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.model.ProdutosPorPedidoKey;

import java.time.Instant;
import java.util.UUID;

public class PedidoMapper {

    public static PedidoPorClienteResponseDTO toPedidoPorClienteResponseDTO(PedidosPorCliente pedidosPorCliente) {
        return new PedidoPorClienteResponseDTO(
                pedidosPorCliente.getPedidosPorClienteKey().getPedidoId(),
                pedidosPorCliente.getStatus(),
                pedidosPorCliente.getDataPedido(),
                pedidosPorCliente.getTotal()
        );
    }

    public static PedidoPorStatusResponseDTO toPedidoPorStatusResponseDTO(PedidosPorStatus pedidosPorStatus) {
        return new PedidoPorStatusResponseDTO(
                pedidosPorStatus.getPedidosPorStatusKey().getPedidoId(),
                pedidosPorStatus.getClienteId(),
                pedidosPorStatus.getDataPedido()
        );
    }

//    public static ProdutoPorPedidoResponseDTO toProdutoPorPedidoResponseDTO(ProdutosPorPedido produtosPorPedido) {
//        return new  ProdutoPorPedidoResponseDTO(
//                produtosPorPedido.getProdutosPorPedidoKey().getProdutoId(),
//                produtosPorPedido.getQuantidade(),
//                produtosPorPedido.getPreco()
//        );
//    }

    public static PedidosPorCliente toPedidosPorCliente(UUID clienteId, UUID pedidoId, Instant dataPedido, PedidoRequestDTO pedidoRequestDTO) {
        PedidosPorClienteKey pedidosPorClienteKey = new PedidosPorClienteKey(
                clienteId,
                pedidoId
        );
        return new PedidosPorCliente(
                pedidosPorClienteKey,
                dataPedido,
                pedidoRequestDTO.status(),
                pedidoRequestDTO.total()
        );
    }

    public static PedidosPorStatus toPedidosPorStatus(UUID pedidoId, Instant dataPedido, PedidoRequestDTO pedidoRequestDTO) {
        PedidosPorStatusKey pedidosPorStatusKey =  new PedidosPorStatusKey(
                pedidoRequestDTO.status(),
                pedidoId
        );
        return new PedidosPorStatus(
                pedidosPorStatusKey,
                dataPedido,
                pedidoRequestDTO.clienteId()
        );
    }

//    public static ProdutosPorPedido toProdutosPorPedido(UUID pedidoId, ProdutoRequestDTO ProdutoRequestDTO) {
//        ProdutosPorPedidoKey ProdutosPorPedidoKey =  new ProdutosPorPedidoKey(
//                pedidoId,
//                UUID.randomUUID()
//        );
//        return new ProdutosPorPedido(
//                ProdutosPorPedidoKey,
//                ProdutoRequestDTO.quantidade(),
//                ProdutoRequestDTO.preco()
//        );
//    }
}


