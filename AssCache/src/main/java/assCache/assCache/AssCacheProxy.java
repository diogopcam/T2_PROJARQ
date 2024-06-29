package assCache.assCache;

import assCache.assCache.Assinatura;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "scaa")
public interface AssCacheProxy {
    @GetMapping("/servcad/assinvalida/servico/{codass}")
    Assinatura verificaAssinatura(@PathVariable long codass);
}
