package assCache.assCache;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assinatura {
    @Id
    private long codigoAssinatura;
    private long codigoCliente;
    private long codigoAplicativo;
    private Date dataInicio;
    private Date dataEncerramento;
}