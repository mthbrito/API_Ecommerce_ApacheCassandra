package ifpb.ecommerce_bd2_cassandra.rever.pedidos.service;

import ifpb.ecommerce_bd2_cassandra.rever.GenericService;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatus;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatusKey;
import ifpb.ecommerce_bd2_cassandra.pedido.repository.PedidosPorStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.rever.pedidos.mapper.PedidosPorStatusMapper.toPedidosPorStatusKey;

@Service
public class PedidosPorStatusService implements GenericService<PedidosPorStatus, String> {

    private final PedidosPorStatusRepository pedidosPorStatusRepository;

    public PedidosPorStatusService(PedidosPorStatusRepository pedidosPorStatusRepository) {
        this.pedidosPorStatusRepository = pedidosPorStatusRepository;
    }

    @Override
    public PedidosPorStatus salvar(PedidosPorStatus entidade) {
        return pedidosPorStatusRepository.save(entidade);
    }

    @Override
    public PedidosPorStatus procurar(String partitionKey, Object... clusteringKeys) {
        PedidosPorStatusKey pedidosPorStatusKey = toPedidosPorStatusKey(partitionKey, (UUID) clusteringKeys[0]);
        return pedidosPorStatusRepository.findById(pedidosPorStatusKey).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deletar(String partitionKey, Object... clusteringKeys) {
        PedidosPorStatusKey pedidosPorStatusKey = toPedidosPorStatusKey(partitionKey, (UUID) clusteringKeys[0]);
        pedidosPorStatusRepository.deleteById(pedidosPorStatusKey);
    }

    @Override
    public List<PedidosPorStatus> listar(String partitionKey) {
        return pedidosPorStatusRepository.findByPedidosPorStatusKeyStatus(partitionKey);
    }
}
