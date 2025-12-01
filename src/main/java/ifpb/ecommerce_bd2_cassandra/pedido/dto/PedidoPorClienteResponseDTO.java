package ifpb.ecommerce_bd2_cassandra.pedido.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record PedidoPorClienteResponseDTO(
        UUID pedidoId,
        String status,
        Instant dataPedido,
        BigDecimal total
) {}
