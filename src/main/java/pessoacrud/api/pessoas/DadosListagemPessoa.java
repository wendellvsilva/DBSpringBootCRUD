package pessoacrud.api.pessoas;

import java.util.List;

public record DadosListagemPessoa(Long id, String nome, String cpf, String dataNascimento, List<pessoacrud.api.endereco.Endereco> endereco) {
    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.getEndereco());
    }
}