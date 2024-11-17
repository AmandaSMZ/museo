package es.etg.dam.psp.museo;

public class ContadorMuseo {
    private static ContadorMuseo instancia = new ContadorMuseo();
    private int num_personas = 100;

    private ContadorMuseo(){}

    public static ContadorMuseo getContadorMuseo() {
        return instancia;
    }

public synchronized int registro(Runnable hilo){
    if (hilo instanceof EntradaT){
        aumentarPersonas();
    }else{
        disminuirPersonas();
    }

    return num_personas;
}

private void aumentarPersonas(){
    num_personas++;
}

private void disminuirPersonas(){
    num_personas--;
}


}