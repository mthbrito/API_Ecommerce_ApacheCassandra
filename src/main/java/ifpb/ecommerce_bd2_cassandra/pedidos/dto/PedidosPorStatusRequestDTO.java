package ifpb.ecommerce_bd2_cassandra.pedidos.dto;

import java.util.UUID;

public record PedidosPorStatusRequestDTO(
        String status,
        UUID clienteId
) {}
