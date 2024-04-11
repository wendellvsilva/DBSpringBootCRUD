package pessoacrud.api.pessoas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    @Test
    void testConstrutorComDados() {
        Pessoa pessoa = new Pessoa(new DadosCadastrosPessoas(
                null,
                "João",
                "12345678900",
                "1990-01-01",
                List.of()
        ));

        assertEquals("João", pessoa.getNome());
        assertEquals("12345678900", pessoa.getCpf());
        assertEquals("1990-01-01", pessoa.getDataNascimento());
    }

    @Test
    void testAtualizarInformacoes() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        pessoa.setIdade(25);
        pessoa.setCpf("98765432100");
        pessoa.setDataNascimento("1995-01-01");

        DadosAtualizacaoPessoas dadosAtualizacao = new DadosAtualizacaoPessoas(
                pessoa.getId(),
                "Ana"
        );

        pessoa.atualizarInformacoes(dadosAtualizacao);

        assertEquals("Ana", pessoa.getNome());
        assertEquals(25, pessoa.getIdade());
        assertEquals("98765432100", pessoa.getCpf());
        assertEquals("1995-01-01", pessoa.getDataNascimento());
    }
}