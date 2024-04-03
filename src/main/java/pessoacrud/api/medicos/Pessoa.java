package pessoacrud.api.medicos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pessoacrud.api.endereco.Endereco;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

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