package demo.Service;

import demo.Dtos.DtoAtualizarECriarProduto;
import demo.Repository.ProdutoRepository;
import demo.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DecisaoDeAtualizarOuCriar extends CriarEAtualizarProdutos {

    @Autowired
    private ProdutoRepository repository;

    private DtoAtualizarECriarProduto.Request dtoRequeste;

    public DtoAtualizarECriarProduto.Response VerificarNoDB(DtoAtualizarECriarProduto.Request dtoRequest) {

        this.dtoRequeste = dtoRequest;

        Optional<Produto> VerificarNoDB = repository.findByNomeProduto(dtoRequest.getNomeProduto());

        if (VerificarNoDB.isPresent()) {
            return DtoAtualizarECriarProduto.Response.builder()
                    .mensagem("Produto já existe, deseja atualizar os dados dele?")
                    .acao("ATUALIZAR")
                    .build();
        } else {
            return DtoAtualizarECriarProduto.Response.builder()
                    .mensagem("Produto não existe, deseja criar")
                    .acao("CRIAR")
                    .build();
        }

    }

    public String CriarProduto(DtoAtualizarECriarProduto.RequestResposta dto) {
        if (dto.getRespostaCliente().equals("ATUALIZAR")) {
          Atualizar(dtoRequeste);
          String mensagem = "seu item " + dtoRequeste.getNomeProduto()+ " acabou de ser atualizado";
          return mensagem;
        } else {
          CriarProduto(dtoRequeste);
            String mensagem = "seu item " + dtoRequeste.getNomeProduto()+ " acabou de ser criado";
            return mensagem;
        }
    }
}
