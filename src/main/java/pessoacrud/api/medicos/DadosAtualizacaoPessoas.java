package pessoacrud.api.medicos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoas(
        @NotNull
        Long id,
        String nome) {
}