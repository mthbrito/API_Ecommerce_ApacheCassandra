package ifpb.ecommerce_bd2_cassandra.rever.produtos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("produtos_por_pedido")
public class ProdutosPorPedido {

    @PrimaryKey
    ProdutosPorPedidoKey produtosPorPedidoKey;
    @Column("quantidade")
    private Integer quantidade;
    @Column("preco")
    private BigDecimal preco;

}
