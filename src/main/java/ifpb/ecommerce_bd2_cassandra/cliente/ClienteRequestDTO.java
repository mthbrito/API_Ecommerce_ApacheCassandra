package ifpb.ecommerce_bd2_cassandra.cliente;

public record ClienteRequestDTO(
        String nome,
        String email,
        String telefone,
        String endereco)
{}
