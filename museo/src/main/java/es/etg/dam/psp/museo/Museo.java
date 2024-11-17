package es.etg.dam.psp.museo;

public class Museo {

    public static final int NUMERO_ENTRADAS = 10;
    public static final int NUMERO_SALIDAS = 15;
    public static void main(String[] args) throws InterruptedException {

        gestionEntradas();
        gestionSalidas();

        Thread.sleep(5000);
        System.out.println("Aforo de visitantes al final: "+ContadorMuseo.contador);
    }

    public static synchronized void gestionEntradas(){

        for (int i=0;i<NUMERO_ENTRADAS;i++){
        Thread entrada = new Thread(new EntradaT());
        entrada.start();
        }
        
    }

    public static synchronized void gestionSalidas(){
        for (int i=0;i<NUMERO_SALIDAS;i++){
            Thread salida = new Thread(new SalidaT());
            salida.start();
        }
    }
}