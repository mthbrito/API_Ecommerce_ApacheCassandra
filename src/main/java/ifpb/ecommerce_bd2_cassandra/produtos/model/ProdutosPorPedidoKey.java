package ifpb.ecommerce_bd2_cassandra.produtos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@PrimaryKeyClass
public class ProdutosPorPedidoKey {

    @PrimaryKeyColumn(name = "pedido_id", type = PrimaryKeyType.PARTITIONED)
    private UUID pedidoId;
    @PrimaryKeyColumn(name = "produto_id", type = PrimaryKeyType.CLUSTERED)
    private UUID produtoId;

}
