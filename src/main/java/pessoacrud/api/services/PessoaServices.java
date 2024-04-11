package pessoacrud.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pessoacrud.api.endereco.DadosCadastroEndereco;
import pessoacrud.api.pessoas.*;
import pessoacrud.api.repository.PessoaRepository;

import java.util.Optional;


@Service
public class PessoaServices implements PessoaInterface {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private EnderecoServices enderecoServices;

    @Override
    public Pessoa buscarPorId(Long id) {
        Optional<Pessoa> pessoaOptional = repository.findById(id);
        return pessoaOptional.orElseThrow(()-> new RuntimeException("Não achou a pessoa"));
    }

    public DadosCadastrosPessoas cadastrarPessoa(DadosCadastrosPessoas dados) {
        Pessoa pessoa = new Pessoa(dados);
        pessoa = repository.save(pessoa); //Salvando a pessoa e recebendo o objeto com o ID gerado

        for (DadosCadastroEndereco enderecoDados : dados.endereco()) {
            enderecoServices.cadastrarEndereco(enderecoDados, pessoa); //passando a pessoa para associar ao endereço
        }

        return dados;
    }

    public Page<DadosListagemPessoa> listar(Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemPessoa::new);
    }

    public void atualizacao(DadosAtualizacaoPessoas dados) {
        Optional<Pessoa> pessoaOptional = repository.findById(dados.id());
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            pessoa.atualizarInformacoes(dados);
            repository.save(pessoa);

        }
    }
    public void excluir(Long id){
        repository.deleteById(id);
    }

}