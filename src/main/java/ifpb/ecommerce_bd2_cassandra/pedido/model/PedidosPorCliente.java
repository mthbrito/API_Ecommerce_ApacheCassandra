package ifpb.ecommerce_bd2_cassandra.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("pedidos_por_cliente")
public class PedidosPorCliente {
    @PrimaryKey
    private PedidosPorClienteKey pedidosPorClienteKey;
    @Column("data_pedido")
    private Instant dataPedido;
    @Column("status")
    private String status;
    @Column("total")
    private BigDecimal total;
}
