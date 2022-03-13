/* 220312 2
 * BankAccDAO
 * 
 * The Data Access Object (DAO) pattern is a structural pattern that allows us 
 * to isolate the application/business layer from the persistence layer 
 * (usually a relational database but could be any other persistence mechanism) 
 * using an abstract API.
 */
package bankacc;

import acebank.SqlConnect;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antw
 */
public class BankAccDAO {
    public static List<BankAcc> listAcc() throws Exception {
        var qStmt = "Select * from aceBank.bankAc";
        
        var acList = new ArrayList<BankAcc>();
        var stmt = SqlConnect.init();
        var rs = stmt.executeQuery(qStmt);
        
        while (rs.next()) {
            acList.add(new BankAcc(
                    rs.getInt("id"), 
                    rs.getString("accNo"), 
                    rs.getDouble("balance"), 
                    rs.getDouble("intRate"), 
                    rs.getDate("accOpenDate").toLocalDate(), 
                    rs.getDate("accClosedDate").toLocalDate(),
                    rs.getDouble("minBal")
            ));
        }
        
        return acList;
    }

    /*Testing for above objects*/
    public static void main(String[] args) throws Exception {
        System.out.println("First Row: " + listAcc().get(0));
    }
    
}

/* SQL
INSERT INTO aceBank.bankAc (accNo, balance, intRate, accOpenDate,
 accClosedDate, minBal) VALUES ('123-456-789-0', 1000, 0.05000000, 
    '2022-03-01', '2022-03-11', 200);
*/