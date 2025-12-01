package ifpb.ecommerce_bd2_cassandra.rever.pagamentos.model;

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
public class PagamentosPorPedidoKey {

    @PrimaryKeyColumn(name = "pedido_id", type = PrimaryKeyType.PARTITIONED)
    private UUID pedidoId;
    @PrimaryKeyColumn(name = "pagamento_id", type = PrimaryKeyType.CLUSTERED)
    private UUID pagamentoId;

}
