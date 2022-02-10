package estruturadados.lista04;

/* 5) Suponha agora uma derivação do exercício anterior, em que se deseje reverter uma
    frase usando listas encadeadas. Além de inverter a ordem da frase em si, também se
    deseja inverter a ordem das letras de cada palavra individualmente. Implemente então um
    método para realizar essa tarefa. Note que cada letra de cada palavra deve estar
    armazenada em um objeto Elo da lista. Tem-se liberdade para pensar na melhor forma de
    modelar tal problema. */

// COMPLEXIDADE:

public class Ex05 {
    public static void main(String[] args) {
        ListaString frase = new ListaString();

        // cada palavra é inserida na head da linked list, então já estão invertidas, a não ser que
        // tivessemos escolhido inserir as palavras ao final da lista
        frase.insere("Estruturas");
        frase.insere(" ");
        frase.insere("de");
        frase.insere(" ");
        frase.insere("Dados");
        frase.insere("!");

        System.out.println("Lista invertida:");
        frase.imprime();

        // agora, basta inverter a ordem das letras em cada uma dessas palavras
        frase.inverte();

        // imprimindo novamente após inverter...
        System.out.println("Letras invertidas:");
        frase.imprime();
    }
}
