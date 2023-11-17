
public class Metodos {

    public static final String nombres[] = {"Gerson", "Arlen", "Antonio", "Natha"};

    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

}
