import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void CREATE(File arquivo, String linha) {
        try {
            FileWriter escrita = new FileWriter(arquivo, true);
            escrita.write(linha + '\n');

            escrita.close();
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }

    public static void READ(File arquivo, String[] linhas) {
        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(leitura);

            String linha_atual;
            int contador_linhas = 0;

            while((linha_atual = buff.readLine()) != null) {
                linhas[contador_linhas] = linha_atual;
                ++contador_linhas;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void UPDATE(File arquivo, String antiga, String nova, String[] linhas) {
        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(leitura);

            String linha_atual;
            int contador_linhas = 0;

            while((linha_atual = buff.readLine()) != null) {
                if (linha_atual.equals(antiga)) {
                    linha_atual = nova;
                }
                linhas[contador_linhas] = linha_atual;
                ++contador_linhas;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void DELETE(File arquivo, String deletar, String[] linhas){
        try {
            FileReader leitura = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(leitura);

            String linha_atual;
            int contador_linhas = 0;

            while((linha_atual = buff.readLine()) != null) {
                if (!linha_atual.equals(deletar)) {
                    linhas[contador_linhas] = linha_atual;
                    ++contador_linhas;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}