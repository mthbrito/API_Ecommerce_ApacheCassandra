package ifpb.ecommerce_bd2_cassandra.pedidos.repository;

import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorStatus;
import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorStatusKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface PedidosPorStatusRepository extends CassandraRepository<PedidosPorStatus, PedidosPorStatusKey> {
    List<PedidosPorStatus> findByPedidosPorStatusKeyStatus(String status);
}
