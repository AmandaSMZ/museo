package es.etg.dam.psp.museo;

import es.etg.dam.psp.museo.data.ContadorMuseo;
import es.etg.dam.psp.museo.threads.Visitante;

public class Museo {

    public static final int NUMERO_ENTRADAS = 10;
    public static final int NUMERO_SALIDAS = 15;
    public static final int TIPO_ENTRADA = 0;
    public static final int TIPO_SALIDA = 1;
    public static void main(String[] args) throws InterruptedException {

        gestionarEntradas();
        gestionarSalidas();

        Thread.sleep(5000);
        System.out.println("Aforo de visitantes al final: "+ContadorMuseo.contador);
    }

    public static void gestionarEntradas(){

        for (int i=0;i<NUMERO_ENTRADAS;i++){
        Thread entrada = new Thread(new Visitante(TIPO_ENTRADA));
        entrada.start();
        }
        
    }

    public static void gestionarSalidas(){
        for (int i=0;i<NUMERO_SALIDAS;i++){
            Thread salida = new Thread(new Visitante(TIPO_SALIDA));
            salida.start();
        }
    }
}