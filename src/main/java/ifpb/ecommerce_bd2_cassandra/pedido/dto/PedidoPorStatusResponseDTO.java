package ifpb.ecommerce_bd2_cassandra.pedido.dto;

import java.time.Instant;
import java.util.UUID;

public record PedidoPorStatusResponseDTO(
        UUID pedidoId,
        UUID clienteId,
        Instant dataPedido
) {}
