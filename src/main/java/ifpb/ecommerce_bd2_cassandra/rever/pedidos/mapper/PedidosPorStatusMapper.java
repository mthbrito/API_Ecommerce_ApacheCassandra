package ifpb.ecommerce_bd2_cassandra.rever.pedidos.mapper;

import ifpb.ecommerce_bd2_cassandra.rever.pedidos.dto.PedidosPorStatusRequestDTO;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatus;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatusKey;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class PedidosPorStatusMapper {

    public PedidosPorStatusMapper() {
    }

    public static PedidosPorStatus toPedidosPorStatus(PedidosPorStatusRequestDTO pedidosPorStatusRequestDTO) {
        PedidosPorStatusKey pedidosPorStatusKey =  new PedidosPorStatusKey(
                pedidosPorStatusRequestDTO.status(),
                UUID.randomUUID()
        );
        return new PedidosPorStatus(
                pedidosPorStatusKey,
                Instant.now(),
                pedidosPorStatusRequestDTO.clienteId()
        );
    }

    public static PedidosPorStatusKey toPedidosPorStatusKey(String status, UUID clienteId) {
        return new PedidosPorStatusKey(
                status,
                clienteId
        );
    }
}
