package org.fasttrack.it.persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ToDoItemRepository {

    public void createToDoItem(String description, LocalDate deadline) throws SQLException, IOException, ClassNotFoundException {

        String insertSql = "INSERT INTO to_do_item (description, deadline) Values (?, ?)";
    //try with resources
        try (Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql))
        { preparedStatement.setString(1, description);
          preparedStatement.setDate(2, java.sql.Date.valueOf(deadline));

          preparedStatement.executeUpdate();
        }
    }
}
