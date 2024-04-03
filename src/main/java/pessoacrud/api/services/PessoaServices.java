package pessoacrud.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pessoacrud.api.medicos.*;


@Service
public class PessoaServices {

    @Autowired
    private PessoaRepository repository;

    public DadosCadastrosPessoas cadastrarPessoa  (DadosCadastrosPessoas dados) {
        Pessoa pessoa = new Pessoa(dados);
        repository.save(pessoa);
        return dados;

    }
    public Page<DadosListagemPessoa> listar(Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemPessoa::new);
    }

    public void atualizacao(DadosAtualizacaoPessoas dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }
    public void excluir(Long id){
        repository.deleteById(id);
    }
}