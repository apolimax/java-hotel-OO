public class Pessoa {
    protected String nome;
    protected byte idade;
    
    public Pessoa(String nome, byte idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}
