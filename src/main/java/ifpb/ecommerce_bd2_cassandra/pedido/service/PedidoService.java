package ifpb.ecommerce_bd2_cassandra.pedido.service;

import ifpb.ecommerce_bd2_cassandra.pedido.dto.*;
import ifpb.ecommerce_bd2_cassandra.pedido.mapper.PedidoMapper;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorCliente;
import ifpb.ecommerce_bd2_cassandra.pedido.model.PedidosPorStatus;
import ifpb.ecommerce_bd2_cassandra.pedido.repository.PedidosPorClienteRepository;
import ifpb.ecommerce_bd2_cassandra.pedido.repository.PedidosPorStatusRepository;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.model.ProdutosPorPedido;
import ifpb.ecommerce_bd2_cassandra.rever.produtos.repository.ProdutosPorPedidoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static ifpb.ecommerce_bd2_cassandra.pedido.mapper.PedidoMapper.*;

@Service
public class PedidoService {

    PedidosPorClienteRepository pedidosPorClienteRepository;
    PedidosPorStatusRepository pedidosPorStatusRepository;
    ProdutosPorPedidoRepository produtosPorPedidoRepository;

    public PedidoService(PedidosPorClienteRepository pedidosPorClienteRepository, PedidosPorStatusRepository pedidosPorStatusRepository, ProdutosPorPedidoRepository produtosPorPedidoRepository) {
        this.pedidosPorClienteRepository = pedidosPorClienteRepository;
        this.pedidosPorStatusRepository = pedidosPorStatusRepository;
        this.produtosPorPedidoRepository = produtosPorPedidoRepository;
    }

    public PedidoResponseDTO cadastrarPedido(PedidoRequestDTO pedidoRequestDTO) {
        UUID pedidoId = UUID.randomUUID();
        Instant dataPedido = Instant.now();

        PedidosPorCliente pedidosPorCliente = toPedidosPorCliente(
                pedidoRequestDTO.clienteId(),
                pedidoId,
                dataPedido,
                pedidoRequestDTO
        );
        pedidosPorClienteRepository.save(pedidosPorCliente);

        PedidosPorStatus pedidosPorStatus = toPedidosPorStatus(
                pedidoId,
                dataPedido,
                pedidoRequestDTO
        );
        pedidosPorStatusRepository.save(pedidosPorStatus);
        return new PedidoResponseDTO(
                pedidoId,
                pedidoRequestDTO.clienteId(),
                pedidoRequestDTO.status(),
                pedidoRequestDTO.total(),
                dataPedido);
    }

    public List<PedidoPorClienteResponseDTO> buscarPedidoPorCliente(UUID clienteId) {
        List<PedidosPorCliente> pedidosPorClientes = pedidosPorClienteRepository.findByPedidosPorClienteKeyClienteId(clienteId);
        return pedidosPorClientes.stream()
                .map(PedidoMapper::toPedidoPorClienteResponseDTO)
                .collect(Collectors.toList());
    }

    public List<PedidoPorStatusResponseDTO> buscarPedidoPorStatus(String status) {
        List<PedidosPorStatus> pedidosPorStatus = pedidosPorStatusRepository.findByPedidosPorStatusKeyStatus(status);
        return pedidosPorStatus.stream()
                .map(PedidoMapper::toPedidoPorStatusResponseDTO)
                .collect(Collectors.toList());
    }

//    public List<ProdutoPorPedidoResponseDTO> buscarProdutosPorPedido(UUID pedidoId) {
//        List<ProdutosPorPedido> produtosPorPedidos = produtosPorPedidoRepository.findByProdutosPorPedidoKeyPedidoId(pedidoId);
//        return produtosPorPedidos.stream()
//                .map(PedidoMapper::toProdutoPorPedidoResponseDTO)
//                .collect(Collectors.toList());
//
//    }

}
