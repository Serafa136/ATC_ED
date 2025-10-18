import java.util.Random;

public class MeuVetor {
    private int v[];
    private int ocupacao;

    public MeuVetor(){
        v = new int[10];
        ocupacao = 0;
    }
    public MeuVetor(int capacidade){
        v = new int[capacidade];
        ocupacao = 0;
    }
    public int getPosicaoVetor(int posicao){
        return v[posicao];
    }
    public void setPosicaoVetor(int posicao, int valor){
        v[posicao] = valor;
    }
    public int[] getV(){
        return v;
    }
    public boolean estaCheio(){
        return ocupacao == v.length;
    }
    public boolean estaVazio(){
        return ocupacao == 0;
    }
    private void redimensiona(int novoTamanho){
        int[] vLocal = new int [novoTamanho];
        for (int i = 0; i < ocupacao; i++){
            vLocal[i] = v[i];
        }
        v = vLocal;
    }
    public void insereElemento(int elemento){
        if (estaCheio()){
            redimensiona(v.length * 2);
        }
        v[ocupacao++] = elemento;
    }
    public int remove(){
        if(!estaVazio()){
            ocupacao--;
            if (v.length > 4 && ocupacao <= v.length / 4){
                redimensiona(v.length / 2);
            }
            return v[ocupacao];
        }
        return -1;
    }
    public boolean contem(int x){
        for (int i = 0; i < ocupacao; i++){
            if (v[i] ==x ){
                return true;
            }
        }
        return false;
    }
    public int tamanho(){
        return ocupacao;
    }
    public void preencheVetor(){
        Random random = new Random();
        for (int i = 0; i < v.length; i++){
            v[i] = random.nextInt(v.length *10);
        }
        ocupacao = v.length;
    }
    public void bubbleSort() {
        for (int i = 1; i < v.length; i++){
            for (int j =0; j < v.length - i; j++){
                if (v[j] > v[j+1]){
                    int aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    }
    public void insertionSort(){
        for (int j = 1; j < v.length; ++j){
            int x = v[j];
            int i;
            for (i = j -1; i >= 0 && v[i] > x; --i){
                v[i+1] = x;
            }
        }
    }
    public void selectionSort(){
        for (int i =0; i < v.length -1; i++){
            int pos = i;
            for (int j = i + 1; j < v.length; j++){
                if (v[j] < v[pos]){
                    pos = j;
                }
            if (pos != i){
                int aux = v[pos];
                v[pos] = v[i];
                v[i] = aux;
            }
            }
        }
    }
    public int partition (int p, int r){
        int x = v[r];
        int i = p-1;
        for (int j = p; j < r; j++){
            if (v[j] <= x){
                i = i+1;
                int aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        i = i+1;
        int aux = v[r];
        v[r] = v[i];
        v[i] = aux;
        return i;
    }
    public void quickSort(int p, int r){
        if (p < r){
            int q = partition(p,r);
            quickSort(p, q-1);
            quickSort(q+1,r);
        }
    }
}
