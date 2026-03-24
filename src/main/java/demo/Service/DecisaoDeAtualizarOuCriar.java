package demo.Service;

import demo.Dtos.DtoAtualizarECriar;
import demo.Repository.ProdutoRepository;
import demo.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DecisaoDeAtualizarOuCriar extends CriarEAtualizarProdutos {

    @Autowired
    private ProdutoRepository repository;

    private DtoAtualizarECriar.Request dtoRequeste;

    public DtoAtualizarECriar.Response VerificarNoDB(DtoAtualizarECriar.Request dtoRequest) {

        this.dtoRequeste = dtoRequest;

        Optional<Produto> VerificarNoDB = repository.findByNomeProduto(dtoRequest.getNomeProduto());

        if (VerificarNoDB.isPresent()) {
            return DtoAtualizarECriar.Response.builder()
                    .mensagem("Produto já existe, deseja atualizar os dados dele?")
                    .acao("ATUALIZAR")
                    .build();
        } else {
            return DtoAtualizarECriar.Response.builder()
                    .mensagem("Produto não existe, deseja criar")
                    .acao("CRIAR")
                    .build();
        }

    }

    public String CriarProduto(DtoAtualizarECriar.RequestResposta dto) {
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
