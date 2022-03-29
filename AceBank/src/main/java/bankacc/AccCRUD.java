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
import static bankmain.DisplayOption.printLine;
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
    
    static String HeaderMain    = "\n" + printLine(16, "===");
    static String FooterMain    = printLine(16, "---") + "\n";
    
    static String HeaderRow     = "\n" + printLine(27, "===") +"\n"
            + "  ID\tAccNo\t\t  " 
            + "Balance  Int Rate  Min Bal  Acc Open Date  Acc Close Date \n"
            + printLine(27, "===");
    static String FooterRow = printLine(27, "---") +"\n";
    
    static String HeaderIDnAcc  = "\n" + printLine(6, "===") +"\n"
            + "  ID\tAccount No. \n"
            + printLine(6, "===");
    static String FooterIDnAcc  = printLine(6, "---") +"\n";
    
    /**
     * * createAcc(); * listById(); * updateAcc(); * deleteAccById();
     * * listAllAcc(); * caseExit();
     */
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
                    caseExit();
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
            var c = myObj.next();   // to removed the newline char in buffer
        }

        return null;
    }
    
    /** case 1
     **/
    private static void createAcc() {
        Pattern p = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{1}");
        
        System.out.print(" Account No (xxx-xxx-xxx-x): ");
        try {
            var accNo = myObj.next(p);
            var accOpenDate = LocalDate.now();
            
            // check if existing account available
            if (AccDAO.getList(accNo) == null) {
                var result = AccDAO.insertNewAcc(accNo, accOpenDate);
                if (result > 0) {
                    System.out.println(" Account created: ");
                    System.out.println(HeaderIDnAcc);
                    
                    BankAcc b = AccDAO.getList(accNo);
                    System.out.println(b.accNoToString());
                    
                    System.out.println(FooterIDnAcc);
                } else {
                    System.out.println(" Fail to create!");
                }
            } else {
                System.out.println(" Unable to create, "
                        + "there is existing account available!");
            }
        } catch (Exception e) {
            System.out.println(" Exception error message here ... " + e.getMessage());
            var c = myObj.next();
        }

    }
    
    /** case 2
     **/
    private static void listById() {
        BankAcc row = hasSuchID();
        if (row != null) {
            System.out.println(HeaderRow);

            System.out.println(row.toString());

            System.out.println(FooterRow);
        }

    }
    
    /** case 3
     **/
    private static void updateAcc() {
        LocalDate theDate;
        var dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        var x = -1.00;

        BankAcc row = hasSuchID();
        
        if (row != null)  {
            System.out.println(HeaderMain);
            
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

            System.out.println(FooterMain);
        }

    }
    
    /** case 4
     **/
    private static void deleteAccById() {
        BankAcc row = hasSuchID();
        try {
            if (row != null) {
                System.out.println(HeaderMain);

                var id = row.getId();
                System.out.println(" Deleting Account : " + row.getAccNo());
                System.out.print(" Are you sure [y/n][Y/N]:: ");
                var resp = myObj.next();
                if (resp.equalsIgnoreCase("y")) {
                    System.out.println(" Initiating delete for Account with ID : " +id );
                    var result = AccDAO.deleteAcc(row);
                    System.out.println( (result > 0) ? " Delete Success ": " Delete  Fail ");
                }

                System.out.println(FooterMain);
            }
        } catch (Exception e) {
            System.out.println(" Exception error message here ... " + e.getMessage());
            var c = myObj.next();
        }

    }

    /** case 5
     **/
    private static void listAllAcc() {
        try {
            System.out.println(HeaderIDnAcc);

            AccDAO.listAcc().forEach(p -> {
                System.out.println(p.accNoToString());
            });

            System.out.println(FooterIDnAcc);

        } catch (Exception e) {
            System.out.println(" Exception here ....  " + e.getMessage());
        }
    }
    
    /**
     * case 0
     */
    private static void caseExit() {
        System.out.println(" Exit\n");
        try {
            Thread.sleep(3600);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }
    
}