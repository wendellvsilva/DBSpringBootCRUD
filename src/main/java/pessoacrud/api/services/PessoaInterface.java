package pessoacrud.api.services;

import pessoacrud.api.pessoas.Pessoa;

public interface PessoaInterface {
    Pessoa buscarPorId(Long id);
}
