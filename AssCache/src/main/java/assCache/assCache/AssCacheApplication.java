package assCache.assCache;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
@ComponentScan("assCache.assCache")
public class AssCacheApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssCacheApplication.class, args);
	}
}
