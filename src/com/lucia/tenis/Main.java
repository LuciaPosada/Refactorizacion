package com.lucia.tenis;
public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     * @param pointsPlayer1 puntiacion del jugador 1
     * @param pointsPlayer2 puntiacion del jugador 2
     * @return puntuacion del partido
     */
    public static String getScore(int pointsPlayer1,int pointsPlayer2) {
        if (isTie(pointsPlayer1,pointsPlayer2)) { // Empate
            return findTieScore(pointsPlayer1);
        }else if (isAdvantage(pointsPlayer1,pointsPlayer2)){ // Ventaja o Ganar
            return findAdvantageScore(pointsPlayer1,pointsPlayer2);
        }else{ // Puntuacion Regular
            return findRegularScore(pointsPlayer1,pointsPlayer2);
        }
    }

    /**
     * Comprueba si el partido esta empatado
     * @param pointsPlayer1 puntiacion del jugador 1
     * @param pointsPlayer2 puntiacion del jugador 2
     * @return confirmacion
     */
    private static boolean isTie (int pointsPlayer1,int pointsPlayer2){
        return pointsPlayer1 == pointsPlayer2;
    }

    /**
     * Comprueba si alhun jugador tiene ventaja
     * @param pointsPlayer1 puntiacion del jugador 1
     * @param pointsPlayer2 puntiacion del jugador 2
     * @return confirmacion
     */
    private static boolean isAdvantage (int pointsPlayer1,int pointsPlayer2){
        final int MAX_SCORE = 4;
        return pointsPlayer1 >= MAX_SCORE || pointsPlayer2 >= MAX_SCORE;
    }

    /**
     * Elije la puntuacion correspondiente segun los puntos de los jugador(es) en caso del que partido este empatado
     * @param pointsPlayer puntuacion de uno de los jugadores
     * @return la puntuacion en caso de ser empate
     */
    private static String findTieScore(int pointsPlayer){
        String[] textScore = new String[] {"Love-All","Fifteen-All","Thirty-All","Forty-All","Deuce"};
        return textScore[pointsPlayer];
    }

    /**
     * Elije la puntuacion correspondiente segun los puntos de los jugadores en caso de qu algun jugador tenga ventaja
     * @param pointsPlayer1 puntiacion del jugador 1
     * @param pointsPlayer2 puntiacion del jugador 2
     * @return la puntuacion en caso de ser ventaja
     */
    private static String findAdvantageScore(int pointsPlayer1,int pointsPlayer2){
        final int ADAVNTAGE_ONE = 1;
        final int ADVANTAGE_TWO = 2;

        String[] textScore = new String[] {"Advantage player1","Advantage player2","Win for player1","Win for player2"};

        int diferenceInPoints = pointsPlayer1-pointsPlayer2;

        if (diferenceInPoints==ADAVNTAGE_ONE){
            return textScore[0];
        } else if (diferenceInPoints ==-ADAVNTAGE_ONE){
            return textScore[1];
        } else if (diferenceInPoints>=ADVANTAGE_TWO){
            return textScore[2];
        }else{
            return textScore[3];
        }
    }

    /**
     * Elije la puntuacion correspondiente segun los puntos de los jugadores
     * @param pointsPlayer1 puntiacion del jugador 1
     * @param pointsPlayer2 puntiacion del jugador 2
     * @return la puntuacion regular
     */
    private static String findRegularScore(int pointsPlayer1,int pointsPlayer2){

        String score = "";
        String[] textScore = new String[] {"Love","Fifteen","Thirty","Forty","-"};

        return textScore[pointsPlayer1]+textScore[4]+textScore[pointsPlayer2];
    }
}