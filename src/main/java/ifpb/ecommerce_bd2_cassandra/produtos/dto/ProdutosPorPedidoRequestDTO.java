package ifpb.ecommerce_bd2_cassandra.produtos.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutosPorPedidoRequestDTO(
        UUID produtoId,
        int quantidade,
        BigDecimal preco
) {}
