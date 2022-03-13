/* 220312 1
 * BankAcc
 *
 * Plain Old Java Object (POJO) is an ordinary Java object, not bound by any 
 * special restriction other than those forced by the Java Language 
 * Specification and not requiring any classpath.
 * 
 * create basic POJO, construtor, toString with properties: 
 *   accNo, balance, intRate, accOpenDate, accClosedDate, minBal. 
 */
package bankacc;

import java.time.LocalDate;

/**
 *
 * @author antw
 */
public class BankAcc {
    
    private int id;
    private String accNo;
    private double balance;
    private double intRate;
    private LocalDate accOpenDate;
    private LocalDate accClosedDate;
    private double minBal;
    
    public BankAcc(int id, String accNo, double balance, double intRate, 
            LocalDate accOpenDate, LocalDate accClosedDate, double minBal) {
        this.id = id;
        this.accNo = accNo;
        this.balance = balance;
        this.intRate = intRate;
        this.accOpenDate = accOpenDate;
        this.accClosedDate = accClosedDate;
        this.minBal = minBal;
    }
    
    @Override
    public String toString() {
        
        String s = String.format("%.3f", intRate);
        
        return  id + "\t" + 
                accNo + "\t" + 
                balance + "\t\t" + 
                s + "\t" + 
                accOpenDate + "\t" + 
                accClosedDate + "\t" + 
                minBal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }

    public LocalDate getAccOpenDate() {
        return accOpenDate;
    }

    public void setAccOpenDate(LocalDate accOpenDate) {
        this.accOpenDate = accOpenDate;
    }

    public LocalDate getAccClosedDate() {
        return accClosedDate;
    }

    public void setAccClosedDate(LocalDate accClosedDate) {
        this.accClosedDate = accClosedDate;
    }

    public double getMinBal() {
        return minBal;
    }

    public void setMinBal(double minBal) {
        this.minBal = minBal;
    }
}

/*
CREATE DATABASE  IF NOT EXISTS aceBank; 
USE aceBank;
DROP TABLE IF EXISTS bankAc;
CREATE TABLE bankAc (
  id int NOT NULL AUTO_INCREMENT,
  accNo varchar(45) NOT NULL,
  balance double DEFAULT 1000,
  intRate double DEFAULT 0.05,
  accOpenDate date DEFAULT NULL,
  accClosedDate date DEFAULT NULL,
  minBal double DEFAULT 200,
  PRIMARY KEY (id)
) 
*/