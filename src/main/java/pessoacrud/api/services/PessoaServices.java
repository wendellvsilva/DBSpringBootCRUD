package pessoacrud.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pessoacrud.api.pessoas.*;

import java.util.Optional;


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
        Optional<Pessoa> pessoaOptional = repository.findById(dados.id());//perguntar ao andré ou anderson
        if (pessoaOptional.isPresent()) {//estudar mais sobre
            Pessoa pessoa = pessoaOptional.get();
            pessoa.atualizarInformacoes(dados);
            repository.save(pessoa);

        }
    }
    public void excluir(Long id){
        repository.deleteById(id);
    }
}