/** 220312 2
 * BankAccDAO
 * 
 * The Data Access Object (DAO) pattern is a structural pattern that allows us 
 * to isolate the application/business layer from the persistence layer 
 * (usually a relational database but could be any other persistence mechanism) 
 * using an abstract API.
 * 
 * BankAcc bankAccSql(ResultSet rs) - object for listAcc, accRow, getList
 * List<BankAcc> listAcc()          - List all accounts detail
 * BankAcc accRow(id)               - get single row
 * BankAcc getList(accNo)           - List data by Account No.
 * preTest()
 */
package bankacc;

import acebank.SqlConnect;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antw
 */
public class BankAccDAO {
    
    /* object for  listAcc, accRow(id), getList(accNo) */
    public static BankAcc bankAccSql(ResultSet rs) throws Exception {
        
        var accInfo = (new BankAcc(
                rs.getInt("id"),
                rs.getString("accNo"),
                rs.getDouble("balance"),
                rs.getDouble("intRate"),
                rs.getDate("accOpenDate").toLocalDate(),
                rs.getDate("accClosedDate").toLocalDate(),
                rs.getDouble("minBal")
        ));

       return accInfo;
    }
    
    
    /* List all accounts detail */
    public static List<BankAcc> listAcc() throws Exception {
        
        var qStmt = "Select * from aceBank.bankAc";
        var stmt = SqlConnect.init();
        var rs = stmt.executeQuery(qStmt);
        
        var acList = new ArrayList<BankAcc>();
        while (rs.next()) {
            acList.add(bankAccSql(rs));     // bankAcc object, bankAccSql(rs)
        }
        
        return acList;
    }
    
    /* get single row from id */
    public static BankAcc accRow(int id) throws Exception{
        
        var qStmt = "Select * from aceBank.bankAc where id = " + id + ";";
        var stmt = SqlConnect.init();
        var rs = stmt.executeQuery(qStmt);
        
        BankAcc accInfo = null;
        while (rs.next()) {
            accInfo = bankAccSql(rs);       // bankAcc object, bankAccSql(rs)
        }
        
        return accInfo;
    }
    
    /* List data by Account No. */
    public static BankAcc getList(String accNo) throws Exception {
       
       var qStmt = "Select * from aceBank.bankAc where accNo = ?";
       var conn = SqlConnect.initConn();
       var pStmt = conn.prepareStatement(qStmt);
       pStmt.setString(1, accNo);
       var rs= pStmt.executeQuery();
       
       BankAcc accInfo = null;
       while (rs.next()) {
           accInfo = bankAccSql(rs);        // bankAcc object, bankAccSql(rs)
       }
       
       return accInfo;
    }
    
    
    /*Testing for above objects*/
    public  static void preTest() {
        try {
            
            var accNo = "123-456-789-0";
            System.out.println("\n" + "AceBank BankAccDAO preTest:" +"\n"+ 
                    "getList(String) \n" + getList(accNo) +"\n"+
                    "accRow(id) \n" + accRow(1) +"\n"+
                    "listAcc: \n" // +"\n"+ listAcc().get(0)
            );
            listAcc().stream().forEach(System.out::println);
            
        } catch (Exception e) {
            System.out.println(" Exception here ....  " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        preTest();
    }
    
}

/* SQL
INSERT INTO aceBank.bankAc (accNo, balance, intRate, accOpenDate,
 accClosedDate, minBal) VALUES ('123-456-789-0', 1000, 0.05000000, 
    '2022-03-01', '2022-03-11', 200);
*/