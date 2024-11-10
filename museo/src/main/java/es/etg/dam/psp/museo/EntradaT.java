package es.etg.dam.psp.museo;

public class EntradaT implements Runnable{
    
    @Override
    public void run() {
        ContadorMuseo.num_personas++;
    }
    
}
