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
    
    public static int option() {
        System.out.println("\n" + 
            " Select an option from below\n" +
            "\t" + "(0) Exit \n");
        
        System.out.print(" Enter a numer to carry out the operation : ");
        
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
        System.out.println(" Press any character to continue ... ");
        myObj.next();
    }
    
    public static void preTest() {
        
        while (true) {
            var optionVal = option();
            
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
}
