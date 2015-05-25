package controller;

import model.Acervo;
import view.View;

/**
 * Created by Isabela on 24/03/2015.
 */
public class BuscaNome implements Busca {

    private Acervo model;
    private View tela;

    public BuscaNome(View tela, Acervo model) {
        this.tela = tela;
        this.model = model;
    }

    public void buscar() {
        tela.displayBuscaNome();
    }
}