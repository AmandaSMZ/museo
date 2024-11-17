package es.etg.dam.psp.museo;

public class EntradaT implements Runnable{

    @Override
    public void run() {
        ContadorMuseo.contador++;
        System.out.println(ContadorMuseo.contador);
    }
    
    
}
