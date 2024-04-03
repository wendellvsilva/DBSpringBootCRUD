package pessoacrud.api.medicos;

public record DadosListagemPessoa(Long id, String nome, String cpf, String dataNascimento) {
    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento());
    }
}