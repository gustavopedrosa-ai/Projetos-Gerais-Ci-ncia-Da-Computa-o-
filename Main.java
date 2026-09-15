import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Busca Sequencial - Complexidade O(n)
    public static int buscaSequencial(int[] vetor, int alvo) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == alvo) return i;
        }
        return -1;
    }

    // Busca Binária - Complexidade O(log n)
    public static int buscaBinaria(int[] vetor, int alvo) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            if (vetor[meio] == alvo) return meio;
            if (vetor[meio] < alvo) inicio = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ANALISADOR DE ALGORITMOS (4º SEMESTRE) ===");
        System.out.print("Digite o tamanho do vetor (ex: 10000000): ");
        int tamanho = scanner.nextInt();

        int[] dados = new int[tamanho];
        Random random = new Random();

        System.out.println("\nGerando números aleatórios...");
        for (int i = 0; i < tamanho; i++) {
            dados[i] = random.nextInt(tamanho * 2);
        }

        int elementoBuscado = dados[tamanho - 1]; // Pior caso aproximado

        // Teste 1: Busca Sequencial (sem ordenar)
        long inicioSeq = System.nanoTime();
        buscaSequencial(dados, elementoBuscado);
        long fimSeq = System.nanoTime();
        double tempoSeqMs = (fimSeq - inicioSeq) / 1_000_000.0;

        // Ordenação para a Busca Binária
        Arrays.sort(dados);

        // Teste 2: Busca Binária (vetor ordenado)
        long inicioBin = System.nanoTime();
        buscaBinaria(dados, elementoBuscado);
        long fimBin = System.nanoTime();
        double tempoBinMs = (fimBin - inicioBin) / 1_000_000.0;

        // Resultados
        System.out.println("\n--- RESULTADOS DA EXECUÇÃO ---");
        System.out.printf("Busca Sequencial O(n):   %.4f ms%n", tempoSeqMs);
        System.out.printf("Busca Binária O(log n):  %.4f ms%n", tempoBinMs);
        
        scanner.close();
    }
}