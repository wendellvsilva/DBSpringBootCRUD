package pessoacrud.api.pessoas;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoas(
        @NotNull
        Long id,
        String nome) {
}