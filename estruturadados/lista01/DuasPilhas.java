package estruturadados.lista01;

import java.util.Arrays;

// Usada na questão 3 da lista 1 de EDD1
public class DuasPilhas {
    int[] array;
    int size;
    int top1, top2;
    boolean overflow1 = false;
    boolean overflow2 = false;

    // construtor
    DuasPilhas(int n) {
        this.size = n;
        this.array = new int[n];
        this.top1 = n / 2 + 1;
        this.top2 = n / 2;
    }

    // empilhar 1
    public void push1(int x) {
        if (this.top1 > 0) {
            this.top1--;
            this.array[top1] = x;
        } else {
            overflow1 = true;
        }
   }

   // empilhar 2
   public void push2(int y) {
        if (this.top2 < size - 1) {
            this.top2++;
            this.array[top2] = y;
        } else {
            overflow2 = true;
        }
   }

    // desempilhar 1
    void pop1() {
        if (top1 <= size / 2)  {
            int x = array[top1];
            if (this.top1 > 0) {
                overflow1 = false;
            }
            top1++;
        }
    }

    // desempilhar 2
    void pop2() {
        if (top2 >= size / 2 + 1) {
            int x = array[top2];
            if (top2 < size-1) {
                overflow2 = false;
            }
            top2--;
        }
    }

   // verificar se houve overflow (dos dois lados ao mesmo tempo)
   boolean overflow() {
        return overflow1 && overflow2;
   }

    @Override // toString
    public String toString() {
        return "Pilha: " + Arrays.toString(array);
    }
}
