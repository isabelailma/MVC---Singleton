package view;

import com.sun.org.apache.xpath.internal.SourceTree;
import controller.Busca;
import controller.Multa;
import controller.Relatorio;
import model.Filme;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Isabela on 24/03/2015.
 */
public class View implements Observer {

    private Busca busca;
    private Multa multa;
    private Relatorio relatorio;
    private List lista;
    private String resultMulta;

    //Construtor
    public View(){
        lista = new LinkedList();
    };

    //Sets da Interface
    public void setBusca(Busca busca){
        this.busca = busca;
    }

    public void setMulta(Multa multa){
        this.multa = multa;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    //Display's Busca
    public void displayBuscaNome(){
        if(!lista.isEmpty()){
            for(Object each: lista){
                Filme filme = (Filme)each;
                System.out.println("***View de Busca por Nome***");
                System.out.println(each);
                System.out.println("-------------");
            }
        } else {
            System.out.println("Nao foi encontrado nenhum filme com esse nome!");
        }
    }

    public void displayBuscaAno(){
        if(!lista.isEmpty()){
            for(Object each: lista){
                Filme filme = (Filme)each;
                System.out.println("***View de Busca por Ano***");
                System.out.println(each);
                System.out.println("-------------");
            }
        } else {
            System.out.println("Nao foi encontrado nenhum filme nesse ano!");
        }
    }

    //Display's Multa
    public void displayMultaCatalogo(){
        Double converte = Double.parseDouble(resultMulta);
        System.out.println("***View de Multa Catálogo***");
        System.out.printf("Multa Catálogo: R$%.2f\n", converte);
        System.out.println("-------------");
    }

    public void displayMultaLancamento(){
        Double converte = Double.parseDouble(resultMulta);
        System.out.println("***View de Multa Lançamento***");
        System.out.printf("Multa Catálogo: R$%.2f\n", converte);
        System.out.println("-------------");
    }

    public void displayMultaSuperLancamento(){
        Double converte = Double.parseDouble(resultMulta);
        System.out.println("***View de Multa Super Lançamento***");
        System.out.printf("Multa Catálogo: R$%.2f\n", converte);
        System.out.println("-------------");
    }

    //Display's Relatório
    public void displayRelatorioDisponivel(){
        if(!lista.isEmpty()){
            for(Object each: lista){
                Filme filme = (Filme)each;
                System.out.println("***Relatório Disponível***");
                System.out.println(each);
                System.out.println("-------------");
            }
        } else {
            System.out.println("Nao foi encontrado nenhum registo Disponível!");
        }
    }

    public void displayRelatorioLocado(){
        if(!lista.isEmpty()){
            for(Object each: lista){
                Filme filme = (Filme)each;
                System.out.println("***Relatório Locado***");
                System.out.println(each);
                System.out.println("-------------");
            }
        } else {
            System.out.println("Nao foi encontrado nenhum registo Locado!");
        }
    }

    //Updates
    public void updateAdd(String mensagem){

    }

    public void updateBusca(List resultados){
        lista = resultados;
        busca.buscar();
    }

    public void updateMulta(String valor) {
        resultMulta = valor;
        multa.calcularMulta();
    }

    public void updateRelatorio(List resultados){
        lista = resultados;
        relatorio.gerarRelatorio();
    }
}
