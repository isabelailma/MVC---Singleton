package controller;

import model.Acervo;
import view.View;

/**
 * Created by Isabela on 24/03/2015.
 */
public class RelatorioLocado implements Relatorio{

    private Acervo model;
    private View tela;

    public RelatorioLocado(View tela, Acervo model){
        this.tela = tela;
        this.model = model;
    }

    public void gerarRelatorio(){
        tela.displayRelatorioLocado();
    }
}
