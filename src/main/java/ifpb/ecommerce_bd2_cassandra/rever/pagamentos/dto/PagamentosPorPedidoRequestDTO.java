package ifpb.ecommerce_bd2_cassandra.rever.pagamentos.dto;

import java.math.BigDecimal;

public record PagamentosPorPedidoRequestDTO(
        String tipo,
        BigDecimal total
) {}
