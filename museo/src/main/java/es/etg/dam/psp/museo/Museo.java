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
        System.out.println(ContadorMuseo.num_personas);
    }

    public static void gestionEntradas(){

        Thread entrada = new Thread(new EntradaT());
        entrada.start();
        
    }

    public static void gestionSalidas(){

        Thread salida = new Thread(new SalidaT());
        salida.start();
    }
}