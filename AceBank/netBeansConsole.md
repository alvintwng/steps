### NetBeans 12.3 user input on console not working

ref: https://stackoverflow.com/questions/68133927/netbeans-12-3-user-input-on-console-not-working

Couple of possible solutions. One is to create your project using Ant instead of Maven, although 
that is only a workaround. A better approach is to amend the default settings of your Maven project 
in a couple of places:

  - First, select your Maven project, right click and select **Properties** from the displayed menu.
  - In the **Project Properties** window select the **Actions** entry from the **Categories** list, and then 
  select **Run project** from the **Actions** list.
  - The **Execute Goals** field will have the value `process-classes org.codehaus.mojo:exec-maven-plugin:3.0.0:exec`.
  Replace the final four characters, "`exec`", with "`java`".
  - In the **Set Properties** field append this line `exec.mainClass=${packageClassName}`.

![image](https://i.stack.imgur.com/u60Lk.png)

---
