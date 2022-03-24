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
public class DisplayOption {
    
    private static Scanner myObj = new Scanner(System.in);
    
    public static String bankMenu = (           
          "----------------------------------------------------\n" 
        + "     AceBank - Main Menu\n" 
        + "----------------------------------------------------\n" 
        + "  Select an option from below\n" 
        + "    [1] Create Account\n" 
        + "    [2] Account details by ID\n" 
        + "    [3] Update Account by ID\n" 
        + "    [4] Delete Account by ID\n" 
        + "    [5] List all Accounts\n" 
        + "    [0] Exit\n");

    public static float inputValueViaScanner() {
        float optVal;
        try {
            optVal = myObj.nextFloat();
        } catch (Exception e) {
            var c = myObj.next();
            optVal = -1;
        }
        return optVal;
    }
    
    public static int selectAnOption(String displayString) {
        System.out.println("\n" + displayString);
        System.out.print(" Enter a number to carry out the operation : ");

        return (int) inputValueViaScanner();
    }
    
    public static void toContinue() {
        System.out.print(" Press any character to continue ... ");
        myObj.next();
    }
    
    public static void preTest() {
        while (true) {
            var optionVal = selectAnOption(bankMenu);
            
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
    
//    public static void main(String[] args) {
//        preTest();
//    }
}
