package Modelo;
/**
 * Esta clase tiene la finalidad de declarar las cualidades de la partida, rondas, puertos, ips..
 * @author Guill
 *
 */
public class DatosPartida {
    public static final String nombreFichero = "RankingDeJugadores.obj";
    public static int rondas = 5;
    public static int partidas = 3;
    public static int ranking = 3;
    public static int puertoServidor = 9999;
    public static int puertoPartida = 1111;
    public static String ipServer = "127.0.0.1";
       
    public static void setRondas(int tandas) {
        DatosPartida.rondas = tandas;
    }

    public static void setPartidas(int partidas) {
        DatosPartida.partidas = partidas;
    }

    public static void setRanking(int ranking) {
        DatosPartida.ranking = ranking;
    }

    public static void setPuerto(int puerto) {
        DatosPartida.puertoServidor = puerto;
    }

    public static void setIpServer(String ipServer) {
        DatosPartida.ipServer = ipServer;
    }       
    
}
