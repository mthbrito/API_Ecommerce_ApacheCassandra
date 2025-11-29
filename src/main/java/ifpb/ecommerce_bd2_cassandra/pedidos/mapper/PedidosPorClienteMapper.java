package ifpb.ecommerce_bd2_cassandra.pedidos.mapper;

import ifpb.ecommerce_bd2_cassandra.pedidos.dto.PedidosPorClienteRequestDTO;
import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorCliente;
import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorClienteKey;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class PedidosPorClienteMapper {

    public PedidosPorClienteMapper() {
    }

    public static PedidosPorCliente toPedidosPorCliente(UUID clienteId, PedidosPorClienteRequestDTO pedidosPorClienteRequestDTO) {
        PedidosPorClienteKey pedidosPorClienteKey = new PedidosPorClienteKey(
                clienteId,
                UUID.randomUUID()
        );
        return new PedidosPorCliente(
                pedidosPorClienteKey,
                Instant.now(),
                pedidosPorClienteRequestDTO.status(),
                pedidosPorClienteRequestDTO.total()
        );
    }

    public static PedidosPorClienteKey toPedidosPorClienteKey(UUID clienteId, UUID pedidoId) {
        return new PedidosPorClienteKey(
                clienteId,
                pedidoId
        );
    }

}









