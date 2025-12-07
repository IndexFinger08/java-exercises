public class Main {
    public static void main(String[] args) throws Exception {
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();
        MyRunnable myRunnable3 = new MyRunnable();
        MyRunnable myRunnable4 = new MyRunnable();
        MyRunnable myRunnable5 = new MyRunnable();
        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        Thread thread3 = new Thread(myRunnable3);
        Thread thread4 = new Thread(myRunnable4);
        Thread thread5 = new Thread(myRunnable5);

        myRunnable1.nome = "El Emperador";
        myRunnable2.nome = "Acrilico de Souza";
        myRunnable3.nome = "Jamires da Silva";
        myRunnable4.nome = "El Toro";
        myRunnable5.nome = "QUASAR";

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
