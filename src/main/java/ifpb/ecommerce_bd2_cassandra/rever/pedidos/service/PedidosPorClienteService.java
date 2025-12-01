package ifpb.ecommerce_bd2_cassandra.rever.pedidos.service;

import ifpb.ecommerce_bd2_cassandra.rever.GenericService;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorCliente;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorClienteKey;
import ifpb.ecommerce_bd2_cassandra.pedido.repository.PedidosPorClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.rever.pedidos.mapper.PedidosPorClienteMapper.toPedidosPorClienteKey;

@Service
public class PedidosPorClienteService implements GenericService<PedidosPorCliente, UUID> {

    private final PedidosPorClienteRepository pedidosPorClienteRepository;

    public PedidosPorClienteService(PedidosPorClienteRepository pedidosPorClienteRepository) {
        this.pedidosPorClienteRepository = pedidosPorClienteRepository;
    }

    @Override
    public PedidosPorCliente salvar(PedidosPorCliente entidade) {
        return pedidosPorClienteRepository.save(entidade);
    }

    @Override
    public PedidosPorCliente procurar(UUID partitionKey, Object... clusteringKeys) {
        PedidosPorClienteKey pedidosPorClienteKey = toPedidosPorClienteKey(partitionKey, (UUID) clusteringKeys[0]);
        return pedidosPorClienteRepository.findById(pedidosPorClienteKey).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deletar(UUID partitionKey, Object... clusteringKeys) {
        PedidosPorClienteKey pedidosPorClienteKey = toPedidosPorClienteKey(partitionKey, (UUID) clusteringKeys[0]);
        pedidosPorClienteRepository.deleteById(pedidosPorClienteKey);
    }

    @Override
    public List<PedidosPorCliente> listar(UUID partitionKey) {
        return pedidosPorClienteRepository.findByPedidosPorClienteKeyClienteId(partitionKey);
    }

}
