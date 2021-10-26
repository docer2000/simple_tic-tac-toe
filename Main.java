package tests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String a = "         ";

        char[][] array = new char[3][3];
        char[][] array2 = new char[3][3];

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = (char) a.charAt(k);
                k++;
            }
        }

        System.out.println("---------");
        System.out.println("| " + a.charAt(0) + " " + a.charAt(1) + " " + a.charAt(2) + " |");
        System.out.println("| " + a.charAt(3) + " " + a.charAt(4) + " " + a.charAt(5) + " |");
        System.out.println("| " + a.charAt(6) + " " + a.charAt(7) + " " + a.charAt(8) + " |");
        System.out.println("---------");

        System.out.println("Enter the coordinates:");

        int sumX = 0; int sumO = 0; boolean sumEl = false;

        boolean test = true;
        boolean checkwin = false;
        boolean checkplay = false;



        while (sumEl == false)
        {


            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                checkplay = true;
                System.out.println("Enter the coordinates:");
                scanner.nextLine();



            } else {
                try {



                    String ord = scanner.nextLine();
                    String[] arr = ord.split(" ");

                    int b = Integer.parseInt(arr[0]);
                    int d = Integer.parseInt(arr[1]);


                    try {

                        if (b < 0 || b > 3) {
                            System.out.println("Coordinates should be from 1 to 3!");

                            System.out.println("Enter the coordinates:");
                        }
                        if (d < 0 || d > 3) {
                            System.out.println("Coordinates should be from 1 to 3!");

                            System.out.println("Enter the coordinates:");
                        } else if (array[b - 1][d - 1] == (char) 88 || array[b - 1][d - 1] == (char) 79) {
                            System.out.println("This cell is occupied! Choose another one!");

                            System.out.println("Enter the coordinates:");
                        } else {

                            if (checkplay == false) {
                                array[b - 1][d - 1] = (char) 88;
                                checkplay = true;
                            } else if (checkplay == true){

                                array[b - 1][d - 1] = (char) 79;
                                checkplay = false;
                            }

                            System.out.println("---------");  //начало вывода новой сетки
                            for (int i = 0; i < 3; i++) {
                                System.out.print("| ");
                                for (int j = 0; j < 3; j++) {
                                    System.out.print(array[i][j] + " ");

                                }
                                System.out.println("|");
                            }
                            System.out.println("---------");



                            int win1x = 0; int win2o = 0;

                            for (int i = 0; i < 3; i++) {
                                if (array[i][0] + array[i][1] + array[i][2] == 264 && win2o < 1) {
                                    win1x++;

                                } else if (array[i][0] + array[i][1] + array[i][2] == 237 && win1x < 1) {
                                    win2o++;
                                }
                            }


                            for (int i = 0; i < 3; i++) {
                                if (array[0][i] + array[1][i] + array[2][i] == 264) {

                                    win1x++;
                                }
                            }

                            for (int i = 0; i < 3; i++) {

                                if (array[0][i] + array[1][i] + array[2][i] == 237) {

                                    win2o++;
                                }
                            }
                            if (win1x != win2o && win1x == 1) {
                                System.out.println("X wins");
                                checkwin = true;
                                System.exit(0);

                            } else if (win2o != win1x && win2o == 1) {
                                System.out.println("O wins");
                                checkwin = true;
                                System.exit(0);
                            }



                            if (array[0][0] + array[1][1] + array[2][2] == 264) {
                                System.out.println("X wins");
                                checkwin = true;
                                System.exit(0);

                                win1x++;
                            } else if (array[0][2] + array[1][1] + array[2][0] == 264) {
                                System.out.println("X wins");
                                checkwin = true;
                                System.exit(0);

                                win1x++;
                            } else if (array[0][0] + array[1][1] + array[2][2] == 237) {
                                System.out.println("O wins");
                                checkwin = true;
                                System.exit(0);

                                win2o++;
                            } else if (array[0][2] + array[1][1] + array[2][0] == 237) {
                                System.out.println("O wins");
                                checkwin = true;
                                System.exit(0);

                                win2o++;
                            } else if (win1x != 1 && win1x > 3 && win2o !=1 && win2o > 3 && sumEl == true) {
                                System.out.println("Draw");
                                System.exit(0);

                            }






                            if (checkwin == false)
                                System.out.println("Enter the coordinates:");//конец вывода новой сетки


                            test = false;

                            for (int i = 0; i < array.length; i++) {
                                for (int j = 0; j < array[i].length; j++) {
                                    if (array[i][j] == 88) {
                                        sumX = sumX + 1;
                                    }
                                    if (array[i][j] == 79) {
                                        sumO = sumO + 1;
                                    }

                                }
                            }
                        } }
                    catch (ArrayIndexOutOfBoundsException e) {

                    }











                }
                catch (NumberFormatException e)
                {
                    System.out.println("You should enter numbers!");
                }
            }

        }


    }
}
