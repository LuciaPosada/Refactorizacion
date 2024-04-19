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

    private static boolean isTie (int pointsPlayer1,int pointsPlayer2){
        return pointsPlayer1 == pointsPlayer2;
    }

    private static boolean isAdvantage (int pointsPlayer1,int pointsPlayer2){
        final int MAX_SCORE = 4;
        return pointsPlayer1 >= MAX_SCORE || pointsPlayer2 >= MAX_SCORE;
    }

    private static String findTieScore(int pointsPlayer){
        switch (pointsPlayer) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static String findAdvantageScore(int pointsPlayer1,int pointsPlayer2){
        final int ADAVNTAGE_ONE = 1;
        final int ADVANTAGE_TWO = 2;

        int diferenceInPoints = pointsPlayer1-pointsPlayer2;

        if (diferenceInPoints==ADAVNTAGE_ONE){
            return "Advantage player1";
        } else if (diferenceInPoints ==-ADAVNTAGE_ONE){
            return "Advantage player2";
        } else if (diferenceInPoints>=ADVANTAGE_TWO){
            return "Win for player1";
        }else{
            return "Win for player2";
        }
    }

    private static String findRegularScore(int pointsPlayer1,int pointsPlayer2){
        String score = "";
        int COMPROBACION_JUGADOR_1 = 1;
        for (int i=1; i<3; i++) {
            int temporalScore=0;
            if (i==COMPROBACION_JUGADOR_1){
                temporalScore = pointsPlayer1;
            } else {
                score+="-";
                temporalScore = pointsPlayer2;
            }
            switch(temporalScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
}