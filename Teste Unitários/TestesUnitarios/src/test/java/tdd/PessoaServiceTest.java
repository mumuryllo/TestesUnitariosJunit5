package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testes.IPessoaService;
import testes.Pessoa;
import testes.PessoaService;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testando a Classe de Pessoa")
public class PessoaServiceTest {

    private Pessoa pessoa;
    private IPessoaService service;

    @BeforeEach
    void iniciando(){
        service = new PessoaService();
        pessoa = new Pessoa(
                "Muryllo",
                "Soares",
                "muryllo@gmail.com",
                "Masculino"
        );
    }

    @Test
    void DeveAdicionarPessoa(){
        Pessoa atual= service.createPessoa(pessoa);
        assertNotNull(atual,()-> "Pessoa não deve ter dados vazios!");
    }

    @Test
    void verificandoONomeDaPessoa(){
        Pessoa atual = service.createPessoa(pessoa);
        assertEquals(pessoa.getNome(),atual.getNome());
    }

    @Test
    void verificandoOSobreNomeDaPessoa(){
        Pessoa atual = service.createPessoa(pessoa);
        assertEquals(pessoa.getSobrenome(),atual.getSobrenome());
    }

    @Test
    void verificandoOEmailDaPessoa(){
        Pessoa atual = service.createPessoa(pessoa);
        assertEquals(pessoa.getEmail(),atual.getEmail());
    }

    @Test
    void verificandoOGeneroDaPessoa(){
        Pessoa atual = service.createPessoa(pessoa);
        assertEquals(pessoa.getGenero(),atual.getGenero());
    }

    @Test
    void verificandoSeExisteOIdDaPessoa(){
        Pessoa atual = service.createPessoa(pessoa);
        assertNotNull(pessoa.getId(), String.valueOf(atual.getId()));
    }

    @Test
    void emailObrigatorio(){
        pessoa.setEmail(null);

       IllegalArgumentException ilegal = assertThrows(IllegalArgumentException.class,()->{
            service.createPessoa(pessoa);
        });

        assertEquals("Email não deve ser nulo ou vazio!",ilegal.getMessage());

    }

}
