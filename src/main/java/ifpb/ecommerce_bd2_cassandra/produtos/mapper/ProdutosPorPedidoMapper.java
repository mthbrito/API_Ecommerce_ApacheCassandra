package ifpb.ecommerce_bd2_cassandra.produtos.mapper;

import ifpb.ecommerce_bd2_cassandra.produtos.dto.ProdutosPorPedidoRequestDTO;
import ifpb.ecommerce_bd2_cassandra.produtos.model.ProdutosPorPedido;
import ifpb.ecommerce_bd2_cassandra.produtos.model.ProdutosPorPedidoKey;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProdutosPorPedidoMapper {

    public ProdutosPorPedidoMapper() {
    }

    public static ProdutosPorPedido toProdutosPorPedido(UUID pedidoId, ProdutosPorPedidoRequestDTO ProdutosPorPedidoRequestDTO) {
        ProdutosPorPedidoKey ProdutosPorPedidoKey =  new ProdutosPorPedidoKey(
                pedidoId,
                ProdutosPorPedidoRequestDTO.produtoId()
        );
        return new ProdutosPorPedido(
                ProdutosPorPedidoKey,
                ProdutosPorPedidoRequestDTO.quantidade(),
                ProdutosPorPedidoRequestDTO.preco()
        );
    }

    public static ProdutosPorPedidoKey toProdutosPorPedidoKey(UUID pedidoId, UUID produtoId) {
        return new ProdutosPorPedidoKey(
                pedidoId,
                produtoId
        );
    }
}
