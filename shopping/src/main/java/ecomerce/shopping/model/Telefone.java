package ecomerce.shopping.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TELEFONE")
public class Telefone extends BaseModel{

    @Column(name = "DDD", nullable = false)
    private String ddd;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contato contato;
}
