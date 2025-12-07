import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
    }
    public void adicionarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    public void listarLivros(){
        if (livros.size()>0) {
            System.out.println("Quantidade de livros na biblioteca: " + this.livros.size());
            System.out.println("Livros armazenados:");
            for (Livro l : this.livros) {
                System.out.println(l.getTitulo());
            }
        } else{
            System.out.println("Não possuímos livros armazenados.");
        }
        
    }
    public void listarUsuarios(){
        if(usuarios.size()>0) {
            System.out.println("Quantidade de usuários cadastrados: " + this.usuarios.size());
            System.out.println("Usuários: ");
            for (Usuario u : this.usuarios) {
                System.out.println("Nome: "+u.getNome());
                System.out.println("ID: "+u.getId());
            }
        } else{
            System.out.println("Não possuímos usuários cadastrados até o momento.");
        }
        
    }
    public void acharLivroPorTitulo(String titulo){
        if(livros.size()>0) {
            boolean achado = false;
            for(int i = 0; i<this.livros.size(); i++){
                if(this.livros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                    achado = true;
                    this.livros.get(i).informacoes();
                }
            }
            if (!achado) {
                System.out.println("Não foi encontrado o livro.");
            }
        }
        
    }

    public void acharUsuarioPorId(int id){
        if(usuarios.size()>0){
            boolean achado = false;
            for(int i = 0; i<this.usuarios.size(); i++){
                if(this.usuarios.get(i).getId() == id){
                    achado = true;
                    this.usuarios.get(i).informacoes();
                }
            }
            if (!achado) {
                System.out.println("Não foi encontrado o usuário.");
            }
        } else{
            System.out.println("A lista não possui usuários.");
        }
        
    }

    public void emprestarLivro(int id, String titulo){
        if(livros.size()>0 && usuarios.size()>0){ // vai testar se tem livros e usuários no vetor
            for(Usuario u: usuarios){
                if(u.getId() == id){
                    for(Livro l: livros){
                        if (l.getTitulo().equalsIgnoreCase(titulo)) {
                            u.pegarLivro(l);
                            break;
                        }
                    }
                    break;
                }
            }
        } else{
            System.out.println("Erro: Não há usuários ou livros cadastrados!");
        }
        
    }

    public void devolverLivro(int id, String titulo){
        if(livros.size()>0 && usuarios.size()>0) {
            for(Usuario u: usuarios){
                if(u.getId() == id){
                    for(Livro l: livros){
                        if (l.getTitulo().equalsIgnoreCase(titulo)) {
                            u.devolverLivro(l);
                            break;
                        }
                    }
                    break;
                }
            }
        } else{
            System.out.println("Erro: Não há usuários ou livros cadastrados!");
        }
        
        
    }

    public void livrosEmprestados(int id){
        if(livros.size()>0 && usuarios.size()>0){
            for(Usuario u: usuarios){
                if(u.getId() == id){
                    u.listarLivros();
                }
            }
        }
    }

    public Usuario getUsuario(int i){
        return usuarios.get(i);
    }

}
