package view;

import java.util.List;

/**
 * Created by Isabela on 24/03/2015.
 */
public interface Observer {

    public void updateAdd(String mensagem);
    public void updateBusca(List resultados);
    public void updateMulta(String valor);
    public void updateRelatorio(List resultado);

}
