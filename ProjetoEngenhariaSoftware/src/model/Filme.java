package model;

/**
 * Created by Isabela on 24/03/2015.
 */
public class Filme {

    private String nome;
    private String anoLancamento;
    private String descricao;
    private String diretor;
    private String elenco;
    private Midia midia;
    private Categoria categoria;
    private Status status;

    //Construtor
    public Filme(String nome, String anoLancamento, String descricao, String diretor, String elenco, Midia midia, Categoria categoria, Status status) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.elenco = elenco;
        this.midia = midia;
        this.categoria = categoria;
        this.status = status;
    }

    public Filme(){};

    //Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //Métodos
    //Busca
    public boolean matchesNome(String parametro){
        if(getStatus().equals(Status.LOCADO))
            return false;

        else if((nome != null) && (!nome.equals("") && (!nome.toLowerCase().equals(parametro.toLowerCase()))))
            return false;

        return true;
    }

    public boolean matchesAno(String parametro){
        if(getStatus().equals(Status.LOCADO))
            return false;

        else if((anoLancamento != null) && (!anoLancamento.equals("") && (!anoLancamento.toLowerCase().equals(parametro.toLowerCase()))))
            return false;

        return true;
    }

    //Relatório
    public boolean matchesDidponivel(){
        if((getStatus().equals(Status.LOCADO)))
            return false;
        return true;
    }

    public boolean matchesLocado(){
        if((getStatus().equals(Status.DISPONIVEL)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\nTítulo: " + getNome() + "\nAno Lancamento: " + getAnoLancamento() + "\nSinopse: " + getDescricao() + "\nDiretor: " + getDiretor() + "\nElenco: " + getElenco() + "\nMídia: " + getMidia() + "\nCategoria: " + getCategoria() + "\nStatus: " + getStatus();
    }
}
