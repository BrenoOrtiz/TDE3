import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class main {

    public static void main(String[] args){

        String caminhoArquivo = "src/female_names.txt";
        BufferedReader arquivo = null;

        try {
            arquivo = new BufferedReader(new FileReader(caminhoArquivo));

        } catch (IOException e){
            System.out.println("Erro na leitura do arquivo: " + e.getMessage());
        }

        HashTable1 hashTable1 = new HashTable1(5000);
        HashTable2 hashTable2 = new HashTable2(5000);

        long duracao1 = 0;
        long duracao2 = 0;

        try {
            String linha;
            String[] nomes = {"Abagael", "Abagail", "Abbe", "Abbey", "Abbi", "Abbie", "Abby", "Abigael", "Abigail", "Abigale", "Abra", "Acacia", "Ada", "Adah", "Adaline","Adara", "Addie", "Addis", "Adel", "Adela"};

            long tempoInicio1 = System.nanoTime();

            while ((linha = arquivo.readLine()) != null) {
                hashTable1.insert(linha);
            }

            for (String nome : nomes){
                hashTable1.search(nome);
            }

            long tempoFim1 = System.nanoTime();
            duracao1 = (tempoFim1 - tempoInicio1) / 1_000_000;

            arquivo = new BufferedReader(new FileReader(caminhoArquivo));

            long tempoInicio2 = System.nanoTime();

            while ((linha = arquivo.readLine()) != null){
                hashTable2.insert(linha);
            }

            for (String nome : nomes){
                hashTable2.search(nome);
            }

            long tempoFim2 = System.nanoTime();
            duracao2 = (tempoFim2 - tempoInicio2) / 1_000_000;

        } catch (IOException e){
            System.out.println("Erro ao ler nomes do arquivo: " + e.getMessage());
        }

        System.out.println("Quantidade de colisões Tabela 1: " + hashTable1.getColisoes());
        System.out.println("Quantidade de colisões Tabela 2: " + hashTable2.getColisoes());

        System.out.println();

        System.out.println("Tempo de execução Tabela 1: " + duracao1 + "ms");
        System.out.println("Tempo de execução Tabela 2: " + duracao2 + "ms");

        System.out.println();

        System.out.println("Quantidade de chaves em cada posição da Tabela 1: ");
        hashTable1.show();

        System.out.println();
        System.out.println("Quantidade de chaves em cada posição da Tabela 2: ");
        hashTable2.show();


        // Colisão por posição
        //System.out.println(Arrays.toString(hashTable1.getColisoesPorPosicao()));
        //System.out.println(Arrays.toString(hashTable2.getColisoesPorPosicao()));
    }

}
