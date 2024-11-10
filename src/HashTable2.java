public class HashTable2 extends HashTable{

    public HashTable2(int tamanho) {
        super(tamanho);
    }

    public int hash(String chave){
        int soma = 0;
        int valorASCII = 0;
        for (int i = 0; i < chave.length(); i++){
            valorASCII = (int) chave.charAt(i);
            soma += valorASCII;
        }
        return soma % tamanho;
    }
}
