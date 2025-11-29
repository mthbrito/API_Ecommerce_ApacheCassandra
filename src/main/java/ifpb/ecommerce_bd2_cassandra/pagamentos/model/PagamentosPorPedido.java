package ifpb.ecommerce_bd2_cassandra.pagamentos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.*;

import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("pagamentos_por_pedido")
public class PagamentosPorPedido {

    @PrimaryKey
    private PagamentosPorPedidoKey pagamentosPorPedidoKey;
    @Column("data_pedido")
    private Instant dataPedido;
    @Column("tipo")
    private String tipo;
    @Column("valor")
    private BigDecimal valor;

}
