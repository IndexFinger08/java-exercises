import java.util.Random;

public class MyRunnable implements Runnable{
    private Random random = new Random();
    private int blocos;
    private static volatile boolean corridaTerminou = false;
    public String nome;
    

    private void avancar(){
        int numero = random.nextInt(3);
        if (numero == 2) {
            System.err.println("O cavalo "+this.nome+" avançou um bloco!\n");
            blocos++;
        }
    }

    @Override
    public void run() {        
        while(!corridaTerminou && blocos<50){
            try {
                Thread.sleep(100);
                if(corridaTerminou){return;}
                avancar();
                if(corridaTerminou){return;}
                System.err.println("Blocos avançados: "+blocos+"\n");
            } catch(InterruptedException e) {
                System.out.println("Ocorreu um erro.");
            }
        }
        if(!corridaTerminou){
            corridaTerminou = true;
            System.out.println("Fim da corrida! O cavalo "+this.nome+" ganhou!");
            System.exit(0);    
        }
            
        
    }
    
}
