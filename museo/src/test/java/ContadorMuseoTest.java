import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.dam.psp.museo.ContadorMuseo;
import es.etg.dam.psp.museo.EntradaT;
import es.etg.dam.psp.museo.SalidaT;

public class ContadorMuseoTest {

    private ContadorMuseo contadorMuseo;

    @BeforeEach
    public void setUp() {
        // Reiniciar el contador antes de cada prueba
        contadorMuseo = ContadorMuseo.getContadorMuseo();
        contadorMuseo.registro(new SalidaT());  // Reinicia a un valor inicial de 100
    }

    @Test
    public void testAumentarPersonas() {
        int personasInicial = contadorMuseo.registro(new SalidaT());
        
        // Simular entrada
        contadorMuseo.registro(new EntradaT());
        assertEquals(personasInicial + 1, contadorMuseo.registro(new SalidaT()), "El contador debería aumentar en 1.");
    }

    @Test
    public void testDisminuirPersonas() {
        int personasInicial = contadorMuseo.registro(new SalidaT());
        
        // Simular salida
        contadorMuseo.registro(new SalidaT());
        assertEquals(personasInicial - 1, contadorMuseo.registro(new EntradaT()), "El contador debería disminuir en 1.");
    }

    @Test
    public void testSincronizacionEntradasYSalidas() throws InterruptedException {
        int personasInicial = contadorMuseo.registro(new SalidaT());
        
        // Crear múltiples hilos de entradas y salidas
        Thread entrada1 = new Thread(new EntradaT());
        Thread entrada2 = new Thread(new EntradaT());
        Thread salida1 = new Thread(new SalidaT());
        
        // Ejecutar los hilos simultáneamente
        entrada1.start();
        entrada2.start();
        salida1.start();
        
        // Esperar a que los hilos terminen
        entrada1.join();
        entrada2.join();
        salida1.join();

        // Comprobar si el número final es consistente
        assertEquals(personasInicial + 1, contadorMuseo.registro(new EntradaT()), "El contador debería reflejar correctamente las entradas y salidas simultáneas.");
    }
}
