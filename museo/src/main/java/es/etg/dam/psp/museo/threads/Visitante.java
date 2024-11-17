package es.etg.dam.psp.museo.threads;

import es.etg.dam.psp.museo.data.ContadorMuseo;

public class Visitante implements Runnable{
    private final int tipoVisitante;

    public Visitante(int tipo){
        tipoVisitante = tipo;
    }

    @Override
    public void run() {
        if (tipoVisitante == 0){
            ContadorMuseo.aumentarVisitantes();
        }else if (tipoVisitante == 1){
            ContadorMuseo.disminuirVisitantes();
        }
    }
    
    
}
