package es.etg.dam.psp.museo;

public class SalidaT implements Runnable{

    @Override
    public void run() {
        ContadorMuseo.num_personas--;
    }
    
}