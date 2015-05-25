package controller;

import model.Acervo;
import view.View;

/**
 * Created by Isabela on 24/03/2015.
 */
public class SuperLancamento implements Multa {

    private Acervo model;
    private View tela;

    public SuperLancamento(View tela, Acervo model){
        this.tela = tela;
        this.model = model;
    }

    public void calcularMulta(){
        tela.displayMultaSuperLancamento();
    }
}
