public class Monitor {
    private int volumen = 0;
    
    // Tasas actuales
    private int tasaLlenado = 10;
    private int tasaVaciado = 0;
    
    private boolean cicloTerminado = false;
    
    // Estados:
    // Fases (descriptivo):
    // 1. Llenando (10 L/s), sin vaciar, hasta llegar a 900 L.
    // 2. Al llegar a >=900 L: Llenando (10 L/s) y Vaciando (5 L/s) hasta 1000 L.
    // 3. Al llegar a >=1000 L: Dejar de llenar (0 L/s), Vaciar (10 L/s) hasta 100 L.
    // 4. Al llegar a <=100 L: Llenar (5 L/s) y Vaciar (10 L/s) hasta 0 L.
    // 5. Al llegar a <=0 L: dejar de vaciar, Llenar (10 L/s) y ciclo terminado.
    
    public synchronized void producir() {
        if (cicloTerminado) return; // Si ya hemos terminado, no hacer nada
        
        // Añadimos el agua según la tasa de llenado
        if (tasaLlenado > 0) {
            volumen += tasaLlenado;
        }
        
        // Después de producir, verificamos las condiciones del estado
        verificarCondiciones();
        
        imprimirEstado("Productor");
    }
    
    public synchronized void consumir() {
        if (cicloTerminado) return; // Si ya hemos terminado, no hacer nada
        
        // Restamos el agua según la tasa de vaciado
        if (tasaVaciado > 0) {
            volumen -= tasaVaciado;
            if (volumen < 0) volumen = 0; // No bajamos de 0, por seguridad
        }
        
        // Después de consumir, verificamos las condiciones del estado
        verificarCondiciones();
        
        imprimirEstado("Consumidor");
    }
    
    private void verificarCondiciones() {
        // Reglas según el enunciado:
        // 1. Comienzo: fill=10, drain=0. Hasta llegar a 900 L.
        // Al llegar a 900 L: activamos vaciado=5 mientras llenamos=10.
        if (volumen >= 900 && tasaLlenado == 10 && tasaVaciado == 0) {
            tasaLlenado = 10;
            tasaVaciado = 5;
            System.out.println("** Al llegar a 900 litros: se empieza a vaciar a 5 L/s (seguimos llenando a 10 L/s). **");
        }
        
        // Al llegar a 1000 L: paramos llenado (0) y vaciamos a 10 L/s.
        if (volumen >= 1000 && tasaLlenado == 10 && tasaVaciado == 5) {
            tasaLlenado = 0;
            tasaVaciado = 10;
            System.out.println("** Al llegar a 1000 litros: se para el llenado y se vacía a 10 L/s. **");
        }
        
        // Al llegar a 100 L: llenado=5 L/s y vaciado=10 L/s
        if (volumen <= 100 && tasaLlenado == 0 && tasaVaciado == 10) {
            tasaLlenado = 5;
            tasaVaciado = 10;
            System.out.println("** Al llegar a 100 litros: se activa el llenado a 5 L/s mientras se vacía a 10 L/s. **");
        }
        
        // Al llegar a 0 L: paramos el vaciado (0) y llenamos a 10 L/s, ciclo completo.
        if (volumen <= 0 && tasaLlenado == 5 && tasaVaciado == 10) {
            tasaLlenado = 10;
            tasaVaciado = 0;
            System.out.println("** Al llegar a 0 litros: se para el vaciado y se vuelve a llenar a 10 L/s. Ciclo completo. **");
            cicloTerminado = true;
        }
    }
    
    private void imprimirEstado(String origen) {
        // Imprimimos el estado actual del depósito después de la operación
        // Indicamos las tasas utilizadas en esta acción
        System.out.println(origen + " -> Volumen: " + volumen + " L (Llenando: " + tasaLlenado + " L/s, Vaciando: " + tasaVaciado + " L/s)");
    }
    
    public boolean isCicloTerminado() {
        return cicloTerminado;
    }
}
