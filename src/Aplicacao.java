import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws IOException {
        List<String> contatos = new ArrayList<>();
        int opcao = 0;
        Contato contatoAux = new Contato();
        Scanner scanner = new Scanner(System.in);
        BufferedReader leitor = new BufferedReader(new FileReader("BancoDeContatos.txt"));
            String linha = leitor.readLine();
            while (linha != null) {
                contatos.add(linha);
                linha = leitor.readLine();
            }
        while (opcao != 5) {
            System.out.println("1- Adicionar contato");
            System.out.println("2- Deletar contato");
            System.out.println("3- Ver lista de contatos");
            System.out.println("4- buscar contato pelo nome");
            System.out.println("5- sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    BufferedWriter  adicionar = new BufferedWriter(new FileWriter("BancoDeContatos.txt"));
                    System.out.println("Digite o nome do contato:");
                    contatoAux.setNome(scanner.next());
                    System.out.println("Digite o telefone do contato:");
                    contatoAux.setTelefone(scanner.nextLong());
                    contatos.add(contatoAux.getNome() + ";" + contatoAux.getTelefone());
                    for (String i : contatos) {
                        adicionar.write(i + "\n");
                    }
                    adicionar.close();
                    break;
                case 2:
                    BufferedWriter  escritor = new BufferedWriter(new FileWriter("BancoDeContatos.txt"));
                    System.out.println("Qual contato deseja deletar:");
                    int numero_do_contato = 0;
                    numero_do_contato = scanner.nextInt() -1;
                    contatos.remove(numero_do_contato);
                    for (String i : contatos) {
                        escritor.write(i + "\n");
                    }
                    escritor.close();
                    break;
                case 3:
                    contatos.stream()
                            .sorted()
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Digite o nome do contato:");
                    String nome_do_contato = scanner.next();
                    nome_do_contato = nome_do_contato.toUpperCase();
                    String dados [];
                    for (int i=0; i< contatos.size(); i++){
                       if (contatos.get(i).toUpperCase().indexOf(nome_do_contato) != -1){
                           dados=contatos.get(i).split(";");
                           System.out.println(dados[0] +" " + dados[1]);
                       }
                    }
                    break;
            }
        }

        leitor.close();
    }
}
