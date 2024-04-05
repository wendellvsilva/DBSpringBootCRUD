package pessoacrud.api.pessoas;

import jakarta.validation.constraints.NotBlank;
import pessoacrud.api.endereco.DadosEndereco;
import java.util.List;
public record DadosCadastrosPessoas(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        String dataNascimento,
        List<DadosEndereco> endereco) {
}
