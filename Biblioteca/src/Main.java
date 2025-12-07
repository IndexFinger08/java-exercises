import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        menu:
        while(true) {
            System.out.println("---BIBLIOTECA DOCE LER---");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Adicionar usuário");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Listar usuários");
            System.out.println("5 - Buscar livro por título");
            System.out.println("6 - Buscar usuário por ID");
            System.out.println("7 - Devolver livro");
            System.out.println("8 - Emprestar livro");
            System.out.println("9 - Listar livros emprestados");
            System.out.println("10 - Sair");
            try{
            int opcao = sc.nextInt();
            
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome do livro(sem acentuações): ");
                        sc.nextLine();
                        String nomelivro = sc.nextLine();
                        System.out.println("Digite o autor do livro: ");
                        String autor = sc.nextLine();
                        System.out.println("Digite o ano de lançamento do livro: ");
                        int ano = sc.nextInt();
                        Livro l = new Livro(nomelivro, autor, ano);
                        biblioteca.adicionarLivro(l);
                        
                        break;
                    case 2:
                        System.out.println("Digite o nome do usuário(sem acentuações): ");
                        sc.nextLine();
                        String nome_usuario = sc.nextLine();
                        System.out.println("Digite o id do usuário: ");
                        int id_usuario = sc.nextInt();
                        Usuario u = new Usuario(nome_usuario, id_usuario);
                        biblioteca.adicionarUsuario(u);
                        break;
                    case 3:
                        biblioteca.listarLivros();
                        break;
                    case 4:
                        biblioteca.listarUsuarios();
                        break;
                    case 5:
                        System.out.println("Digite o título do livro");
                        sc.nextLine();
                        String tituloProcura = sc.nextLine().trim();
                        biblioteca.acharLivroPorTitulo(tituloProcura);
                        break;
                    case 6:
                        System.out.println("Digite o ID do usuário: ");
                        sc.nextLine();
                        int id_busca = sc.nextInt();
                        biblioteca.acharUsuarioPorId(id_busca);
                        break;
                    case 7:
                        System.out.println("Digite o ID do usuário: ");
                        sc.nextLine();
                        int id_devolver = sc.nextInt();
                        System.out.println("Digite o título do livro: ");
                        sc.nextLine();
                        String titulo_devolver = sc.nextLine();
                        biblioteca.devolverLivro(id_devolver, titulo_devolver);
                        break;
                    case 8:
                        System.out.println("Digite o ID do usuário: ");
                        sc.nextLine();
                        int id_pegar = sc.nextInt();
                        System.out.println("Digite o título do livro: ");
                        sc.nextLine();
                        String titulo_pegar = sc.nextLine();
                        biblioteca.emprestarLivro(id_pegar, titulo_pegar);
                        break;
                    case 9:
                        System.out.println("Digite o ID do usuário: ");
                        sc.nextLine();
                        int id_emprestado = sc.nextInt();
                        biblioteca.livrosEmprestados(id_emprestado);
                        break;
                    case 10:
                        break menu;
                    default:
                        System.out.println("Digita uma opção possível.");
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println("Você não digitou um número! Tente novamente.");
                sc.nextLine();
            }
            
        }
        sc.close();
    }
}
