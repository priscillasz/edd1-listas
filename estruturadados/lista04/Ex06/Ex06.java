package estruturadados.lista04.Ex06;

/* 6) Um diretório é uma lista de arquivos e outros diretórios. Assim sendo, crie um programa
que receba o nome de um diretório e imprima o nome de todos os arquivos e outros
diretórios contidos naquele, de modo que o conteúdo de cada diretório seja recursivamente
listado (de forma indentada) sob o nome do diretório pai. Considere o seguinte exemplo: */

// COMPLEXIDADE:

public class Ex06 {
    public static void recursivePrinting(Diretorio dir) {

    }

    public static void main(String[] args) {
        Diretorio diretorio = new Diretorio("Diretório");

        // JOGOS
        Diretorio jogos = new Diretorio("Jogos");
        Arquivo cm = new Arquivo("Campo Minado");
        Arquivo pc = new Arquivo("Paciência");
        Arquivo wc = new Arquivo("World of Warcraft");

        jogos.insere(cm);
        jogos.insere(pc);
        jogos.insere(wc);

        // jogos.imprime();

        // System.out.println(jogos);

        // FACULDADE
        Diretorio<Diretorio> faculdade = new Diretorio("Faculdade");
        Diretorio edd1 = new Diretorio("EDD1");
        Diretorio edd2 = new Diretorio("EDD2");
        Diretorio aa = new Diretorio("AA");
        Diretorio aces = new Diretorio("ACEs");
        Arquivo ace1 = new Arquivo("ACE1");
        Arquivo ace2 = new Arquivo("ACE2");
        Arquivo ace3 = new Arquivo("ACE3");
        Diretorio tpd = new Diretorio("TPD");

        faculdade.insere(edd1);
        faculdade.insere(edd2);
        faculdade.insere(aa);
        faculdade.insere(aces);
        faculdade.insere(tpd);

        // System.out.println(faculdade.diretorio());

        aces.insere(ace1);
        aces.insere(ace2);
        aces.insere(ace3);

        /*System.out.println(faculdade.diretorio());
        System.out.println(aces.diretorio());
*/
        // FILMES
        Diretorio<Diretorio> filmes = new Diretorio("Filmes");
        Diretorio<Diretorio> superherois = new Diretorio("Super-heróicos");
        Diretorio<Arquivo> marvel = new Diretorio("Marvel");
        Arquivo vingadores = new Arquivo("Vingadores");
        Arquivo miranha = new Arquivo("Homem-Aranha");
        Diretorio<Arquivo> dc = new Diretorio("DC");
        Arquivo superman = new Arquivo("Superman");
        Diretorio<Arquivo> drama = new Diretorio("Drama");
        Arquivo brilho = new Arquivo("Bilho Eterno de Uma Mente sem Lembranças");
        Diretorio<Arquivo> romcom = new Diretorio("Comédias Românticas");

        filmes.insere(superherois);
        filmes.insere(drama);
        filmes.insere(romcom);

        //System.out.println(filmes.diretorio());

        superherois.insere(marvel);
        superherois.insere(dc);

        marvel.insere(vingadores);
        marvel.insere(miranha);
        dc.insere(superman);

        drama.insere(brilho);


        // romcom -> vazio

        diretorio.insere(jogos);
        diretorio.insere(faculdade);
        diretorio.insere(filmes);


    }
}
