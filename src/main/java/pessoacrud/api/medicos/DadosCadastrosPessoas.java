package pessoacrud.api.medicos;

import jakarta.validation.constraints.NotBlank;
import pessoacrud.api.endereco.DadosEndereco;

public record DadosCadastrosPessoas(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        String dataNascimento,
        DadosEndereco endereco) {
}
