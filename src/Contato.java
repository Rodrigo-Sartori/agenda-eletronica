public class Contato {

    private String nome;
    private long telefone;

    public Contato() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public Contato(long telefone, String nome) {
        this.telefone = telefone;
        this.nome = nome;

    }
}
