package pessoacrud.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import pessoacrud.api.medicos.DadosAtualizacaoPessoas;
import pessoacrud.api.medicos.DadosCadastrosPessoas;
import pessoacrud.api.medicos.DadosListagemPessoa;
import pessoacrud.api.services.PessoaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pessoas")

public class PessoaController {

    @Autowired
    private PessoaServices pessoaServices;
    @PostMapping
    @Transactional
    public DadosCadastrosPessoas cadastrarMedico(@RequestBody @Valid DadosCadastrosPessoas dados) {
        return pessoaServices.cadastrarPessoa(dados);
    }

    @GetMapping
    public Page<DadosListagemPessoa> listar(@PageableDefault(size = 12, sort = {"nome"} ) Pageable pageable){
        return pessoaServices.listar(pageable);
    }

    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoPessoas dados) {
        pessoaServices.atualizacao(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        pessoaServices.excluir(id);
    }
}

