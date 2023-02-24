public class Main {
    public static final int WIN_POSITION = 100;

    //number of time dice rolled -- notdr
    public static int notdr = 0;

    public static void main(String[] args) {
        System.out.println("Welcome To Snake And Ladder Program");
        int startingPositionOfPlayer1 = 0;
        int startingPositionOfPlayer2 = 0;
        Main m = new Main();
        while (startingPositionOfPlayer1 != WIN_POSITION && startingPositionOfPlayer2 != WIN_POSITION) {
            startingPositionOfPlayer1 = m.gamePlay(startingPositionOfPlayer1);
            if (startingPositionOfPlayer1 != WIN_POSITION) {
                startingPositionOfPlayer2 = m.gamePlay(startingPositionOfPlayer2);
            }
            System.out.println("Player1 Position:- " + startingPositionOfPlayer1);
            System.out.println("Player2 Position:- " + startingPositionOfPlayer2);
            System.out.println("Number times Dice rolled:- " + notdr);

            if (startingPositionOfPlayer1 == WIN_POSITION) {
                System.out.println("Player1 Won the Game");
            } else if (startingPositionOfPlayer2 == WIN_POSITION) {
                System.out.println("Player2 Won the Game");
            }
        }
    }

    public int gamePlay(int startingPosition) {

        /* rollingRotation -- decides which player needs to throw the dice.
        Can use rollingRotaton with an integer value to set 1-to continue set 0-to give chance tonext player
         int rollingRotation=1 */
        boolean rollingRotation = true;

        while (rollingRotation) {
            int rollingDice = (int) (Math.random() * 10) % 6 + 1;
            startingPosition += rollingDice;
            notdr++;
            switch (startingPosition) {
                case 2, 7, 22, 28, 30, 44, 54, 70, 80, 87:
                    switch (startingPosition) {
                        case 2 -> startingPosition = 23;
                        case 7 -> startingPosition = 29;
                        case 22 -> startingPosition = 41;
                        case 28 -> startingPosition = 77;
                        case 30 -> startingPosition = 32;
                        case 44 -> startingPosition = 58;
                        case 54 -> startingPosition = 69;
                        case 70 -> startingPosition = 90;
                        case 80 -> startingPosition = 83;
                        case 87 -> startingPosition = 93;
                    }
                    break;
                case 27, 35, 39, 50, 59, 66, 73, 76, 89, 97, 99:
                    switch (startingPosition) {
                        case 27 -> startingPosition = 7;
                        case 35 -> startingPosition = 5;
                        case 39 -> startingPosition = 3;
                        case 50 -> startingPosition = 34;
                        case 59 -> startingPosition = 46;
                        case 66 -> startingPosition = 24;
                        case 73 -> startingPosition = 12;
                        case 76 -> startingPosition = 63;
                        case 89 -> startingPosition = 67;
                        case 97 -> startingPosition = 86;
                        case 99 -> startingPosition = 26;
                    }
                    rollingRotation = false;
                    break;
            }
            if (startingPosition > WIN_POSITION) {
                startingPosition -= rollingDice;
                rollingRotation=false;
            }
        }
        return startingPosition;
    }
}