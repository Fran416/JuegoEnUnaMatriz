import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuegoEnUnaMatrizTest {
    String[][] mapaVacio= new String[10][10];

    @BeforeEach
    void setUp() {
        JuegoEnUnaMatriz.generarLimitesMapa(mapaVacio);
    }

    @Test
    void generarLimitesMapa() {
        JuegoEnUnaMatriz.generarLimitesMapa(mapaVacio);
        assertEquals(" # ", mapaVacio[0][0]);
        assertEquals(" # ", mapaVacio[0][1]);
        assertEquals(" # ", mapaVacio[0][2]);
        assertEquals(" # ", mapaVacio[0][3]);
        assertEquals(" # ", mapaVacio[0][4]);
        assertEquals(" # ", mapaVacio[0][5]);
        assertEquals(" # ", mapaVacio[0][6]);
        assertEquals(" # ", mapaVacio[0][7]);
        assertEquals(" # ", mapaVacio[0][8]);
        assertEquals(" # ", mapaVacio[0][9]);
        assertEquals(" # ", mapaVacio[1][0]);
        assertEquals(" # ", mapaVacio[2][0]);
        assertEquals(" # ", mapaVacio[3][0]);
        assertEquals(" # ", mapaVacio[4][0]);
        assertEquals(" # ", mapaVacio[5][0]);
        assertEquals(" # ", mapaVacio[6][0]);
        assertEquals(" # ", mapaVacio[7][0]);
        assertEquals(" # ", mapaVacio[8][0]);
        assertEquals(" # ", mapaVacio[9][0]);
        assertEquals(" # ", mapaVacio[9][1]);
        assertEquals(" # ", mapaVacio[9][2]);
        assertEquals(" # ", mapaVacio[9][3]);
        assertEquals(" # ", mapaVacio[9][4]);
        assertEquals(" # ", mapaVacio[9][5]);
        assertEquals(" # ", mapaVacio[9][6]);
        assertEquals(" # ", mapaVacio[9][7]);
        assertEquals(" # ", mapaVacio[9][8]);
        assertEquals(" # ", mapaVacio[9][9]);
        assertEquals(" # ", mapaVacio[8][9]);
        assertEquals(" # ", mapaVacio[7][9]);
        assertEquals(" # ", mapaVacio[6][9]);
        assertEquals(" # ", mapaVacio[5][9]);
        assertEquals(" # ", mapaVacio[4][9]);
        assertEquals(" # ", mapaVacio[3][9]);
        assertEquals(" # ", mapaVacio[2][9]);
        assertEquals(" # ", mapaVacio[1][9]);
        assertEquals(" # ", mapaVacio[0][9]);

    }
}