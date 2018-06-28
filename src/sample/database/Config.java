package sample.database;

import java.io.*;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "src/sample/settings.cfg";

    public static String DB_HOST;
    public static int DB_PORT;
    public static String DB_NAME;
    public static String DB_USER;
    public static String DB_USER_PASSWORD;
    public static String DB_ROOT;
    public static String DB_ROOT_PASSWORD;


    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream(CONFIG_FILE);
            properties.load(propertiesFile);

            //properties.load(getClass().getResourceAsStream(CONFIG_FILE));

            DB_HOST = properties.getProperty("DB_HOST");
            DB_PORT = Integer.parseInt(properties.getProperty("DB_PORT"));
            DB_NAME = properties.getProperty("DB_NAME");
            DB_USER = properties.getProperty("DB_USER");
            DB_USER_PASSWORD = properties.getProperty("DB_USER_PASSWORD");
            DB_ROOT = properties.getProperty("DB_ROOT");
            DB_ROOT_PASSWORD = properties.getProperty("DB_ROOT_PASSWORD");
        } catch (FileNotFoundException ex) {
            System.err.println("Properties config file not found");
        } catch (IOException ex) {
            System.err.println("Error while reading file");
        } finally {
            try {
                propertiesFile.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void saveProperties() {
        try {
            Properties properties = new Properties();
            properties.setProperty("DB_HOST", "localhost");
            properties.setProperty("DB_PORT", "3306");
            properties.setProperty("DB_NAME", "");
            properties.setProperty("DB_USER", "");
            properties.setProperty("DB_USER_PASSWORD", "");
            properties.setProperty("DB_ROOT", "");
            properties.setProperty("DB_ROOT_PASSWORD", "");
            OutputStream propertiesFile = new FileOutputStream(CONFIG_FILE);
            properties.store(propertiesFile, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
