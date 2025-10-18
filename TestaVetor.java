public class TestaVetor {
    public static void main(String[] args) {
        MeuVetor nVetor = new MeuVetor(12000);
        nVetor.preencheVetor();
        long res;
        long startTime = System.nanoTime();
        nVetor.insertionSort();
        long endTime = System.nanoTime();
        res = (endTime - startTime);
        System.out.printf("Tempo: %d" , res);
    }
}
