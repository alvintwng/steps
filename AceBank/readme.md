AceBank

*   bankmain - Main
*   bankacc

console after Run
``` console
antw@Mac-mini AceBank % pwd
/Users/antw/steps/AceBank
antw@Mac-mini AceBank % java -jar target/AceBank-1.0-SNAPSHOT.jar
```
``` console

----------------------------------------------------
     AceBank - Main Menu
----------------------------------------------------
  Select an option from below
    [1] Create Account
    [2] Account details by ID
    [3] Update Account by ID
    [4] Delete Account by ID
    [5] List all Accounts
    [0] Exit

 Enter a number to carry out the operation : 3
 Enter the Account ID: 1

 ===================================================
 Enter the new amount, or any letter to next line.
 Balance: 1000.0	New Balance: 2000
 Minimun Bal: 200.0	New Minimum: n
 Int Rate: 0.050	New Int Rate: n
 Open Date: 1987-06-05	New Date (YYYY-MM-DD) :2022-03-24
 Are you sure with the update [y/n][Y/N]:: y
 Initiating update for Account with ID : 1
 Update Success 
 ---------------------------------------------------

 Press any character to continue ... 
```
``` console
...
 Enter a number to carry out the operation : 1
 Account No (xxx-xxx-xxx-x): 123-456-789-1
 Account created: 

 =====================
  ID	AccNo
 =====================
  49	123-456-789-1
 ---------------------

 Press any character to continue ... 
```
``` console
...
 Enter a number to carry out the operation : 2
 Enter the Account ID: 49

 ====================================================================================
  ID	AccNo		  Balance  Int Rate  Min Bal  Acc Open Date  Acc Close Date 
 ====================================================================================
  49	123-456-789-1     1000.00    0.050   200.00   2022-03-28     null
 ------------------------------------------------------------------------------------

 Press any character to continue ... 
```
``` console
...
 Enter a number to carry out the operation : 4
 Enter the Account ID: 49

 ===================================================
 Are you sure [y/n][Y/N]:: y
 Initiating delete for Account with ID : 49
 Delete Success 
 ---------------------------------------------------

 Press any character to continue ... 
```