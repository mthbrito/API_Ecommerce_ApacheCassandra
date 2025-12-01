package ifpb.ecommerce_bd2_cassandra.rever.pedidos.dto;

import java.util.UUID;

public record PedidosPorStatusRequestDTO(
        String status,
        UUID clienteId
) {}
