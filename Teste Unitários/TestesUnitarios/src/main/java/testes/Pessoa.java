package testes;

public class Pessoa {
    private Long id;
    private String nome, sobrenome,email,genero;


    public Pessoa() {

    }

    public Pessoa(String nome, String sobrenome, String email, String genero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.genero = genero;
    }

    public Pessoa(Long id, String nome, String sobrenome, String email, String genero) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

}
