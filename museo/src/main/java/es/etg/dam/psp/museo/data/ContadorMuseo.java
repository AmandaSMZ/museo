package es.etg.dam.psp.museo.data;

public class ContadorMuseo {
    public static final int NUMERO_VISITANTES_INICIO = 100;
    public static int contador  = NUMERO_VISITANTES_INICIO;

    public static synchronized void aumentarVisitantes(){
        ContadorMuseo.contador++;
    }

    public static synchronized void disminuirVisitantes(){
        ContadorMuseo.contador--;
    }
}