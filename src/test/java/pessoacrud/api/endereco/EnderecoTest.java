package pessoacrud.api.endereco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pessoacrud.api.pessoas.Pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoTest {

    private Endereco endereco;

    @Mock
    private Pessoa pessoa;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        endereco = new Endereco();
    }

    @Test
    public void testeGeteSEt() {
        endereco.setId(1L);
        endereco.setRua("Rua Teste");
        endereco.setNumero(123);
        endereco.setBairro("Bairro Teste");
        endereco.setCidade("Cidade Teste");
        endereco.setEstado("Estado Teste");
        endereco.setCep("12345-678");
        endereco.setPessoa(pessoa);

        assertEquals(1L, endereco.getId());
        assertEquals("Rua Teste", endereco.getRua());
        assertEquals(123, endereco.getNumero());
        assertEquals("Bairro Teste", endereco.getBairro());
        assertEquals("Cidade Teste", endereco.getCidade());
        assertEquals("Estado Teste", endereco.getEstado());
        assertEquals("12345-678", endereco.getCep());
        assertEquals(pessoa, endereco.getPessoa());
    }

    @Test
    public void testConstrutorCadastro() {
        DadosCadastroEndereco dados = new DadosCadastroEndereco(1L, "Rua Construtor", 456, "Bairro Construtor",
                "Cidade Construtor", "Estado Construtor", "98765-432");

        endereco = new Endereco(dados);

        assertEquals("Rua Construtor", endereco.getRua());
        assertEquals(456, endereco.getNumero());
        assertEquals("Bairro Construtor", endereco.getBairro());
        assertEquals("Cidade Construtor", endereco.getCidade());
        assertEquals("Estado Construtor", endereco.getEstado());
        assertEquals("98765-432", endereco.getCep());
    }
}