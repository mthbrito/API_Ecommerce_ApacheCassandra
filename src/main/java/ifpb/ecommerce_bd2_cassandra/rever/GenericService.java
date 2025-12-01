package ifpb.ecommerce_bd2_cassandra.rever;

import java.util.List;

public interface GenericService<T, PK> {

    T salvar(T entidade);

    T procurar(PK partitionKey, Object... clusteringKeys);

    void deletar(PK partitionKey, Object... clusteringKeys);

    List<T> listar(PK partitionKey);
}

