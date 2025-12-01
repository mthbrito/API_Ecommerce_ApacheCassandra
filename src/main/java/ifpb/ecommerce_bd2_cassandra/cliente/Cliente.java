package ifpb.ecommerce_bd2_cassandra.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Cliente {
    private UUID clienteId;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}
