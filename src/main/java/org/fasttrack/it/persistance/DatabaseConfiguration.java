package org.fasttrack.it.persistance;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfiguration {

    public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        Properties properties = new Properties();

        InputStream inputStream = DatabaseConfiguration.class.getClassLoader().getResourceAsStream("db.properties");
        // closing resource in finally block just to make it visible
        try {
                properties.load(inputStream);

            // LOADING THE MYSQL DRIVER SO THAT IT GETS REGISTERED WITH THE DRIVER MANAGER
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
           return DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));


        } finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
    }
}
