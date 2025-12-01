package ifpb.ecommerce_bd2_cassandra.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Produto {
    private UUID produtoId;
    private String nome;
    private String categoria;
    private int quantidade;
    private BigDecimal preco;
}
