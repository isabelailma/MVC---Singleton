package teste;

import controller.*;
import model.*;
import view.View;

/**
 * Created by Isabela on 30/03/2015.
 */
public class Teste {

    //SINGLETON
    static Acervo acervo;

    public static void main(String[] args) {

        //SINGLETON
        //Pega o conteúdo do DB4O
        acervo = acervo.getInstance();
        //Acrescenta mais dados ao DB4O
        initializeAcervo(acervo);

        View tela = new View();

        //Buscas
        BuscaNome buscaNome = new BuscaNome(tela, acervo);//Controller->View - Controller->Model
        BuscaAno buscaAno = new BuscaAno(tela, acervo);//Controller->View - Controller->Model

        acervo.registerObserver(tela);//Model -> View

        tela.setBusca(buscaNome);//View -> Controller
        acervo.buscarDB4O("O Hobbit: A Batalha dos Cinco Exércitos");

        tela.setBusca(buscaAno);//View -> Controller
        acervo.buscarDB4O("2014");

        //Multa
        Catalogo multaCatalogo = new Catalogo(tela, acervo);//Controller->View - Controller->Model
        Lancamento multaLancamento = new Lancamento(tela, acervo);//Controller->View - Controller->Model
        SuperLancamento multaSuperLancamento = new SuperLancamento(tela, acervo);//Controller->View - Controller->Model

        tela.setMulta(multaCatalogo);//View -> Controller
        acervo.calcularMultaCatalogo(2);

        tela.setMulta(multaLancamento);//View -> Controller
        acervo.calcularMultaLancamento(2);

        tela.setMulta(multaSuperLancamento);//View -> Controller
        acervo.calcularMultaSuperLancamento(2);

        //Relatório
        RelatorioDisponivel relatorioDisponivel = new RelatorioDisponivel(tela, acervo);//Controller->View - Controller->Model
        RelatorioLocado relatorioLocado = new RelatorioLocado(tela, acervo);//Controller->View - Controller->Model

        tela.setRelatorio(relatorioDisponivel);//View -> Controller
        acervo.gerarRelatorioDisponivelDB4O();

        tela.setRelatorio(relatorioLocado);//View -> Controller
        acervo.gerarRelatorioLocadoDB4O();

    }

    //SINGLETON
    public static void initializeAcervo(Acervo acervo) {
        /*acervo.adicionarFilme(new Filme("O Último Samurai", "2004", "Em 1870 é enviado ao Japão o capitão Nathan Algren (Tom Cruise), um conceituado militar norte-americano. A missão de Algren é treinar as tropas do imperador Meiji (Shichinosuke Nakamura), para que elas possam eliminar os últimos samurais que ainda vivem na região. Porém, após ser capturado pelo inimigo, Algren aprende com Katsumoto (Ken Watanabe) o código de honra dos samurais e passa a ficar em dúvida sobre que lado apoiar.", "Edward Zwick", "Tom Cruise, Billy Connolly, Tony Goldwyn", Midia.BLURAY, Categoria.CATALOGO, Status.DISPONIVEL));
        acervo.adicionarFilme(new Filme("Malévola", "2014", "Baseado no conto da Bela Adormecida, o filme conta a história de Malévola (Angelina Jolie), a protetora do reino dos Moors. Desde pequena, esta garota com chifres e asas mantém a paz entre dois reinos diferentes, até se apaixonar pelo garoto Stefan (Sharlto Copley). Os dois iniciam um romance, mas Stefan tem a ambição de se tornar líder do reino vizinho, e abandona Malévola para conquistar seus planos. A garota torna-se uma mulher vingativa e amarga, que decide amaldiçoar a filha recém-nascida de Stefan, Aurora (Elle Fanning). Aos poucos, no entanto, Malévola começa a desenvolver sentimentos de amizade em relação à jovem e pura Aurora.", "Robert Stromberg", "Angelina Jolie, Elle Fanning, Sharlto Copley", Midia.BLURAY, Categoria.LANCAMENTO, Status.DISPONIVEL));
        acervo.adicionarFilme(new Filme("Guardiões da Galáxia", "2014", "Peter Quill (Chris Pratt) foi abduzido da Terra quando ainda era criança. Adulto, fez carreira como saqueador e ganhou o nome de Senhor das Estrelas. Quando rouba uma esfera, na qual o poderoso vilão Ronan, da raça kree, está interessado, passa a ser procurado por vários caçadores de recompensas. Para escapar do perigo, Quill une forças com quatro personagens fora do sistema: Groot, uma árvore humanóide (Vin Diesel), a sombria e perigosa Gamora (Zoe Saldana), o guaxinim rápido no gatilho Rocket Racoon (Bradley Cooper) e o vingativo Drax, o Destruidor (Dave Bautista). Mas o Senhor das Estrelas descobre que a esfera roubada possui um poder capaz de mudar os rumos do universo, e logo o grupo deverá proteger o objeto para salvar o futuro da galáxia.", "James Gunn", "Chris Pratt, Zoe Saldana, Dave Bautista", Midia.BLURAY, Categoria.LANCAMENTO, Status.LOCADO));
        acervo.adicionarFilme(new Filme("Sniper Americano", "2015", "Adaptado do livro American Sniper: The Autobiography of the Most Lethal Sniper in U.S. Militar History, o filme conta a história real de Chris Kyle (Bradley Cooper), atirador de elite das forças especiais da marinha americana. Durante cerca de dez anos ele matou mais de 150 pessoas, tendo recebido diversas condecorações por sua atuação na Guerra do Iraque.", "Clint Eastwood", "Bradley Cooper, Sienna Miller, Luke Grimes", Midia.BLURAY, Categoria.SUPERLANCAMENTO, Status.LOCADO));
        acervo.adicionarFilme(new Filme("O Hobbit: A Batalha dos Cinco Exércitos", "2014", "Após ser expulso da montanha de Erebor, o dragão Smaug ataca com fúria a cidade dos homens que fica próxima ao local. Após muita destruição, Bard (Luke Evans) consegue derrotá-lo. Não demora muito para que a queda de Smaug se espalhe, atraindo os mais variados interessados nas riquezas que existem dentro de Erebor. Entretanto, Thorin (Richard Armitage) está disposto a tudo para impedir a entrada de elfos, anões e orcs, ainda mais por ser tomado por uma obsessão crescente pela riqueza à sua volta. Paralelamente a estes eventos, Bilbo Bolseiro (Martin Freeman) e Gandalf (Ian McKellen) tentam impedir a guerra.", "Peter Jackson", "Martin Freeman, Richard Armitage, Evangeline Lilly", Midia.BLURAY, Categoria.LANCAMENTO, Status.LOCADO));
        acervo.adicionarFilme(new Filme("O Hobbit: A Batalha dos Cinco Exércitos","2014","Após ser expulso da montanha de Erebor, o dragão Smaug ataca com fúria a cidade dos homens que fica próxima ao local. Após muita destruição, Bard (Luke Evans) consegue derrotá-lo. Não demora muito para que a queda de Smaug se espalhe, atraindo os mais variados interessados nas riquezas que existem dentro de Erebor. Entretanto, Thorin (Richard Armitage) está disposto a tudo para impedir a entrada de elfos, anões e orcs, ainda mais por ser tomado por uma obsessão crescente pela riqueza à sua volta. Paralelamente a estes eventos, Bilbo Bolseiro (Martin Freeman) e Gandalf (Ian McKellen) tentam impedir a guerra.","Peter Jackson","Martin Freeman, Richard Armitage, Evangeline Lilly",Midia.DVD,Categoria.LANCAMENTO,Status.DISPONIVEL));
        */
    }
}