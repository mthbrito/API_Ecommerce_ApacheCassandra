package ifpb.ecommerce_bd2_cassandra.pedido.repository;

import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatus;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatusKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface PedidosPorStatusRepository extends CassandraRepository<PedidosPorStatus, PedidosPorStatusKey> {
    List<PedidosPorStatus> findByPedidosPorStatusKeyStatus(String status);
}
