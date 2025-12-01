package ifpb.ecommerce_bd2_cassandra.pedido.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PedidoRequestDTO(
        UUID clienteId,
        String status,
        BigDecimal total
) {}
