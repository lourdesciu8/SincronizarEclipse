package practica2;

public class Monitor {
    private int carga = 0;
    private boolean cicloTerminado = false;
    
    private int tasaCarga = 10;
    private int tasaDescarga = 0;
    
    public synchronized void producir() {
        if (cicloTerminado) return;
        
        carga += tasaCarga;
        if (carga > 100) carga = 100;
        verificarCondiciones();
        imprimirEstado("Productor");
    }
    
    public synchronized void consumir() {
        if (cicloTerminado) return;
        
        carga -= tasaDescarga;
        if (carga < 0) carga = 0;
        verificarCondiciones();
        imprimirEstado("Consumidor");
    }
    
    private void verificarCondiciones() {
        if (carga >= 90 && tasaCarga == 10 && tasaDescarga == 0) {
            tasaDescarga = 5;
            System.out.println("** La batería alcanzó el 90% y empieza a descargar a 5%. **");
        }
        
        if (carga >= 100 && tasaCarga == 10 && tasaDescarga == 5) {
            tasaCarga = 0;
            tasaDescarga = 10;
            System.out.println("** La batería está llena y empieza a descargarse a 10%. **");
        }
        
        if (carga <= 10 && tasaCarga == 0 && tasaDescarga == 10) {
            tasaCarga = 5;
            System.out.println("** La batería bajó al 10% y empieza a cargarse a 5%. **");
        }
        
        if (carga <= 0 && tasaCarga == 5 && tasaDescarga == 10) {
            tasaCarga = 10;
            tasaDescarga = 0;
            System.out.println("** La batería se vació y vuelve a cargarse a 10%. **");
            cicloTerminado = true;
        }
    }
    
    private void imprimirEstado(String origen) {
        System.out.println(origen + " -> Nivel de carga: " + carga + "% (Carga: " + tasaCarga + "%, Descarga: " + tasaDescarga + "%)");
    }
    
    public boolean isCicloTerminado() {
        return cicloTerminado;
    }
}