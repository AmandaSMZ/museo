

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.dam.psp.museo.Museo;
import es.etg.dam.psp.museo.data.ContadorMuseo;

class MuseoTest {

    @BeforeEach
    void resetContador() {
        ContadorMuseo.contador = ContadorMuseo.NUMERO_VISITANTES_INICIO;
    }

    @Test
    void testGestionEntradas() throws InterruptedException {
        Museo gestion = new Museo();
        gestion.gestionarEntradas();

        Thread.sleep(1000);

        assertEquals(ContadorMuseo.NUMERO_VISITANTES_INICIO + Museo.NUMERO_ENTRADAS, ContadorMuseo.contador);
    }

    @Test
    void testGestionSalidas() throws InterruptedException {
        Museo gestion = new Museo();

        gestion.gestionarSalidas();
        Thread.sleep(1000);

        assertEquals(ContadorMuseo.NUMERO_VISITANTES_INICIO - Museo.NUMERO_SALIDAS, ContadorMuseo.contador);
    }

    @Test
    void testEntradasYSalidas() throws InterruptedException {
        Museo gestion = new Museo();

        gestion.gestionarEntradas();
        gestion.gestionarSalidas();
        Thread.sleep(2000);

        int esperado = ContadorMuseo.NUMERO_VISITANTES_INICIO + Museo.NUMERO_ENTRADAS - Museo.NUMERO_SALIDAS;
        assertEquals(esperado, ContadorMuseo.contador);
    }
}
