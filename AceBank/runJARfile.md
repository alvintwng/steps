### To run jar file on command line

``` console
antw@Mac-mini AceBank % pwd
/Users/antw/steps/AceBank
antw@Mac-mini AceBank % java -jar target/AceBank-1.0-SNAPSHOT.jar
```

prior to this, pom.xml need to add plug-in
``` xml
<build>
     <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <!--add you main class-->
                            <mainClass>bankmain.Main</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <executions>
                    <execution>
                        <id>copy</id>
                        <phase>install</phase>
                        <goals>
                            <goal>copy-dependencies</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>
                                ${project.build.directory}
                            </outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
       <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.3</version>
         <configuration>
           <compilerArgs>
             <arg>--enable-preview</arg>
           </compilerArgs>
         </configuration>
       </plugin>
     </plugins>
</build>
```
Reference from stackoverflow: 
- https://stackoverflow.com/questions/55272267/cant-run-jar-file-on-command-line-with-maven

Reference of version from maven.apache.prg: 
- https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-resources-plugin/

