
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * @author Alejandra
 * @author carlos
 */
public class CPU extends Thread {
    // algoritmo
    // 1 = FCFS
    // 2 = Round Robim
    // 3 = colas multiples
    private int algoritmo;
    private Proceso[] cola; 
    private Proceso enEjecucion; 
    private ejecucion VMenu;
//    A = 5
//    B = 10
//    C = 15
//    D = 20
//    E = 25
//    F = 30
    public int[] tiemposDPrioridad = {5,10,15,20,25,30};
    public int tamaño;
    private int quantumsPredefinidos = 5;

    public CPU(ejecucion visual, int algoritmo, int tamaño){
        this.algoritmo = algoritmo;
        this.tamaño = tamaño;
        this.cola = new Proceso[tamaño];
        this.VMenu = visual;
        this.limpiarVista();
    }
    @Override
    public void run(){
        try {
            this.traerAEjecucion();
        } catch (InterruptedException ex) {
            System.out.println("error" + CPU.class.getName() + ex);
        }
        
        try {
            Thread.sleep(2000);
            this.VMenu.regresar();
        } catch (InterruptedException ex) {
            Logger.getLogger(CPU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void traerAEjecucion() throws InterruptedException{
        this.recorrer();
        switch(this.algoritmo){
            case 2:{
                this.esIncompleto();
                break;
            }
            case 3:{
                this.esIncompleto();
                this.ordenarPorPrioridad();
                break;
            }
        }

        if (this.cola[0] != null && !this.cola[0].eliminable() ) {
            this.enEjecucion = this.cola[0];
            this.cola[0] = null;
            this.recorrer();
            this.Ejecutar();
        }
        this.imprimir();
    }

    public void Ejecutar() throws InterruptedException{
        switch(this.algoritmo) {
            case 1:{
                while (this.enEjecucion != null && this.enEjecucion.ejecutable()) {
                    Thread.sleep(1000);
                    this.imprimir();
                }
                this.traerAEjecucion();
                break;
            }
            case 2:{
                int auxTiempo = this.quantumsPredefinidos;
                while (this.enEjecucion != null && this.tiempoRR()) {
                    Thread.sleep(1000);
                    this.imprimir();
                }
                this.quantumsPredefinidos = auxTiempo;
                this.traerAEjecucion();
                break;
            }
            case 3:{
                switch(this.enEjecucion.obtenerPrioridad()){
                    case "A":{
                        this.quantumsPredefinidos = this.tiemposDPrioridad[0];
                        break;
                    }
                    case "B":{
                        this.quantumsPredefinidos = this.tiemposDPrioridad[1];
                        break;
                    }
                    case "C":{
                        this.quantumsPredefinidos = this.tiemposDPrioridad[2];
                        break;
                    }
                    case "D":{
                        this.quantumsPredefinidos = this.tiemposDPrioridad[3];
                        break;
                    }
                    case "E":{
                        this.quantumsPredefinidos = this.tiemposDPrioridad[4];
                        break;
                    }
                    case "F":{
                        this.quantumsPredefinidos = this.tiemposDPrioridad[5];
                        break;
                    }
                }
                while (this.enEjecucion != null && this.tiempoMC()) {
                    Thread.sleep(1000);
                    this.imprimir();
                }
                this.enEjecucion.degradar();
                this.traerAEjecucion();
                break;
            }
        }
    }
    
    public void limpiarVista(){
        for (int pocision = 0; pocision < this.tamaño; pocision++) {
                this.VMenu.nombres[pocision].setText(" ");
                this.VMenu.prioridades[pocision].setText(" ");
                this.VMenu.quantums[pocision].setText(" ");
        }
        this.VMenu.MostrarDatosEnEjecucion(" "," "," ");
    }
    public void imprimir(){
        this.limpiarVista();
        int pocision = 0;
        for (Proceso proceso : this.cola) {
            if (proceso != null) {
                System.out.println(proceso.toString());
                this.VMenu.nombres[pocision].setText(proceso.getNombre());
                this.VMenu.prioridades[pocision].setText(proceso.obtenerPrioridad());
                this.VMenu.quantums[pocision].setText(proceso.getTiempo());
                pocision ++;
            }
        }
        if (this.enEjecucion != null) {
            this.VMenu.MostrarDatosEnEjecucion(this.enEjecucion.getNombre(),this.enEjecucion.getTiempo(),this.enEjecucion.obtenerPrioridad());
             System.out.println("ejecutando: "+ this.enEjecucion);
        }
    }
    public void esIncompleto(){
        boolean escrito = false;
         if ( this.enEjecucion != null && !this.enEjecucion.eliminable()) {
            int posicion = 0;
            while (!escrito && posicion < this.tamaño) {
                if(this.cola[posicion] == null){
                        this.cola[posicion] = this.enEjecucion;
                        this.enEjecucion = null;
                        escrito = true;
                }
                posicion++;
            }
        }
    }
        
    public void recorrer(){
        Proceso[] aux = new Proceso[this.tamaño]; 
         for (Proceso proceso : this.cola) {
            boolean escrito = false;
            int posicion = 0;
            while (!escrito && posicion < this.tamaño && proceso != null && !proceso.eliminable()) {
                if(aux[posicion] == null){
                        aux[posicion] = proceso;
                        escrito = true;
                }
                posicion++;
            }
        }
         this.cola = aux;
    }
    /**
     *
     * @param nombre
     * @param tiempo
     * @param prioridad
     */
    public void nuevoProceso(String nombre, int tiempo, char prioridad){
        boolean escrito = false;
        int posicion = 0;
        while (!escrito && posicion < this.tamaño) {
            if(this.cola[posicion] == null){
                if(this.algoritmo!= 3){
                    this.cola[posicion] = new Proceso(nombre, tiempo);
                    escrito = true;
                    this.imprimir();
                }else{
                    this.cola[posicion] = new Proceso(nombre, tiempo, prioridad);
                    escrito = true;
                    this.imprimir();
                }
            }
            posicion++;
        }
        if (!escrito) {
            JOptionPane.showMessageDialog(VMenu, "ya no hay mas espacio");
        }
    }

    public boolean activar() {
        return this.algoritmo == 3;
    }

    private boolean tiempoRR() {
        this.enEjecucion.ejecutable();
        return (--this.quantumsPredefinidos > 0 && !this.enEjecucion.eliminable());
    }
    
    private boolean tiempoMC() {
        this.enEjecucion.ejecutable();
        return (--this.quantumsPredefinidos > 0 && !this.enEjecucion.eliminable());
    }
    public void setTiempoRoundRobin(){
        this.quantumsPredefinidos = Integer.parseInt(JOptionPane.showInputDialog(this.VMenu, "Ingresa el tiempo de ejecucion base"));
    }

    private void ordenarPorPrioridad() {
        Proceso procesoAIntercambiar;
        int posicionDelmenor = 0;
        for (int posicionA = 0; posicionA < this.tamaño; posicionA++) {
            posicionDelmenor = posicionA;
            for (int posicionB = posicionA+1; posicionB < this.tamaño; posicionB++) {
                if (this.cola[posicionDelmenor] != null && this.cola[posicionB] != null) {
                    if (this.cola[posicionDelmenor].prioridad() > this.cola[posicionB].prioridad()) {
                        posicionDelmenor = posicionB;
                    }
                }
            }
            procesoAIntercambiar = this.cola[posicionA];
            this.cola[posicionA] = this.cola[posicionDelmenor];
            this.cola[posicionDelmenor] = procesoAIntercambiar;
        }
    }
}
