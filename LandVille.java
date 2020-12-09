import java.util.Scanner;

public class LandVille {
    private int[][] land;
    public boolean hasHouse;

    public LandVille(int maxRows, int maxColumns) {
        this.land = new int[maxRows][maxColumns];
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {
                this.land[i][j] = 0;
            }
        }
        this.hasHouse = false;

    }


    // Displaying the land grid
    public void displayLand() {
        for (int i = 0; i < this.land.length; i++) {
            for (int j = 0; j < this.land[i].length; j++) {
                System.out.print(this.land[i][j] + " ");
            }

            System.out.println();
        }
    }


    // Clearing out the land where each cell is set to character '0'.
    public void clearLand() {
        for (int i = 0; i < this.land.length; i++) {
            for (int j = 0; j < this.land[i].length; j++) {
                this.land[i][j] = 0;
            }
        }

        this.hasHouse = false;
    }


    /* Building the house where each cell is set to character '8'. When completed, the boolean hasHouse is
     *  true so another house cannot be built on top of it as set in main file.
     */
    public void buildHouse(int rows, int columns) {

        for (int i = 0; i < (rows + 2); i++) {
            for (int j = 0; j < (columns + 2); j++) {
                this.land[i][j] = 1;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.land[i + 1][j + 1] = 8;
            }
        }
        this.hasHouse = true;

    }
    
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int land_row = 0, land_col = 0;
        int house_row = 0, house_col = 0;
        
        /*
         * TASK D: Player input has to be greater than 0 and less than or equal to 10.
         * As addition, if player inputs a value other than an integer, it prints an error and asks for another input.
         */
        //Takes input for row.
        do {
        	System.out.println("Enter row number of the land: ");
            while (!keyboard.hasNextInt()) {
                System.out.println("Please only enter integer values");
                keyboard.next();
            }
            land_row = keyboard.nextInt();
            if (land_row > 0 && land_row <= 10);
            else
                System.out.println("Row should be greater than 0 an less than or equal to 10");
            } while (land_row <= 0 || land_row > 10);

        //Takes input for column.
        do {
            System.out.println("Enter column number of the land: ");
            while (!keyboard.hasNextInt()) {
                System.out.println("Please only enter integer values");
                keyboard.next();
            }
            land_col = keyboard.nextInt();
            if (land_col > 0 && land_col <= 10);
            else
                System.out.println("Column should be greater than 0 and less or equal to 10");
            } while (land_col <= 0 || land_col > 10);

        LandVille landVille = new LandVille(land_row, land_col);

        int option;

        //TASK E: Taking integer as input for menu options. The same additional statement for non integer values are inserted.
        while (true) {
            String menu[] = {
                "\n Please select an option",
                "\n (1) Build a house",
                "\n (2) Display land",
                "\n (3) Clear the land",
                "\n (4) Quit"
            };

            //Do while loop is used to execute statements for each menu option.
            do {
                for (int i = 0; i < menu.length; i++)
                    System.out.println(menu[i]);
                while (!keyboard.hasNextInt()) {
                    System.out.println("Please only enter integer values");
                    keyboard.next();
                }

                option = keyboard.nextInt();
                if (option == 1 && landVille.hasHouse == false) {

                	//Option 1 has two do while loops so if user enters a wrong input, it does not continue but loops back.
                    do {
                        System.out.println("Enter row of the house:");
                        while (!keyboard.hasNextInt()) {
                            System.out.println("Please only enter integer values");
                            keyboard.next();
                        }

                        house_row = keyboard.nextInt();
                        if (house_row > 0 && house_row <= (land_row + -2));
                        else

                            System.out.println("Invalid input. Row of house needs to be less than or equal to " + (land_row + -2));

                    } while (house_row < 0 || house_row > (land_row + -2));

                    do {
                        System.out.println("Enter column of the house:");
                        while (!keyboard.hasNextInt()) {
                            System.out.println("Please only enter integer values");
                            keyboard.next();
                        }

                        house_col = keyboard.nextInt();
                        if (house_col > 0 && house_col <= (land_col + -2));
                        else

                            System.out.println("Invalid input. Row of house needs to be less than or equal to " + (land_col + -2));
                    } while (house_col < 0 || house_col > (land_col + -2));

                    landVille.buildHouse(house_row, house_col);

                    //Still option 1, but if the house has already been built, it executes the following:
                } else if (option == 1 && landVille.hasHouse == true) {
                    System.out.println("House already exists! Press 3 to clear land.");

                } else if (option == 2) {
                    landVille.displayLand();

                } else if (option == 3) {
                    landVille.clearLand();

                } else if (option == 4) {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }

            } while (option < 0 || option > 4);

        }

    }

}

/* Reflection and lessons learnt: 
 * Coding takes patience with plenty of trial and errors. Without any prior background in coding, 
 * I found it hard to understand control flow statements and how it operates. Java syntax was  
 * confusing and frustrating but gradually got accustomed to it. There were a lot of searching up on Google for 
 * particular problems and statements that I have not come across.
 * 
 *It is very important to plan ahead before starting to code, as I found myself getting lost a number of times
 *during the process. 
 */
