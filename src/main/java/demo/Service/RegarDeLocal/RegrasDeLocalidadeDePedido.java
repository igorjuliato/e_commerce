package demo.Service.RegarDeLocal;

import demo.Dtos.DtoPedido;
import demo.Dtos.DtoResponseApiViacep;
import infra.RegiaoInvalida;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RegrasDeLocalidadeDePedido {

    private final ViaCepCliente viaCepCliente;

    public RegrasDeLocalidadeDePedido(ViaCepCliente viaCepCliente) {
        this.viaCepCliente = viaCepCliente;
    }

    public void NaoEntregaNoLocal(DtoPedido.Request dto){
        var response = viaCepCliente.buscarPorCidade(dto.getCep());

        if(response.regiao() != "Nordeste"){
           throw new RegiaoInvalida("so fazemos pedidos na região do nordeste");
        }
    }
}
