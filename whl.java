import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class whl {
    //global variables
    public Scanner input = new Scanner(System.in);
    public int select;
    public ArrayList<String> items = new ArrayList<String>();
    public float coffTotal= 0, dessTotal=0, sum=0;
    private Formatter file;

    //to shorten the system.out.println systax to print only
    public void print(Object p) {System.out.println(p.toString());}

    //prototype function of the main menu to call upon other prototype function
    public void MainMenu() {
        print("Welcome to Guoba's coffee shop!");
        print("-----------------------------------\n");
        print("1. coffee");
        print("2. dessert");
        print("3. receipt");
        print("4. clear transaction");
        print("5. exit");
        print("Select menu: ");
        //to assign the selection variable to user input shown above
        select = input.nextInt();
        switch (select) {
            case 1:
                //to call upon the coffee menu function
                CoffeeMenu();
                break;
            case 2:
                //to call upon the dessert menu function
                DessertMenu();
                break;
            case 3:
                //to obtain receipt by through the functions
                print("Get receipt.");
                createFile();
                receipt();
                closeFile();
                break;
            case 4:
                //to clear the entire elements within the arraylist
                Clear();
                break;
            case 5:
                //exit the entire program
                System.exit(0);
            default:
                //a message for invalid input outside of switch case
                print("Invalid input.");
                break;
        }
    }

    public void CoffeeMenu() {
        print("Coffee Menu");
        print("-------------------\n");
        print("1. espresso - RM9.00");
        print("2. latte - RM13.00");
        print("3. mocha - RM15.00");
        print("4. back");
        print("Please select: ");
        //while loop to allow the continuation of menu selection
        while(true) {
            select = input.nextInt();
            switch (select) {
                case 1:
                    //add price into arraylist 
                    coffTotal += 9.00; 
                    //adding the order into a file 
                    items.add("espresso - RM9.00");
                    //to add both coffee and desert price
                    Calculation();
                    break;
                case 2:
                    coffTotal += 13.00;
                    items.add("latte - RM13.00");
                    Calculation();
                    break;
                case 3:
                    coffTotal += 15.00;
                    items.add("mocha - RM15.00");
                    Calculation();
                    break;
                case 4:
                    //return to main menu
                    MainMenu();
                    break;
                default:
                    //a message for invalid input outside of switch case
                    print("Invalid input. Please select items in the menu.");
            }
        } 
    }

    public void DessertMenu() {
        print("Dessert Menu");
        print("-----------------\n");
        print("1. Japanese cheese cake - RM7.00");
        print("2. Red velvet - RM11.00");
        print("3. Chocolate cake - RM13.00");
        print("4. back");
        print("Please select: ");
        //while loop to allow the continuation of menu selection
        while(true) {
            select = input.nextInt();
            switch (select) {
                case 1:
                    //add price into arraylist 
                    dessTotal += 7.00; 
                    //adding the order into a file
                    items.add("Japanese cheese cake - RM7.00");
                    //to add both coffee and desert price
                    Calculation();
                    break;
                case 2:
                    dessTotal += 11.00;
                    items.add("Red velvet - RM11.00");
                    Calculation();
                    break;
                case 3:
                    dessTotal += 13.00;
                    items.add("Chocolate cake - RM13.00");
                    Calculation();
                    break;
                case 4:
                    //return to main menu
                    MainMenu();
                    break;
                default:
                    //a message for invalid input outside of switch case
                    print("Invalid input. Please select items in the menu.");
            }
        } 
    }

    public void Clear() {
        //to clear the entire element within the arraylist
        items.clear();
        print("Transaction clear successfully.");
    }

    
    public void Calculation() {
        //add up both the coffee and dessert price from arraylist
        sum = coffTotal + dessTotal;
    }

    public void createFile() {
        //create a new file within a specific folder 
        try {
            file = new Formatter("E:\\software engineering\\sem 4\\DIT 4223 java\\menu.txt");
            print("File has created successfully.");
        }

        //an error message if create file is unsuccessful
        catch(Exception e) {
            print("Error");
            e.printStackTrace();
        }
    }

    public void receipt() {
        //write arraylist elements into the created text file
        file.format("Here is your receipt for your oder: \n");
        file.format("\n---------------------------------------- \n");
        //for loop to display every element within the arraylist
        for (String i : items) {
            file.format(i + "\n");
        }
        file.format("\n----------------------------------------\n");

        //write the grand total of the entire purchase within the text file
        file.format("Grand total = " + "RM" + sum);
    }

    public void closeFile() {
        //closing the file 
        file.close();
    }
    
    public static void main(String[] args) {
        //to call upon the main menu function
        whl call = new whl();
        call.MainMenu();
    }  

}
