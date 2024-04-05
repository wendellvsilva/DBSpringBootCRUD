package pessoacrud.api.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoacrud.api.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    private String rua;

    private int numero;

    private String bairro;

    private String cidade;
    private String estado;
    private String cep;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "enderecos_pessoas",
            joinColumns = { @JoinColumn(name = "enderecos_fk") },
            inverseJoinColumns = { @JoinColumn(name = "pessoas_fk") }
    )
   /* @JoinColumn(name = "pessoa_id", )*/
    private Pessoa pessoa;


    public Endereco(DadosEndereco dados) {
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.estado = dados.estado();


    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.rua() != null) {
            this.rua = dados.rua();
        }
        if (dados.numero() != 0) {//não pode colocar null em int
            this.numero = dados.numero();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.estado() != null) {
            this.estado = dados.estado();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
    }
}


