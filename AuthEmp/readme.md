## Creat database from Oracle 12c
Prior to next page, ver01, this application require ready database connection, `stepsauth` in Oracle Developer.

The following shown example of creating new database connection, `dataone`.
### Tools
- Mac OS
- Oracle DB Developer VM
- Spring Tool Suite 4
- java 11.0.8 2020-07-14 LTS
- Java 8
- Oracle JDBC driver ojdbc7.jar

ref: [ntucLH/mCCapStoneProj4/software.md](https://github.com/alvintwng/ntucLH/blob/master/mCCapStoneProj4/software.md)

### Console, Gnome Terminal 3.28.2
``` console
[oracle@localhost ~]$ sqlplus sys/oracle as sysdba

SQL*Plus: Release 19.0.0.0.0 - Production on Sun May 16 22:17:01 2021
Version 19.3.0.0.0

Copyright (c) 1982, 2019, Oracle.  All rights reserved.


Connected to:
Oracle Database 19c Enterprise Edition Release 19.0.0.0.0 - Production
Version 19.3.0.0.0

SQL> create user dataone   
  2  identified by dataone
  3  default tablespace users
  4  temporary tablespace temp
  5  quota unlimited on users
  6  password expire;

User created.

SQL> grant connect, resource to dataone;

Grant succeeded.

SQL> grant create view to dataone;

Grant succeeded.

SQL> conn dataone/dataone
ERROR:
ORA-28001: the password has expired


Changing password for dataone
New password: 
Retype new password: 
Password changed
Connected.
SQL> show user
USER is "DATAONE"
SQL> exit
Disconnected from Oracle Database 19c Enterprise Edition Release 19.0.0.0.0 - Production
Version 19.3.0.0.0
[oracle@localhost ~]$ 

```

### Oracle SQl Developer Version 19.1.0.094
- New Database Connection
  - Name: dataone
  - Username: datapne
  - Password: dataone
  - select on Service name: orcl
  - save
  - test > Status - success
- do a refresh on Oracle SQL Developer


210517AuthEmpV00.png <img src="https://github.com/alvintwng/steps/blob/main/AuthEmp/img/210517AuthEmpV00.png">

---
