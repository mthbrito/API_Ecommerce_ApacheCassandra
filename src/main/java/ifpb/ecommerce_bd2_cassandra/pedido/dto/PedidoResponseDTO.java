package ifpb.ecommerce_bd2_cassandra.pedido.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PedidoResponseDTO(
        UUID pedidoId,
        UUID clienteId,
        String status,
        BigDecimal total,
        Instant dataPedido
) {}

