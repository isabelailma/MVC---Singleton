package controller;

import model.Acervo;
import view.View;

/**
 * Created by Isabela on 24/03/2015.
 */
public class BuscaAno implements Busca {

    private Acervo model;
    private View tela;

    public BuscaAno(View tela, Acervo model){
        this.tela = tela;
        this.model = model;
    }

    public void buscar(){
        tela.displayBuscaAno();
    }
}
