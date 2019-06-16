Devoted Health StdInput Application

To make this application work with spring boot and give us a STDIN though the terminal, 
I needed to disable the web environment.
These configurations can be found in 'application.properties'

When the jar is run you will see the application go through boot configurations.
I set it up to enter into a command prompt after spring boot has finished starting.
The configurations to make this happen are in the Application.class

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




