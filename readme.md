It is a simple project to demonstrate how to add extent reports
!!! Please open this readme.md in editor to see code snippets that you need!!!

- Create a project
- In pom.xml add dependencies for TestNG and Extentreports

<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.1</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
</dependency>



- Create testng.xml file to point your tests
- Add in POM.xml the following code to be able to run tests through command line 

<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>


- In src/test/java create a package extentreports 
- In the package src/test/java/extentreports create a class ExtentManager 

- In src/test/java create a package testlisteners
- In the package src/test/java/testlisteners create a class TestListener that i
mplements implements ITestListener 
- In testng.xml add

  <listeners>
  <listener class-name ="testlisteners.TestListener"></listener>
  </listeners>


Documentation
https://www.extentreports.com/
