package ifpb.ecommerce_bd2_cassandra.pedidos.dto;

import java.math.BigDecimal;

public record PedidosPorClienteRequestDTO(
        String status,
        BigDecimal total
) {}
