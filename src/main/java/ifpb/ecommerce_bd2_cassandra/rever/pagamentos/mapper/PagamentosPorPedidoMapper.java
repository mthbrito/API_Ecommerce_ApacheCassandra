package ifpb.ecommerce_bd2_cassandra.rever.pagamentos.mapper;

import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.dto.PagamentosPorPedidoRequestDTO;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model.PagamentosPorPedido;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model.PagamentosPorPedidoKey;

import java.time.Instant;
import java.util.UUID;

public class PagamentosPorPedidoMapper {

    public PagamentosPorPedidoMapper() {
    }

    public static PagamentosPorPedido toPagamentosPorPedido(UUID pedidoId, PagamentosPorPedidoRequestDTO pagamentosPorPedidoRequestDTO) {
        PagamentosPorPedidoKey pagamentosPorPedidoKey = new PagamentosPorPedidoKey(
                pedidoId,
                UUID.randomUUID()
        );
        return new PagamentosPorPedido(
                pagamentosPorPedidoKey,
                Instant.now(),
                pagamentosPorPedidoRequestDTO.tipo(),
                pagamentosPorPedidoRequestDTO.total()
        );
    }

    public static PagamentosPorPedidoKey toPagamentosPorPedidoKey(UUID pedidoId, UUID pagamentosId) {
        return new PagamentosPorPedidoKey(
                pedidoId,
                pagamentosId
        );
    }
}
