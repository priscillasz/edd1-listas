package estruturadados.lista04.Ex07;

// COMPLEXIDADE
public class Ex07 {
    public static void menu() {

        int opcao = 0;
        do {
            System.out.println("Bem-vindo ao jogo!");
            System.out.println("1 - Inserir inimigo");
            System.out.println("2 - Localizar inimigo");
            System.out.println("3 - Efetuar dano");
            System.out.println();
        } while(opcao != 0);
    }

    public static void main(String[] args) {
        ListaInimigos inimigos = new ListaInimigos();

      Inimigo ini1 = new Inimigo();
      ini1.setVida(150);
      ini1.setDanoPorSegundo(20);

      Inimigo ini2 = new Inimigo();
      ini2.setVida(200);
      ini2.setDanoPorSegundo(50);

      Inimigo ini3 = new Inimigo();
      ini3.setVida(400);
      ini3.setDanoPorSegundo(25);

      inimigos.inserir(ini1);
      inimigos.inserir(ini2);
      inimigos.inserir(ini3);

      inimigos.imprime();

      inimigos.efetuarDano(ini1, 80);

      inimigos.imprime();

      inimigos.efetuarDano(ini1, 80);

      inimigos.imprime();
    }
}
