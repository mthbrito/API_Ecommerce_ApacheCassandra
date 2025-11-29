package ifpb.ecommerce_bd2_cassandra.pedidos.repository;

import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorCliente;
import ifpb.ecommerce_bd2_cassandra.pedidos.model.PedidosPorClienteKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface PedidosPorClienteRepository extends CassandraRepository<PedidosPorCliente, PedidosPorClienteKey> {
    List<PedidosPorCliente> findByPedidosPorClienteKeyClienteId(UUID clienteId);
}
