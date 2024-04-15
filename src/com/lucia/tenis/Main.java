package com.lucia.tenis;
public class Main {
    /**
     * metodo para devolver la puntuacion de tenis
     * @param pointsPlayer1 puntiacion del jugador 1
     * @param pointsPlayer2 puntiacion del jugador 2
     * @return resultado del partido
     */
    public static String getScore(int pointsPlayer1,int pointsPlayer2) {
        String score = "";
        final int ADVANTAGE = 4;

        if (pointsPlayer1 == pointsPlayer2) {
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
        else if (pointsPlayer1 >= ADVANTAGE || pointsPlayer2 >= ADVANTAGE)
        {
            int diferenceInPoints = pointsPlayer1-pointsPlayer2;
            if (diferenceInPoints==1) score ="Advantage player1";
            else if (diferenceInPoints ==-1) score ="Advantage player2";
            else if (diferenceInPoints>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
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