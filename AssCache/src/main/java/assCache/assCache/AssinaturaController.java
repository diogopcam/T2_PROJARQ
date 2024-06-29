package assCache.assCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/ass-cache")
public class AssinaturaController {

    @Autowired
    private AssinaturaRepository repositorio;

    @Autowired
    private AssCacheProxy proxy;

/*    @GetMapping("/assinvalida/servico/{codass}")
    public Assinatura verificaAssinatura(@PathVariable long codass) throws Exception {
        //procurar no banco de dados dele

        Assinatura assinatura = repositorio.findById(codass).orElse(null);

        // retornar caso acha no banco
        if(assinatura != null) {
            return assinatura;
        }

        // caso não ache, a seguinte logica deve vai perguntar pro outro serviço sobre aquela assinatura

        HashMap<String, Long> uriVariables = new HashMap<>();

        uriVariables.put("codass", codass);

        ResponseEntity<Assinatura> response = new RestTemplate().getForEntity("http://localhost:8000/servcad/assinvalida/servico/{codass}", Assinatura.class, uriVariables);

        if( response.getStatusCode() == HttpStatus.OK){
            assinatura = response.getBody();
            System.out.println(assinatura.getCodigoAssinatura() + " " + assinatura.getCodigoAplicativo() + " " + assinatura.getCodigoCliente() + " " + assinatura.getDataInicio() + " " + assinatura.getDataEncerramento());

            repositorio.save(assinatura);
            return assinatura;
        } else return null;
    }*/

    @GetMapping("/assinvalida/servico/{codass}")
    public Assinatura verificaAssinatura(@PathVariable long codass){
        //pesquisa no banco do assCache
        Assinatura assinatura = repositorio.findById(codass).orElse(null);

        //se achar, retorna a assinatura
        if(assinatura != null) {
            return assinatura;
        }

        //se não achar, pergunta ao outro serviço sobre ela

        assinatura = proxy.verificaAssinatura(codass);

        if(assinatura != null){
            repositorio.save(assinatura);
            return assinatura;
        }
        return null;
    }
}