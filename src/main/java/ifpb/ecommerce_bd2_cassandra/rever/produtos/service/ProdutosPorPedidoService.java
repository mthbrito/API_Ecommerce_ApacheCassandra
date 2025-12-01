package ifpb.ecommerce_bd2_cassandra.rever.produtos.service;

import ifpb.ecommerce_bd2_cassandra.rever.GenericService;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.model.ProdutosPorPedido;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.model.ProdutosPorPedidoKey;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.repository.ProdutosPorPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static ifpb.ecommerce_bd2_cassandra.rever.produtos.mapper.ProdutosPorPedidoMapper.toProdutosPorPedidoKey;

@Service
public class ProdutosPorPedidoService implements GenericService<ProdutosPorPedido, UUID> {

    private final ProdutosPorPedidoRepository produtosPorPedidoRepository;

    public ProdutosPorPedidoService(ProdutosPorPedidoRepository ProdutosPorPedidoRepository) {
        this.produtosPorPedidoRepository = ProdutosPorPedidoRepository;
    }

    @Override
    public ProdutosPorPedido salvar(ProdutosPorPedido entidade) {
        return produtosPorPedidoRepository.save(entidade);
    }

    @Override
    public ProdutosPorPedido procurar(UUID partitionKey, Object... clusteringKeys) {
        ProdutosPorPedidoKey produtoPorPedidoKey = toProdutosPorPedidoKey(partitionKey, (UUID) clusteringKeys[0]);
        return produtosPorPedidoRepository.findById(produtoPorPedidoKey).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deletar(UUID partitionKey, Object... clusteringKeys) {
        ProdutosPorPedidoKey produtoPorPedidoKey = toProdutosPorPedidoKey(partitionKey, (UUID) clusteringKeys[0]);
        produtosPorPedidoRepository.deleteById(produtoPorPedidoKey);
    }

    @Override
    public List<ProdutosPorPedido> listar(UUID partitionKey) {
        return produtosPorPedidoRepository.findByProdutosPorPedidoKeyPedidoId(partitionKey);
    }
}
