package ecomerce.shopping.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "PESSOA")
public class Pessoa extends BaseModel{

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDateTime dataFim;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    public List<Contato> contatos;

    @OneToOne(mappedBy = "pessoa")
    private PessoaFisica pf;

    @OneToOne(mappedBy = "pessoa")
    private PessoaJuridica pj;
}
