package ru.geekbrains.java1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainClass {
    //human sign
    private static final char HUMAN_SIGN = 'X';
    //bot sign
    private static final char AI_SIGN = 'O';
    //empty sign
    private static final char EMPTY_SIGN = '\u058D';
    //game field size
    private static int gameFieldSize;
    //game field
    private static char[][] gameFiled;
    //Scanner obj
    private static Scanner userInput = new Scanner(System.in);
    //win condition
    private static int winCondition;
    //random
    private static Random random = new Random();


    public static void main(String[] args){
        createGameField();
        printGameField(gameFiled);

        //game
        do{
            humanTurn();
            printGameField(gameFiled);
            if(checkWin(HUMAN_SIGN)) {
                if(repeatGame("human")) {
                    createGameField();
                    continue;
                };
            }
            aiTurn();
            printGameField(gameFiled);
            if(checkWin(AI_SIGN)) {
                if(repeatGame("ai")) {
                    createGameField();
                    continue;
                };
            }

        } while(!checkWin(AI_SIGN) && !checkWin(HUMAN_SIGN) && !checkDraw());
    }

    //human turn
    private static void humanTurn(){
        int coordinateX;
        int coordinateY;
        do {
            System.out.println("Введите координаты X и Y: ");
            coordinateX = userInput.nextInt() - 1;
            coordinateY = userInput.nextInt() - 1;
        } while (!validCell(coordinateX, coordinateY) && checkEmpty(coordinateX,coordinateY));
        gameFiled[coordinateX][coordinateY] = HUMAN_SIGN;
    }

    //ai turn
        private static void aiTurn(){
            int X;
            int Y;
            do {
                X = random.nextInt(gameFieldSize);
                Y = random.nextInt(gameFieldSize);
            } while(!validCell(X, Y) && !checkEmpty(X,Y));
            gameFiled[X][Y] = AI_SIGN;
        }
    //create game field
    private static void createGameField(){
        System.out.println("Введите размерность поля: ");
        gameFieldSize = userInput.nextInt();
        gameFiled = new char[gameFieldSize][gameFieldSize];
        for (int i = 0; i < gameFiled.length; i++){
            for (int z = 0; z < gameFiled[i].length; z++){
                gameFiled[i][z] = EMPTY_SIGN;
            }
        }
    }

    //print game field
    private static void printGameField(char[][] array){
        for (int i = 0; i <= array.length; i++){
            System.out.print(i == 0 ? " ": i + " ");
            for (int z = 0; z < array.length + 1; z++){
                if(i == 0 && z < array[i].length){
                    System.out.print(z + 1 + " ");
                    continue;
                }
                System.out.print(i > 0 && z > 0 ? array[i - 1][z - 1] + " ": "");
            }
            System.out.println();
        }
    }
    //valid cell
    private static boolean validCell(int x, int y){
        return x < gameFieldSize && y < gameFiled[x].length;
    }
    //empty cell
    private static boolean checkEmpty(int x, int y){
        return validCell(x, y) && gameFiled[x][y] == EMPTY_SIGN;
    }

    //checkwin
    private static boolean checkWin(char turnSIGN){
        winCondition = 4;
        boolean result = false;
        int diagLR = 0;
        int diagRL = 0;
        for(int i = 0; i < gameFiled.length; i++){
            if (result) break;
            int col = 0;
            int row = 0;
            for (int z = 0; z < gameFiled[i].length; z++){
                if(gameFiled[i][z] == turnSIGN) row++;
                if(gameFiled[z][i] == turnSIGN) col++;
                if(i == z && gameFiled[i][z] == turnSIGN) diagLR++;
                if(z == gameFiled[i].length - i - 1 && gameFiled[i][z] == turnSIGN) diagRL++;
                if(diagLR == winCondition || diagRL == winCondition || col == winCondition || row  == winCondition){
                    result = true;
                }
            }
        }
        return result;
    }
    //checkdraw
    private static boolean checkDraw(){
        boolean result = true;
        for (int i = 0; i < gameFiled.length; i++){
            if(result == false) break;
            for (int z = 0; z < gameFiled[i].length; i++){
                if(gameFiled[i][z] == EMPTY_SIGN){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    //repeat
    private static boolean repeatGame(String a){
        System.out.println("Победил " + a + "\n"
                            + "! Желаете повторить игру?");
        String answer = userInput.nextLine();
        return answer.toLowerCase() == "yes" || answer.toLowerCase() == "да";
    }
}
/*

    Давно делал аналогичное задание, хотел сейчас переделать, но не успел.
    В коде ниже много воды и названия переменных... без 100гр сам не разуберусь.
    Ход компьютера на основе рейтинга.

    //Ход компьютера
    private static int[] makeRating() {
        aiRatingC = new int[gameFieldSize][4];
        aiRatingR = new int[gameFieldSize][4];
        aiRatingLR = new int[gameFieldSize][4];
        aiRatingRL = new int[gameFieldSize][4];
        whoIsWin = new int[4];
        boolean checkLR, checkRL;
        checkLR = true;
        checkRL = true;
        for (int i = 0; i < gameFieldSize; i++) {
            for (int z = 0; z < gameFieldSize; z++) {
                //Проверяю строки
                if (gameField[i][z] == AI_CHAR) {
                    aiRatingC[i][0] = i;
                    aiRatingC[i][1]++;
                } else if (gameField[i][z] == EMPTY_SIGN) {
                    aiRatingC[i][0] = i;
                    aiRatingC[i][2]++;
                } else if (gameField[i][z] == PLAYER_CHAR) {
                    aiRatingC[i][0] = i;
                    aiRatingC[i][3]++;
                }
                //Проверяю столбцы
                if (gameField[z][i] == AI_CHAR) {
                    aiRatingR[i][0] = i;
                    aiRatingR[i][1]++;
                } else if (gameField[z][i] == EMPTY_SIGN) {
                    aiRatingR[i][0] = i;
                    aiRatingR[i][2]++;
                } else if (gameField[z][i] == PLAYER_CHAR) {
                    aiRatingR[i][0] = i;
                    aiRatingR[i][3]++;
                }
            }
            //Проверка диагонали ЛП
            if (gameField[i][i] == AI_CHAR) {
                aiRatingLR[i][0] = 777;
                aiRatingLR[i][1]++;
            } else if (gameField[i][i] == EMPTY_SIGN) {
                aiRatingLR[i][0] = 777;
                aiRatingLR[i][2]++;
            } else if (gameField[i][i] == PLAYER_CHAR) {
                aiRatingLR[i][0] = 777;
                aiRatingLR[i][3]++;
            }
            //Проверка диагонали ПП
            if (gameField[gameFieldSize - i - 1][i] == AI_CHAR) {
                aiRatingRL[i][0] = 776;
                aiRatingRL[i][1]++;
            } else if (gameField[gameFieldSize - i - 1][i] == EMPTY_SIGN) {
                aiRatingRL[i][0] = 776;
                aiRatingRL[i][2]++;
            } else if (gameField[gameFieldSize - i - 1][i] == PLAYER_CHAR) {
                aiRatingRL[i][0] = 776;
                aiRatingRL[i][3]++;
            }
        }
        //Отсеиваем диагонали
        int sumLRb = 0;
        int sumRLb = 0;
        int sumLRg = 0;
        int sumRLg = 0;
        for (int i = 0; i < gameFieldSize; i++) {
            if (aiRatingLR[i][3] > 0) {
                checkLR = false;
                for (int a = 0; a < gameFieldSize; a++) {
                    sumLRb += aiRatingLR[a][3];
                    sumLRg += aiRatingLR[a][1];
                }
                break;
            }
        }
        for (int i = 0; i < gameFieldSize; i++) {
            if (aiRatingRL[i][3] > 0) {
                checkRL = false;
                for (int a = 0; a < gameFieldSize; a++) {
                    sumRLb += aiRatingRL[a][3];
                    sumRLg += aiRatingRL[a][1];
                }
                break;
            }
        }
        //ищем максимальное значение в рейтинге, 1 -стройка, 2 -столбец, 777 - LR, 776 - RL.
        int maxRating = -1;
        boolean situation = false;
        for (int i = 0; i < gameFieldSize; i++) {
            //Col
            if (aiRatingC[i][3] == 0) {
                if (aiRatingC[i][1] >= maxRating) {
                    maxRating = aiRatingC[i][1];
                    whoIsWin[0] = aiRatingC[i][0];
                    whoIsWin[1] = 1;
                    whoIsWin[2] = aiRatingC[i][1];
                }
            } else if (aiRatingC[i][3] == gameFieldSize - 1 && aiRatingC[i][1] == 0) {
                situation = true;
                whoIsWin[0] = aiRatingC[i][0];
                whoIsWin[1] = 1;
                whoIsWin[2] = aiRatingC[i][1];
                whoIsWin[3] = aiRatingC[i][3];
                break;
            }
            //Row
            if (aiRatingR[i][3] == 0) {
                if (aiRatingR[i][1] >= maxRating) {
                    maxRating = aiRatingR[i][1];
                    whoIsWin[0] = aiRatingR[i][0];
                    whoIsWin[1] = 2;
                    whoIsWin[2] = aiRatingR[i][1];
                }
            } else if (aiRatingR[i][3] == gameFieldSize - 1 && aiRatingR[i][1] == 0) {
                situation = true;
                whoIsWin[0] = aiRatingR[i][0];
                whoIsWin[1] = 2;
                whoIsWin[2] = aiRatingR[i][1];
                whoIsWin[3] = aiRatingR[i][3];
                break;
            }
            //LR
            if (aiRatingLR[i][3] == 0 && checkLR) {
                if (aiRatingLR[i][1] >= maxRating) {
                    maxRating = aiRatingLR[i][1];
                    whoIsWin[0] = 777;
                    whoIsWin[1] = 777;
                    whoIsWin[2] = aiRatingLR[i][1];
                }
            } else if (sumLRb == gameFieldSize - 1 && sumLRg == 0) {
                situation = true;
                whoIsWin[0] = 777;
                whoIsWin[1] = 777;
                whoIsWin[2] = aiRatingLR[i][1];
                whoIsWin[3] = aiRatingLR[i][3];
                break;
            }
            //RL
            if (aiRatingRL[i][3] == 0 && checkRL) {
                if (aiRatingRL[i][1] >= maxRating) {
                    maxRating = aiRatingRL[i][1];
                    whoIsWin[0] = 776;
                    whoIsWin[1] = 776;
                    whoIsWin[2] = aiRatingRL[i][1];
                }
            } else if (sumRLb == gameFieldSize - 1 && sumRLg == 0) {
                situation = true;
                whoIsWin[0] = 776;
                whoIsWin[1] = 776;
                whoIsWin[2] = aiRatingRL[i][1];
                whoIsWin[3] = aiRatingRL[i][3];
                break;
            }
        }
        //Debug
        System.out.println(Arrays.deepToString(aiRatingC));
        System.out.println(Arrays.deepToString(aiRatingR));
        System.out.println(Arrays.deepToString(aiRatingLR));
        System.out.println(Arrays.deepToString(aiRatingRL));
        System.out.println("Check diagonal LR: " + checkLR);
        System.out.println("Check diagonal RL: " + checkRL);

        if (situation) {
            System.out.println("Опасность! Игрок может победить, необходим ход: " + Arrays.toString(whoIsWin));
        }
        return whoIsWin;
    }

    private static void aiTurn() {
        int[] makerating = makeRating();
        */
/*Debug *//*

        System.out.println("Я получил массив: " + Arrays.toString(makerating));
        int x = AI_TURN.nextInt(gameFieldSize);
        int y = AI_TURN.nextInt(gameFieldSize);
        if (makerating[1] == 1) {
            do {
                x = makerating[0];
                y = AI_TURN.nextInt(gameFieldSize);
            } while (!checkTurn(x, y));
            gameField[x][y] = AI_CHAR;
        } else if (makerating[1] == 2) {
            do {
                x = AI_TURN.nextInt(gameFieldSize);
                y = makerating[0];
            } while (!checkTurn(x, y));
            gameField[x][y] = AI_CHAR;
        } else if (makerating[1] == 777) {
            do {
                for (int i = 0; i < gameFieldSize; i++) {
                    if (gameField[i][i] == EMPTY_SIGN) {
                        x = i;
                        y = i;
                    }
                }
            } while (!checkTurn(x,
                    y));
            gameField[x][y] = AI_CHAR;
        } else if (makerating[1] == 776) {
            for (int i = 0; i < gameFieldSize; i++) {
                for (int z = 0; z < gameFieldSize; z++) {
                    int n = gameFieldSize - i - 1;
                    if (gameField[n][i] == EMPTY_SIGN && checkTurn(i, n)) {
                        gameField[i][n] = AI_CHAR;
                        return;
                    }
                }
            }
        } else if (makerating[1] == 0){
            for (int i = 0; i < gameFieldSize; i++) {
                for (int z = 0; z < gameFieldSize; z++) {
                    if (gameField[z][i] == EMPTY_SIGN) {
                        gameField[z][i] = AI_CHAR;
                        return;
                    }
                }
            }
        }
    }

*/

