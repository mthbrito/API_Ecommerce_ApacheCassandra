package ifpb.ecommerce_bd2_cassandra.rever.produtos.repository;

import ifpb.ecommerce_bd2_cassandra.rever.produtos.model.ProdutosPorPedido;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.model.ProdutosPorPedidoKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutosPorPedidoRepository extends CassandraRepository<ProdutosPorPedido, ProdutosPorPedidoKey> {
    List<ProdutosPorPedido> findByProdutosPorPedidoKeyPedidoId(UUID pedidoId);
}
