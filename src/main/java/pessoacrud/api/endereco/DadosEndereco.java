package pessoacrud.api.endereco;

public record DadosEndereco(Long id,
                            String rua,
                            int numero,
                            String bairro,
                            String cidade,
                            String estado,
                            String cep) {
}