package model;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import view.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Isabela on 24/03/2015.
 */
public class Acervo implements Subject{

    //SINGLETON
    private static Acervo uniqueInstance;

    private List<Observer> observers;
    private List listaFilmes;

    //Fazendo a conexão com o Banco de Dados
    ObjectContainer filmes = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "../filmes.db4o");

    //SINGLETON
    private Acervo(){
        observers = new LinkedList();
        listaFilmes = new LinkedList();
    }

    //Observers
    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    //Notify's
    public void notifyObserversAdd(){
        for(Observer each: observers){
            each.updateAdd("Filme Cadastrado com Sucesso!");
        }
    }

    public void notifyObserversBusca(List resultados) {
        for (Observer each : observers) {
            each.updateBusca(resultados);
        }
    }

    public void notifyObserversMulta(String valor){
        for (Observer each : observers){
            each.updateMulta(valor);
        }
    }

    public void notifyObserversRelatorio(List resultados){
        for(Observer each: observers) {
            each.updateRelatorio(resultados);
        }
    }

    //Métodos
    //Método que inicia o "Construtor"
    public static Acervo getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Acervo();
        }
        return uniqueInstance;
    }

    //Adicionar dados ao banco de dados
    public void adicionarFilme(Filme filme){
        filmes.store(filme);
        notifyObserversAdd();
    }

    //Buscar DB4O
    public void buscarDB4O (String parametro){
        Query query = filmes.query();
        query.descend("nome").constrain(parametro).or(query.descend("anoLancamento").constrain(parametro));
        ObjectSet resultado = query.execute();
        notifyObserversBusca(resultado);
    }

    //Multa
    public void calcularMultaCatalogo(Integer dias){
        Double multa = dias * 1.0;
        notifyObserversMulta(multa.toString());
    }

    public void calcularMultaLancamento(Integer dias){
        Double multa = dias * 2.5;
        notifyObserversMulta(multa.toString());
    }

    public void calcularMultaSuperLancamento(Integer dias){
        Double multa = dias * 5.0;
        notifyObserversMulta(multa.toString());
    }

    //Relatório DB4O
    public void gerarRelatorioDisponivelDB4O (){
        Query query = filmes.query();
        query.descend("status").constrain(Status.DISPONIVEL);
        ObjectSet resultado = query.execute();
        notifyObserversRelatorio(resultado);
    }

    public void gerarRelatorioLocadoDB4O (){
        Query query = filmes.query();
        query.descend("status").constrain(Status.LOCADO);
        ObjectSet resultado = query.execute();
        notifyObserversRelatorio(resultado);
    }
}