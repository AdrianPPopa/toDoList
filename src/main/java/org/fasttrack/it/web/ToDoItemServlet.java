package org.fasttrack.it.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrack.it.service.ToDoItemService;
import org.fasttrack.it.transfer.SaveToDoItemRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ToDoItemServlet extends HttpServlet {
    private ToDoItemService toDoItemService = new ToDoItemService();

    //end point

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        ObjectMapper objectMapper = new ObjectMapper();
        SaveToDoItemRequest request = objectMapper.readValue(req.getReader(), SaveToDoItemRequest.class);

        try {
            toDoItemService.createToDoItem(request);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server error: " + e.getMessage());
        }
    }
}
