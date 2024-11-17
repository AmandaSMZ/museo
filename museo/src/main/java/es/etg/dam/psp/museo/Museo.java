package es.etg.dam.psp.museo;

public class Museo {
    public static final int NUMERO_ENTRADAS = 15;
    public static final int NUMERO_SALIDAS = 10;
    public static void main(String[] args) {
        for (int i=0;i<NUMERO_ENTRADAS;i++){
            gestionEntradas();
            if (i<NUMERO_SALIDAS){
                gestionSalidas();
            }
        }

    }

    public static synchronized void gestionEntradas(){

        Thread entrada = new Thread(new EntradaT());
        entrada.start();
        
    }

    public static synchronized void gestionSalidas(){

        Thread salida = new Thread(new SalidaT());
        salida.start();
    }
}