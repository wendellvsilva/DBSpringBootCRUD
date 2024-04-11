package pessoacrud.api.endereco;


public record DadosCadastroEndereco(Long id,
                                    String rua,
                                    int numero,
                                    String bairro,
                                    String cidade,
                                    String estado,
                                    String cep) {
}