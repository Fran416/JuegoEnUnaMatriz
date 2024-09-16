import java.util.Objects;
import java.util.Random;
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
        int saludInicial = 100;
        int ataqueInicial = 15;
        jugadorData[0] = posicionJugador;
        jugadorData[1] = saludInicial;
        jugadorData[2] = ataqueInicial;
    }

    public static void jugar (String[][] mapa, Object[] jugadorData){
        boolean vivo = true;
        int[] posicionJugador = (int[])jugadorData[0];
        int saludActual = (int) jugadorData[1];
        int ataqueActual = (int) jugadorData[2];
        while (vivo){
            actualizarJugadorData(jugadorData, posicionJugador, saludActual, ataqueActual);
            mostrarMapa(mapa);
            System.out.print("Su direccion: ");
            String letra = obtenerLetra();
            String evento = verificarEventoDelMapa(mapa, posicionJugador, letra);
            if (evento == "noMover"){
                moverJugador(mapa, posicionJugador, "noMover");
            } else if (evento == "mover") {
                moverJugador(mapa, posicionJugador, letra);
            } else if (evento == "enemigo") {
                //Funcion para entrar en combate con el enemigo en cuestion
                moverJugador(mapa, posicionJugador, letra);
            } else if (evento == "cofre") {
                //Funcion para entrar en el evento de cofre
                moverJugador(mapa, posicionJugador, letra);
            }
            posicionJugador = coordenadasActualesJugador(mapa);

        }
    }

    public static String verificarEventoDelMapa(String[][] mapa, int[] posicionJugador, String letraDireccion){
        //                 w - Arriba
        // a - Izquierda | s - Abajo  | d - Derecha
        int fila = posicionJugador[0];
        int columna = posicionJugador[1];

        if (Objects.equals(letraDireccion, "w")){
            if (mapa[fila-1][columna] == " # "){
                return "noMover";
            } else if (mapa[fila-1][columna] == " C ") {
                return "cofre";
            } else if (mapa[fila-1][columna] == " E ") {
                return "enemigo";
            } else {
                return "mover";
            }
        } else if (Objects.equals(letraDireccion, "s")){
            if (mapa[fila+1][columna] == " # "){
                return "noMover";
            } else if (mapa[fila+1][columna] == " C ") {
                return "cofre";
            } else if (mapa[fila+1][columna] == " E ") {
                return "enemigo";
            } else {
                return "mover";
            }
        } else if (Objects.equals(letraDireccion, "d")){
            if (mapa[fila][columna+1] == " # "){
                return "noMover";
            } else if (mapa[fila][columna+1] == " C ") {
                return "cofre";
            } else if (mapa[fila][columna+1] == " E ") {
                return "enemigo";
            } else {
                return "mover";
            }
        } else if (Objects.equals(letraDireccion, "a")){
            if (mapa[fila][columna-1] == " # "){
                return "noMover";
            } else if (mapa[fila][columna-1] == " C ") {
                return "cofre";
            } else if (mapa[fila][columna-1] == " E ") {
                return "enemigo";
            } else {
                return "mover";
            }
        }
        return "pasar";
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

    public static int numeroAleatorio (int numeroMenor, int numeroMayor){
        Random random = new Random();
        return random.nextInt(numeroMenor, numeroMayor);
    }

    public static boolean boleanoAleatorio(){
        Random random = new Random();
        return random.nextBoolean();
    }

    public static String obtenerLetra(){
        Scanner entrada = new Scanner(System.in);
        return entrada.nextLine();
    }
}
