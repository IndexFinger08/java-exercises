import java.util.ArrayList;
public class Usuario {
    private String nome;
    private int id;
    private ArrayList<Livro> livrosemp = new ArrayList<>();

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public void listarLivros(){
        System.out.println("Livros emprestados:");
        for(Livro l: livrosemp){
            System.out.println(l.getTitulo());
        }
    }

    public void pegarLivro(Livro livro){
        if(livro.getDisponibilidade()){ 
            livro.emprestar();
            livrosemp.add(livro);
            System.out.println("Teste teste");
        }
    }

    public void devolverLivro(Livro livro){
        if(livro.getDisponibilidade() == false && livrosemp.contains(livro)) {
            livrosemp.remove(livro);
            livro.devolver();
        }
    }

    public void informacoes(){
        System.out.println("Nome: "+this.nome);
        System.out.println("ID: "+this.id);
    }

    public String getNome(){
        return this.nome;
    }
    public int getId(){
        return this.id;
    }
}
