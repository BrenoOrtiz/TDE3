import java.util.Objects;

public abstract class HashTable {

    protected int tamanho;
    protected int colisoes = 0;
    protected int capacidade = 0;
    protected int[] colisoesPorPosicao;
    protected String[] chaves;

    public HashTable(int tamanho){
        this.tamanho = tamanho;
        this.colisoesPorPosicao = new int[tamanho];
        this.chaves = new String[tamanho];
    }

    public abstract int hash(String chave);

    public void insert(String chave) {
        if (this.capacidade == this.tamanho) {
            return;
        }

        int valor = hash(chave);


        if (this.chaves[valor] != null) {
            this.colisoes++;
            this.colisoesPorPosicao[valor]++;
        }


        while (this.chaves[valor] != null) {
            valor = (valor + 1) % this.tamanho;
        }

        this.chaves[valor] = chave;
        this.capacidade++;
    }

    public boolean search(String chave) {
        int valor = hash(chave);
        int valorInicial = valor;


        if (Objects.equals(this.chaves[valor], chave)) {
            return true;
        }
        valor += 1;

        while (valor != valorInicial) {
            if (Objects.equals(this.chaves[valor], chave)) {
                return true;
            }

            valor = (valor + 1) % this.tamanho;
        }

        return false;
    }

    public String remove(String chave) {
        int valor = hash(chave);


        while (this.chaves[valor] != null) {
            if (Objects.equals(this.chaves[valor], chave)) {
                String chaveRemovida = this.chaves[valor];
                this.chaves[valor] = null;
                this.capacidade--;
                return chaveRemovida;
            }
            valor = (valor + 1) % this.tamanho;
        }
        return null;
    }

    public int getColisoes() {
        return this.colisoes;
    }

    public int[] getColisoesPorPosicao() {
        return this.colisoesPorPosicao;
    }

    public void show() {
        for (int i = 0; i < this.chaves.length; i++) {
            System.out.print( + i + ": " + this.chaves[i] + ", ");
        }
    }
}
