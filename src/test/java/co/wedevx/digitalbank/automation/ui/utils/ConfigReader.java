package co.wedevx.digitalbank.automation.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//build a logic that reads the config file(properties file)
public class ConfigReader {
    private static Properties properties;
    //ultimate goals is that this properties object is initialized with input
    //values on digitalbank.properties file

    //In this class main method was changed to static initializer
    //static initializer helps to initialize values in the objects here
    //we don't want to create reusable method
    //we want code to run only once for the whole project

    //Instance initialize (if we would remove word static here)
    //they run for every object, every ConfigReader object
    //Because we won't be creating any object in this class,
    //we want it to be utils class, making it static

    //static initializer run the block only once for the whole project
    //instance initializers run the block once for every object creation from the class
    //When your coach says they want all to be initialized,
    //it means they want all variables or objects to be properly set up and assigned initial values before they are used.
    //This is important to avoid NullPointerExceptions or other runtime errors that can occur when trying to use uninitialized variables.
    static {
        //filePath -> the directory/location of our properties file
        //right click on properties file, copy path from content root
        String filePath = "src/test/resources/properties/digitalbank.properties";

        FileInputStream input = null;

        //FileInputStream this is a class that enables us to read files
        //in new FileInputStream constructor we pass filePath,
        //basically saying which file we wanna read
        try {
            //go read this file
            input = new FileInputStream(filePath); //-> throws checked exception
            //properties varibale will have Properties object loaded with everything in the input
            properties = new Properties(); //initialize properties
            //take everything we added and load into this properties file
            properties.load(input);//Load the properties from the file
        } catch (IOException e) {
            //FileNotFound is a child exception of IOException
            System.out.println("File not found");
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //passing the key
        System.out.println("my_name");
        //name value will be pulled from the digitalbank.properties file
        System.out.println("browser");
        System.out.println("environment");
    }

    public static String getPropertiesValues(String key){
        return properties.getProperty(key);
    } //instead of System.out.println we wrapped to the reusable method
}
