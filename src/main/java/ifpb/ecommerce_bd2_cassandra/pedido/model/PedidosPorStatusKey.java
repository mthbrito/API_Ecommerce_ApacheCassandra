package ifpb.ecommerce_bd2_cassandra.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PrimaryKeyClass
public class PedidosPorStatusKey {

    @PrimaryKeyColumn(name = "status", type = PrimaryKeyType.PARTITIONED)
    private String status;
    @PrimaryKeyColumn(name = "pedido_id", type = PrimaryKeyType.CLUSTERED)
    private UUID pedidoId;

}
