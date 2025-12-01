package ifpb.ecommerce_bd2_cassandra.produto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        String nome,
        String categoria,

        int quantidade,
        BigDecimal preco
) {}
