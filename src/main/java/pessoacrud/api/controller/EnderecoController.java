package pessoacrud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pessoacrud.api.endereco.DadosCadastroEndereco;
import pessoacrud.api.pessoas.Pessoa;
import pessoacrud.api.services.EnderecoServices;
import pessoacrud.api.services.PessoaInterface;
import pessoacrud.api.services.PessoaServices;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServices enderecoServices;

    @Autowired
    private PessoaServices repository;



    @PostMapping("/{pessoa_id}")
    public Pessoa cadastrarEndereco(@PathVariable Long pessoa_id, @RequestBody DadosCadastroEndereco dados) {
        return teste(repository, pessoa_id);
    }

    public Pessoa teste(PessoaInterface pessoaInterface, Long id){
        System.out.println("inutil");
        return        pessoaInterface.buscarPorId(id);

    }

}
