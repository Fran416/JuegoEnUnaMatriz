import java.util.Objects;
import java.util.Scanner;

public class JuegoEnUnaMatriz {

    public static void main(String[] args) {
        String[][] mapa = new String[10][10];
        Object[] jugadorData = new Object[3];
        inicializarJuego(mapa, jugadorData);
    }

    public static void inicializarJuego(String[][] mapa, Object[] jugadorData){
        generarLimitesMapa(mapa);
        ponerJugadorYFin(mapa);
        int[] posicionJugador = new int[2];
        posicionJugador[0] = 1;
        posicionJugador[1] = 1;
        while (true){
            actualizarJugadorData(jugadorData, posicionJugador, 100, 15);
            mostrarMapa(mapa);
            System.out.print("Su direccion: ");
            String letra = obtenerLetra();
            mapa = moverJugador(mapa, (int[])jugadorData[0], letra);
            posicionJugador = coordenadasActualesJugador(mapa);
        }
    }

    public static void mostrarMapa(String[][] mapa){
        for (int i = 0; i < mapa.length; i++){
            System.out.print(mapa[i][0]);
            System.out.print(mapa[i][1]);
            System.out.print(mapa[i][2]);
            System.out.print(mapa[i][3]);
            System.out.print(mapa[i][4]);
            System.out.print(mapa[i][5]);
            System.out.print(mapa[i][6]);
            System.out.print(mapa[i][7]);
            System.out.print(mapa[i][8]);
            System.out.println(mapa[i][9]);
        }
    }

    public static String[][] moverJugador(String[][] mapa, int[] coordenadasJugador, String letraDireccion){
        //                 w - Arriba
        // a - Izquierda | s - Abajo  | d - Derecha
        int fila = coordenadasJugador[0];
        int columna = coordenadasJugador[1];

        if (Objects.equals(letraDireccion, "w")){
            mapa[fila][columna] = " . ";
            mapa[fila - 1][columna] = " P ";
        } else if (Objects.equals(letraDireccion, "s")){
            mapa[fila][columna] = " . ";
            mapa[fila + 1][columna] = " P ";
        } else if (Objects.equals(letraDireccion, "d")){
            mapa[fila][columna] = " . ";
            mapa[fila][columna + 1] = " P ";
        } else if (Objects.equals(letraDireccion, "a")){
            mapa[fila][columna] = " . ";
            mapa[fila][columna - 1] = " P ";
        } else {
            System.out.println("error");
        }
        return mapa;
    }

    public static Object[] actualizarJugadorData(Object[] jugadorData, int[] coordenadasActualesJugador, int saludActual, int ataqueActual){
        jugadorData[0] = coordenadasActualesJugador;
        jugadorData[1] = saludActual;
        jugadorData[2] = ataqueActual;
        return jugadorData;
    }

    public static int[] coordenadasActualesJugador(String[][] mapa){
        int[] coordenadasActualesJugador = new int[2];
        for (int i = 0; i < mapa.length; i++){
            for (int j = 0; j < mapa[i].length; j++){
                if (mapa[i][j] == " P "){
                    coordenadasActualesJugador[0] = i;
                    coordenadasActualesJugador[1] = j;
                }
            }
        }
        return coordenadasActualesJugador;
    }

    public static String[][] ponerJugadorYFin(String[][] mapa){
        mapa[1][1] = " P ";
        mapa[8][8] = " X ";
        return mapa;
    }

    public static String[][] generarLimitesMapa(String[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (i == 0) {
                    mapa[i][j] = " # ";
                } else if (j == 0){
                    mapa[i][j] = " # ";
                } else if (i == mapa.length - 1) {
                    mapa[i][j] = " # ";
                } else if (j == mapa.length - 1) {
                    mapa[i][j] = " # ";
                } else {
                    mapa[i][j] = " . ";
                }
            }
        }
        return mapa;
    }

    public static String obtenerLetra(){
        Scanner entrada = new Scanner(System.in);
        return entrada.nextLine();
    }
}
