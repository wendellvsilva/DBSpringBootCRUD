package pessoacrud.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pessoacrud.api.endereco.DadosCadastroEndereco;
import pessoacrud.api.endereco.Endereco;
import pessoacrud.api.pessoas.Pessoa;
import pessoacrud.api.repository.EnderecoRepository;

@Service
public class EnderecoServices {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrarEndereco(DadosCadastroEndereco dados, Pessoa pessoa) {
        Endereco endereco = new Endereco(dados);
        endereco.setPessoa(pessoa);
        return enderecoRepository.save(endereco);
    }
}