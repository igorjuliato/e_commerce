package demo.sistemaCliente.Service.RegarDeLocal;


import demo.sistemaCliente.Dtos.DtoResponseApiViacep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepCliente {

    private final RestTemplate restTemplate;

    public ViaCepCliente(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DtoResponseApiViacep.Request buscarPorCidade(String cep){
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        return restTemplate.getForObject(url, DtoResponseApiViacep.Request.class);
    }

}
