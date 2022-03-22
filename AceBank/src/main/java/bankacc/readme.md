AceBank/bankacc

*   BankAcc - pojo
    *   BankAcc(int id, String accNo, double balance, double intRate, 
                LocalDate accOpenDate, double minBal)
    *   BankAcc(int id, String accNo, double balance, double intRate, 
                LocalDate accOpenDate, LocalDate accClosedDate, double minBal)
*   AccDAO - DAO: 
    *   BankAcc bankAccSql(ResultSet rs)
    *   int insertNewAcc(String getAccNo, LocalDate getOpenDate) 
    *   BankAcc accRow(int id)
    *   List<BankAcc> listAcc() 
    *   BankAcc getList(String accNo)
    *   preTest()
*   AccCRUD - CRUD:
    *   main()
    *   boolean createAcc()
    *   int listAllAcc()
