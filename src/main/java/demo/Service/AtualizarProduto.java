package demo.Service;

import demo.Dtos.DtoAtualizar;
import demo.Repository.ProdutoRepository;
import demo.domain.Produto;
import demo.mapper.ProdutoMapper;
import infra.execepitionsPedidoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtualizarProduto {

    @Autowired
    private static ProdutoRepository repository;

    @Autowired
    private static ProdutoMapper mapper;

    @Transactional
    public void atualizar(DtoAtualizar.Request dto) {
        Produto produto = repository.findById(dto.getId())
                .orElseThrow(() -> new execepitionsPedidoNaoEncontrado("seu Produto não foi encontrado"));

        mapper.atualizar(dto, produto);

       repository.save(produto);
    }
}
