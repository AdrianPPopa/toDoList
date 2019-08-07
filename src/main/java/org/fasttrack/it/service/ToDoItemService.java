package org.fasttrack.it.service;

import org.fasttrack.it.domain.ToDoItem;
import org.fasttrack.it.persistance.ToDoItemRepository;
import org.fasttrack.it.transfer.SaveToDoItemRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ToDoItemService {
    private ToDoItemRepository toDoItemRepository = new ToDoItemRepository();

    public void createToDoItem(SaveToDoItemRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating toDoItem:" + request);
        toDoItemRepository.createToDoItem(request.getDescription(), request.getDeadline());

    }
    public List<ToDoItem> getToDoItems() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving toDoItems...");
        return  toDoItemRepository.getToDoItems();
    }

    public void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting toDoItem:" + id);
        toDoItemRepository.deleteToDoItem(id);
    }
}
