package org.fasttrack.it;

import org.fasttrack.it.persistance.ToDoItemRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class App
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        ToDoItemRepository toDoItemRepository = new ToDoItemRepository();
        toDoItemRepository .createToDoItem("Learn Java",
                LocalDateTime.now().plusMonths(6));

        ToDoItemRepository getToDoItems = new ToDoItemRepository();
        getToDoItems.getToDoItems();

    }
}
