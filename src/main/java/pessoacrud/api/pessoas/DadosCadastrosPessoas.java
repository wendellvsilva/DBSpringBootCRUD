package pessoacrud.api.pessoas;

import jakarta.validation.constraints.NotBlank;
import pessoacrud.api.endereco.DadosCadastroEndereco;
import java.util.List;


public record DadosCadastrosPessoas(

        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        String dataNascimento,
        List<DadosCadastroEndereco> endereco) {

        @Override
        public Long id() {
                return id;
        }

        @Override
        public String nome() {
                return nome;
        }

        @Override
        public String cpf() {
                return cpf;
        }

        @Override
        public String dataNascimento() {
                return dataNascimento;
        }

        @Override
        public List<DadosCadastroEndereco> endereco() {
                return endereco;
        }
}

