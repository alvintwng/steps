/** 220320
 * AccCRUD
 * 
 * In computer programming, create, read, update, and delete (CRUD) are the 
 * four basic operations of persistent storage. CRUD is also sometimes used 
 * to describe user interface conventions that facilitate viewing, searching, 
 * and changing information using computer-based forms and reports.
 */
package bankacc;

import bankmain.DisplayOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 *
 * @author antw
 */
public class AccCRUD {
    
    private static Scanner myObj = new Scanner(System.in);
    
    public static void main() {
        
        while (true) {
            var optionVal = DisplayOption.selectAnOption(DisplayOption.bankMenu);
            
            switch (optionVal) {
                case 1:             // [1] Create Account
                    createAcc();
                    break;
                case 2:             // [2] Accounts details by ID
                    listById();
                    break;
                case 3:             // [3] Update Account by ID
                    updateAcc();
                    break;
                case 4:             // [4] Delete Account by ID
                    deleteAccById();
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
            
            DisplayOption.toContinue();
        }
    }
    
    private static float inputValue() {
        return DisplayOption.inputValueViaScanner();
    }
    
    private static BankAcc hasSuchID() {
        BankAcc row = null;
        System.out.print(" Enter the Account ID: ");
        try {
            var id = myObj.nextInt();
            row = AccDAO.accRow(id);
            if (row != null) {
                return row;
            } else {
                System.out.println( " No such ID!" );
                return null;
            }
        } catch (Exception ex) {
            System.out.println(" Exception ID error message here ... " + ex.getMessage());
            String c = myObj.next();   // ? to clear the myObj to next
        }

        return null;
    }
    
    /** case 1
     * @return */
    private static boolean createAcc() {
        Pattern p = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{1}");
        
        System.out.print(" Account No (xxx-xxx-xxx-x): ");
        try {
            var accNo = myObj.next(p);
            var accOpenDate = LocalDate.now();
            
            // check if existing account available
            if (AccDAO.getList(accNo) == null) {
                var result = AccDAO.insertNewAcc(accNo, accOpenDate);
                System.out.println((result > 0)
                        ? " Account created: " + accNo : " Fail to create");
            } else {
                System.out.println(" Unable to create, "
                        + "there is existing account available!");
            }
        } catch (Exception e) {
            System.out.println(" Exception error message here ... " + e.getMessage());
            var c = myObj.next();
            return false;
        }
        
        return true;
    }
    
    /** case 2
     * @return */
    private static boolean listById() {
        BankAcc row = hasSuchID();
        if (row != null) {
            System.out.println(row.toString());
            return true;
        }

        return false;
    }
    
    /** case 3
     * @return */
    private static int updateAcc() {
        LocalDate theDate;
        var dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        var x = -1.00;

        BankAcc row = hasSuchID();
        
        if (row != null)  {
            var id = row.getId();
            var intRate = String.format("%.3f", row.getIntRate());

            System.out.println(" Enter the new amount, or any letter to next line.");
            try {
                System.out.print(" Balance: " + row.getBalance() + "\tNew Balance: ");
                x = inputValue();
                if (x >= 0) {
                    row.setBalance(x);
                }

                System.out.print(" Minimun Bal: " + row.getMinBal() + "\tNew Minimum: ");
                x = inputValue();
                if (x >= 0) {
                    row.setMinBal(x);
                }

                System.out.print(" Int Rate: " + intRate + "\tNew Int Rate: ");
                x = inputValue();
                if (x >= 0) {
                    row.setIntRate(x);
                }

                System.out.print(" Open Date: " + row.getAccOpenDate() + "\tNew Date (YYYY-MM-DD) :");
                try {
                    theDate = LocalDate.parse(String.format(myObj.next(), dtf));
                    row.setAccOpenDate(theDate);
                } catch (Exception e) {
                    System.out.println(" Unable to change the date. " + e.getMessage());
                }

                System.out.print(" Are you sure with the update [y/n][Y/N]:: ");
                var resp = myObj.next();
                if (resp.equalsIgnoreCase("y")) {
                    System.out.println(" Initiating update for Account with ID : " + id);
                    var result = AccDAO.updateAcc(row);
                    System.out.println((result > 0) ? " Update Success " : " Update  Fail ");
                }
            } catch (Exception e) {
                System.out.println(" Exception... " + e.getMessage());
                var c = myObj.next();
            }
        }

        return 1;
    }
    
    /** case 4
     * @return */
    private static boolean deleteAccById() {
        BankAcc row = hasSuchID();
        try {
            if (row != null) {
                var id = row.getId();
                System.out.print(" Are you sure [y/n][Y/N]:: ");
                var resp = myObj.next();
                if (resp.equalsIgnoreCase("y")) {
                    System.out.println(" Initiating delete for Account with ID : " +id );
                    var result = AccDAO.deleteAcc(row);
                    System.out.println( (result > 0) ? " Delete Success ": " Delete  Fail ");
                }
            }
        } catch (Exception e) {
            System.out.println(" Exception error message here ... " + e.getMessage());
            var c = myObj.next();
        }

        return true;
    }

    /** case 5
     * @return  */
    private static int listAllAcc() {
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