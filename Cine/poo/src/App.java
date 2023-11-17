import java.util.Scanner;
public class App {

    public static void main(String[] args) {

        //Creo la pelicula
        Pelicula pelicula = new Pelicula("Mi vida", 90, 16, "DDR");
        
        // Pido datos 
        // No valida nada al respecto de tamaños (siguiente version)
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce el numero de filas");
        int filas=sn.nextInt();
        
        System.out.println("Intrdouce el numero de columnas");
        int columnas=sn.nextInt();
        
        System.out.println("Introduce el precio de la entrada de cine");
        double precio=sn.nextDouble();
        
        //Creo el cine, necesito la pelicula para ello
        Cine cine = new Cine(filas, columnas, precio, pelicula);

        //Numero de espectadores que seran creados
        System.out.println("Introduce el numero de espectadores a crear");
        int numEspectadores = sn.nextInt();

        //Variables y objetos usados
        Espectador e;
        int fila;
        char letra;

        System.out.println("Espectadores generados: ");
        
        //Termino cuando no queden espectadores o no haya mas sitio en el cine
        for (int i = 0; i < numEspectadores && cine.haySitio(); i++) {

            //Generamos un espectador
            e = new Espectador(
                
                    //Nombre al azar
                    Metodos.nombres[Metodos.generaNumeroEnteroAleatorio(0, Metodos.nombres.length - 1)], 
                
                     //Generamos una edad entre 10 y 30
                    Metodos.generaNumeroEnteroAleatorio(10, 30),
                
                    //Generamos el dinero entre 1 y 10 euros
                    Metodos.generaNumeroEnteroAleatorio(1, 10)); 

            //Mostramos la informacion del espectador
            System.out.println(e);
            
            //Generamos una fila y letra
            //Si esta libre continua sino busca de nuevo
            do {

                fila = Metodos.generaNumeroEnteroAleatorio(0, cine.getFilas() - 1);
                letra = (char) Metodos.generaNumeroEnteroAleatorio('A', 'A' + (cine.getColumnas()-1));

            } while (cine.haySitioButaca(fila, letra));

            //Si el espectador cumple con las condiciones
            if (cine.sePuedeSentar(e)) {
                
                //El espectador paga el precio de la entrada
                e.pagar(cine.getPrecio()); 

                //El espectador se sienta
                cine.sentar(fila, letra, e); 
            }

        }

        System.out.println("");
         //Mostramos la información del cine, tambien se puede usar un toString
        cine.mostrar();
        
        System.out.println("****Fin del programa*****");

       sn.close();
        
    }

}
