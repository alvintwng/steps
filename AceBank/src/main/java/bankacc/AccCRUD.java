/** 220320
 * AccCRUD
 * 
 * In computer programming, create, read, update, and delete (CRUD) are the 
 * four basic operations of persistent storage. CRUD is also sometimes used 
 * to describe user interface conventions that facilitate viewing, searching, 
 * and changing information using computer-based forms and reports.
 */
package bankacc;

import bankmain.DisplayMenu;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class AccCRUD {
    
    public static Scanner myObj = new Scanner(System.in);
    
    public static void main() {
        
        while (true) {
            var optionVal = DisplayMenu.option(DisplayMenu.bankMenu);
            
            switch (optionVal) {
                case 1:             // [1] Create Account
                    createAcc();
                    break;
                case 5:             //[5] List all Accounts
                    listAllAcc();
                    break;
                case 0:
                    System.out.println(" Exit");
                    System.exit(0);
                default:
                    System.out.println(" Invalid Option");
                    break;
            }
            
            DisplayMenu.toContinue();
        }
    }
    
    /** case 1
     * @return */
    public static boolean createAcc() {
        System.out.print(" Account No (xxx-xxx-xxx-x): ");
        var accOpenDate = LocalDate.now();
        
        try {
            var accNo = myObj.next();
            var result = AccDAO.insertNewAcc(accNo, accOpenDate);
            System.out.println((result > 0)
                        ? " Account created: " + accNo : " Fail to create");
        } catch (Exception e) {
            System.out.println(" Exception error message here ... " + e.getMessage());
            var c = myObj.next();
        }
        
        return true;
    }
    
    
    
    /** case 5
     * @return  */
    public static int listAllAcc() {
        try {
            AccDAO.listAcc().forEach(p -> {
                System.out.println(p.getId() +  "\t" + p.getAccNo());
            });
        } catch (Exception e) {
            System.out.println(" Exception here ....  " + e.getMessage());
        }
        return 1;
    }
}
/*            
[1] Create Account
[2] Accounts details by ID
[3] Update Account by ID
[4] Delete Account by ID
[5] List all Accounts */