package es.etg.dam.psp.museo;

public class SalidaT implements Runnable{

    @Override
    public void run() {
        ContadorMuseo contador = ContadorMuseo.getContadorMuseo();
        System.out.println(contador.registro(this));
    }
    
}
