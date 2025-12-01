package ifpb.ecommerce_bd2_cassandra.rever.pagamentos.service;

import ifpb.ecommerce_bd2_cassandra.rever.GenericService;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model.PagamentosPorPedido;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model.PagamentosPorPedidoKey;
import ifpb.ecommerce_bd2_cassandra.rever.pagamentos.repository.PagamentosPorPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.rever.pagamentos.mapper.PagamentosPorPedidoMapper.toPagamentosPorPedidoKey;

@Service
public class PagamentosPorPedidoService implements GenericService<PagamentosPorPedido, UUID> {

    private final PagamentosPorPedidoRepository pagamentosPorPedidoRepository;

    public PagamentosPorPedidoService(PagamentosPorPedidoRepository pagamentosPorPedidoRepository) {
        this.pagamentosPorPedidoRepository = pagamentosPorPedidoRepository;
    }

    @Override
    public PagamentosPorPedido salvar(PagamentosPorPedido entidade) {
        return pagamentosPorPedidoRepository.save(entidade);
    }

    @Override
    public PagamentosPorPedido procurar(UUID partitionKey, Object... clusteringKeys) {
        PagamentosPorPedidoKey pagamentosPorPedidoKey = toPagamentosPorPedidoKey(partitionKey, (UUID) clusteringKeys[0]);
        return pagamentosPorPedidoRepository.findById(pagamentosPorPedidoKey).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deletar(UUID partitionKey, Object... clusteringKeys) {
        PagamentosPorPedidoKey pagamentosPorPedidoKey = toPagamentosPorPedidoKey(partitionKey, (UUID) clusteringKeys[0]);
        pagamentosPorPedidoRepository.deleteById(pagamentosPorPedidoKey);
    }

    @Override
    public List<PagamentosPorPedido> listar(UUID partitionKey) {
        return pagamentosPorPedidoRepository.findByPagamentosPorPedidoKeyPedidoId(partitionKey);
    }
}
