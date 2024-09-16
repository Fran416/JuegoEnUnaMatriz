public class JuegoEnUnaMatriz {

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
}
