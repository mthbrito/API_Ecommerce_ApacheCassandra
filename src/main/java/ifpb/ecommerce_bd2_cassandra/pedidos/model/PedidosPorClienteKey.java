package ifpb.ecommerce_bd2_cassandra.pedidos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@PrimaryKeyClass
public class PedidosPorClienteKey {

    @PrimaryKeyColumn(name = "cliente_id", type = PrimaryKeyType.PARTITIONED)
    private UUID clienteId;
    @PrimaryKeyColumn(name = "pedido_id", type = PrimaryKeyType.CLUSTERED)
    private UUID pedidoId;

}
