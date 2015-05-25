package model;

/**
 * Created by Isabela on 24/03/2015.
 */
public enum Categoria {

    CATALOGO, LANCAMENTO, SUPERLANCAMENTO;

    @Override
    public String toString() {
        switch(this) {
            case CATALOGO: return "Catálogo";
            case LANCAMENTO: return "Lançamento";
            case SUPERLANCAMENTO: return "Super Lançamento";
            default: return "unspecified";
        }
    }
}
