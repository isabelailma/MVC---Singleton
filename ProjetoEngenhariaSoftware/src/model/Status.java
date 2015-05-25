package model;

/**
 * Created by Isabela on 24/03/2015.
 */
public enum Status {

    LOCADO, DISPONIVEL;

    @Override
    public String toString() {
        switch(this) {
            case LOCADO: return "Locado";
            case DISPONIVEL: return "Disponível";
            default: return "unspecified";
        }
    }
}
