package estruturadados.lista01;

// classe Pilha utilizada no exercício 3 da lista 1

import java.util.Arrays;

public class Pilha2x {
    int[] arr;
    int size;
    int top1, top2;

    Pilha2x(int n) {
        size = n;
        arr = new int[n];
        top1 = n/2;
        top2 = n/2-1;
    }

    // empilhar na pilha 1
    void push1(int x) {

        if (top1 > 0) {
            top1--;
            arr[top1] = x;
        } else {
            System.out.println("Estouro!");
        }
    }

    // empilhar na pilha 2
    void push2(int x) {
        if (top2 < size - 1) {
            top2++;
            arr[top2] = x;
        } else {
            System.out.println("Estouro!");
        }
    }

    // desempilhar da pilha 1
    int pop1() {
        if (top1 <= size / 2) {
            int x = arr[top1];
            top1++;
            return x;
        } else {
            System.out.println("Stack underflow.");
        }
        return 1;
    }

    // desempilhar da pilha 2
    int pop2() {
        if (top2 >= size / 2 + 1) {
            int x = arr[top2];
            top2--;
            return x;
        } else {
            System.out.println("Stack underflow");
        }
        return 1;
    }

    // toString
    @Override
    public String toString() {
        return "Pilha2x{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                ", top1=" + top1 +
                ", top2=" + top2 +
                '}';
    }
}
