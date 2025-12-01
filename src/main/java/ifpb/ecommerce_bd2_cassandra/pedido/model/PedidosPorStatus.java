package ifpb.ecommerce_bd2_cassandra.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("pedidos_por_status")
public class PedidosPorStatus {
    @PrimaryKey
    private PedidosPorStatusKey pedidosPorStatusKey;
    @Column("data_pedido")
    private Instant dataPedido;
    @Column("cliente_id")
    private UUID clienteId;
}
