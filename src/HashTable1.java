public class HashTable1 extends HashTable{

    public HashTable1(int tamanho) {
        super(tamanho);
    }

    public int hash(String chave){
        return chave.length() % this.tamanho;
    }

}
