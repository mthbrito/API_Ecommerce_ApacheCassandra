package ifpb.ecommerce_bd2_cassandra.rever.pagamentos.repository;

import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model.PagamentosPorPedido;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model.PagamentosPorPedidoKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface PagamentosPorPedidoRepository extends CassandraRepository<PagamentosPorPedido, PagamentosPorPedidoKey> {
    List<PagamentosPorPedido> findByPagamentosPorPedidoKeyPedidoId(UUID pedidoId);
}
