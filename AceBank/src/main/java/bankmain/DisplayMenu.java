/** 330319
 * DisplayMenu
 * To display menu on console, input selected option.
 * 
 * For console input alignment in NetBeans, check on netBeansConsole.md
 */
package bankmain;

import java.util.Scanner;

/**
 *
 * @author antw
 */
public class DisplayMenu {
    
    public static Scanner myObj = new Scanner(System.in);
    
    public static String bankMenu = ("""               
        ----------------------------------------------------
                                Main Menu
        ----------------------------------------------------
          Select an option from below
            [1] Create Account
            [5] List all Accounts No.
            [0] Exit
        """);
    
    public static int option(String displayString) {
        
        System.out.println("\n" + displayString);
        
        System.out.print(" Enter a number to carry out the operation : ");
        
        int optVal;
        try{
            optVal = myObj.nextInt();
        } catch (Exception e) {
            var c = myObj.next();   // ? to clear the myObj to next
            optVal = -1;
        }
        
        return optVal;
    }
    
    public static void toContinue() {
        System.out.print(" Press any character to continue ... ");
        myObj.next();
    }
    
    public static void preTest() {
        
        while (true) {
            var optionVal = option(bankMenu);
            
            switch (optionVal) {
                case 0:
                    System.out.println(" Exit");
                    System.exit(0);
                default:
                    System.out.println(" Invalid Option");
                    break;
            }
            
            toContinue();
        }
    }
    
    public static void main(String[] args) {
        preTest();
    }
}
