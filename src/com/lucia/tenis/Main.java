package com.lucia.tenis;
public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     * @param pointsPlayer1 puntiacion del jugador 1
     * @param pointsPlayer2 puntiacion del jugador 2
     * @return puntuacion del partido
     */
    public static String getScore(int pointsPlayer1,int pointsPlayer2) {
        /**
         * Puntuacion del partido
         */
        String score = "";
        final int MAX_SCORE = 4;

        if (pointsPlayer1 == pointsPlayer2) { // Empate
            switch (pointsPlayer1)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (pointsPlayer1 >= MAX_SCORE || pointsPlayer2 >= MAX_SCORE) // Ventaja o Ganar
        {
            final int ADAVNTAGE_ONE = 1;
            final int ADVANTAGE_TWO = 2;

            int diferenceInPoints = pointsPlayer1-pointsPlayer2;
            if (diferenceInPoints==ADAVNTAGE_ONE) score ="Advantage player1";
            else if (diferenceInPoints ==-ADAVNTAGE_ONE) score ="Advantage player2";
            else if (diferenceInPoints>=ADVANTAGE_TWO) score = "Win for player1";
            else score ="Win for player2";
        }
        else // Puntuacion Regular
        {
            for (int i=1; i<3; i++)
            {
                int temporalScore=0;
                if (i==1) temporalScore = pointsPlayer1;
                else { score+="-"; temporalScore = pointsPlayer2;}
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

        }
    return score;
    }
}