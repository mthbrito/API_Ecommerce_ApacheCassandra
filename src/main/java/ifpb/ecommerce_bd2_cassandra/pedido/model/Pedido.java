package ifpb.ecommerce_bd2_cassandra.pedido.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Pedido {
    private UUID pedidoId;
    private UUID clienteId;
    private String status;
    private Instant dataPedido;
    private BigDecimal total;
}
