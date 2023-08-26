package testes;

import java.util.concurrent.atomic.AtomicLong;

public class PessoaService implements IPessoaService{

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {

        if (pessoa.getEmail() == null || pessoa.getEmail().isBlank()){
            throw new IllegalArgumentException("Email não deve ser nulo ou vazio!");
        }

        Long id = new AtomicLong().incrementAndGet();
        pessoa.setId(id);
        return pessoa;
    }
}
