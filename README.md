Devoted Health StdInput Application

To make this application work with spring boot and give us a STDIN though the terminal, 
I needed to disable the web environment.
These configurations can be found in 'application.properties'

When the jar is run you will see the application go through boot configurations.
I set it up to enter into a command prompt after spring boot has finished starting.
The configurations to make this happen are in the Application.class

Sadly I did not have enough time to add create the Transaction Logic. I spent quite a bit
of time configuring Spring and H2 to work without a web environment. Also I did not figure out
how to activate H2 while testing. I have test classes but they return a NullPointerException 
when trying to persist to H2.


to build the application:

 $ ./gradlew clean
 
 $ ./gradlew bootJar


to run the application:

 $ java -jar build/libs/devoted-health-*.jar
 
    This will give you a command prompt though the terminal

  runner commands:

    SET[name][value]
    
    GET[name]
    
    DELETE[name]
    
    COUNT[name]
    
    BEGIN
    
    ROLLBACK
    
    END
    
    COMMIT




