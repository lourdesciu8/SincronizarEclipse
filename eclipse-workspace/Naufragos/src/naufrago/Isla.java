package naufrago;

//Clase que representa la isla donde están los náufragos
class Isla {
    private int naufragos;
    private int turno = 1; // Controla el turno de cada balsa

    public Isla(int naufragos) {
        this.naufragos = naufragos;
    }

    public synchronized void rescatar(int id, int capacidad) throws InterruptedException {
        while (naufragos > 0) { // Mientras haya naufragos por rescatar
            // Espera su turno para rescatar
            while (turno != id) {
                wait();
            }
            
            // Si aún hay naufragos, la balsa rescata
            if (naufragos > 0) {
                int rescatados = Math.min(naufragos, capacidad); // Rescata hasta la capacidad de la balsa
                naufragos -= rescatados; // Reduce la cantidad de naufragos
                System.out.println("Balsa " + id + " rescata " + rescatados + " náufragos. Quedan " + naufragos);
            }

            // Cambia el turno a la siguiente balsa
            turno = (turno % 3) + 1; // esto actualiza el valor de turno de forma que siempre esté entre 1, 2 y 3. 
            notifyAll(); // Notifica a las otras balsas que es su turno
            Thread.sleep(500); // Simula el tiempo de rescate
        }
    }
    
    
    
    
        public static void main(String[] args) {
            int numNaufragos = 49; // Número total de náufragos
            int capacidadBalsa = 3; // Capacidad de cada balsa

            Isla isla = new Isla(numNaufragos); // Crea la isla con los naufragos

            // Crear las balsas
            Balsa balsaA = new Balsa(1, capacidadBalsa, isla);
            Balsa balsaB = new Balsa(2, capacidadBalsa, isla);
            Balsa balsaC = new Balsa(3, capacidadBalsa, isla);

            // Iniciar las balsas
            balsaA.start();
            balsaB.start();
            balsaC.start();

            try {
                // Esperar a que todas las balsas terminen
                balsaA.join();
                balsaB.join();
                balsaC.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Todos los náufragos han sido rescatados.");
    }
}

/*
 * la operación Math.min(naufragos, capacidad) devuelve el valor más pequeño entre naufragos y capacidad.
 * ejemplo si hay 6 náufragos y la cpacidad de la balsa es 3 entonces toma el valor de la capacidad y
 *  la almacena en la variable rescatados para decrementar los naufragos -> rescatados -= naufragos.
 *  
 *  
 *  la operación  turno = (turno % 3) + 1; el valor inicial de turno es 1  entonces sería 1%3 +1 = 2.   2%3 +1 = 3. 3%3 +1 = 1.
 *  de esta manera asegura que el turno siempre siga 1, 2 y 3.
 * 
 * 
 * **/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	