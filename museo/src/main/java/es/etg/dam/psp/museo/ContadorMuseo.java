package es.etg.dam.psp.museo;

public class ContadorMuseo {
    private static ContadorMuseo contadorMuseo;
    private int num_personas = 100;

    private ContadorMuseo(){}

    public static ContadorMuseo getContadorMuseo(){
        if (contadorMuseo == null){
            contadorMuseo = new ContadorMuseo();
        }
        return contadorMuseo;
    }

public synchronized int registro(Runnable hilo){

    if (hilo instanceof EntradaT){
        aumentarPersonas();
    }else{
        disminuirPersonas();
    }

    return num_personas;
}

private  synchronized void aumentarPersonas(){
    num_personas++;
}

private synchronized void disminuirPersonas(){
    num_personas--;
}


}