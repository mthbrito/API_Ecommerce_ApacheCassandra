package ifpb.ecommerce_bd2_cassandra.pedido.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoPorPedidoResponseDTO(
        UUID produtoId,
        int quantidade,
        BigDecimal preco
) {}
