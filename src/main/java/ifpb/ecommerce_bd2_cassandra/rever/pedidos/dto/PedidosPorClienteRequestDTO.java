package ifpb.ecommerce_bd2_cassandra.rever.pedidos.dto;

import java.math.BigDecimal;

public record PedidosPorClienteRequestDTO(
        String status,
        BigDecimal total
) {}
