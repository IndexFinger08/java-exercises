public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponibilidade;

    public Livro(String titulo, String autor, int ano){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponibilidade = true;
    }

    public void emprestar(){
        if(disponibilidade){
            System.out.println("Livro emprestado com sucesso.\n");
            this.disponibilidade = false;
        } else{
            System.out.println("Não foi possível emprestar o livro: Livro já emprestado.\n");
        }
    }
    public void devolver(){
        if(disponibilidade){
            System.out.println("Não foi possível devolver o livro: Livro não emprestado.\n");
        } else{
            System.out.println("Livro devolvido com sucesso.\n");
            this.disponibilidade = true;
        }
    }
    public void informacoes(){
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Autor: "+this.autor);
        System.out.println("Ano: "+this.ano);
        if (disponibilidade) {
            System.out.println("Disponível\n");
        } else{
            System.out.println("Indisponível.\n");
        }
    }

    public String getTitulo(){
        return this.titulo;
    }

    public boolean getDisponibilidade(){
        return this.disponibilidade;
    }
}
