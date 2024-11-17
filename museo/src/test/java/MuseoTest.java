

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.dam.psp.museo.ContadorMuseo;
import es.etg.dam.psp.museo.Museo;

class MuseoTest {

    @BeforeEach
    void resetContador() {
        ContadorMuseo.contador = ContadorMuseo.NUMERO_VISITANTES_INICIO;
    }

    @Test
    void testGestionEntradas() throws InterruptedException {
        Museo gestion = new Museo();
        gestion.gestionEntradas();

        Thread.sleep(1000);

        assertEquals(ContadorMuseo.NUMERO_VISITANTES_INICIO + Museo.NUMERO_ENTRADAS, ContadorMuseo.contador);
    }

    @Test
    void testGestionSalidas() throws InterruptedException {
        Museo gestion = new Museo();

        gestion.gestionSalidas();
        Thread.sleep(1000);

        assertEquals(ContadorMuseo.NUMERO_VISITANTES_INICIO - Museo.NUMERO_SALIDAS, ContadorMuseo.contador);
    }

    @Test
    void testEntradasYSalidas() throws InterruptedException {
        Museo gestion = new Museo();

        gestion.gestionEntradas();
        gestion.gestionSalidas();
        Thread.sleep(2000);

        int esperado = ContadorMuseo.NUMERO_VISITANTES_INICIO + Museo.NUMERO_ENTRADAS - Museo.NUMERO_SALIDAS;
        assertEquals(esperado, ContadorMuseo.contador);
    }
}
