package pessoacrud.api.pessoas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoacrud.api.endereco.Endereco;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long id;

    @NotBlank
    private String nome;

    private int idade;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private List<Endereco> endereco = new ArrayList<>();


    @NotBlank
    private String cpf;

    private String dataNascimento;


    public Pessoa(DadosCadastrosPessoas dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
    }

    public void atualizarInformacoes(DadosAtualizacaoPessoas dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }


    }
}