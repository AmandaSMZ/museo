package es.etg.dam.psp.museo;

public class RegistroT implements Runnable {

    @Override
    public void run() {
        esperar();
        ContadorMuseo contador = ContadorMuseo.getContadorMuseo();
        System.out.println(contador.registro(this));
    }
    private void esperar(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
