package com.greenfoxacademy.connectionwithmysqlsecond.controllers;

import com.greenfoxacademy.connectionwithmysqlsecond.ConnectionWithMySqlSecondApplication;
import com.greenfoxacademy.connectionwithmysqlsecond.models.Todo;
import com.greenfoxacademy.connectionwithmysqlsecond.repositories.AssigneeRepository;
import com.greenfoxacademy.connectionwithmysqlsecond.repositories.TodoRepository;
import com.greenfoxacademy.connectionwithmysqlsecond.services.AssigneeService;
import com.greenfoxacademy.connectionwithmysqlsecond.services.TodoService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TodoRestController.class, secure = false)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @MockBean
    private AssigneeService assigneeService;

    @MockBean
    private AssigneeRepository assigneeRepository;

    private List<Todo> mockTodos = new ArrayList<>(Arrays.asList(new Todo("This is a mock Todo", true, true)));

    private MvcResult result;
    private static final int TARGET_JASON_OBJECT_INDEX = 0;

    @Before
    public void setupRequest() {
        Mockito.when(
                todoService.getAllTodo()).thenReturn(mockTodos);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/jsonlist")
                .accept(MediaType.APPLICATION_JSON);
        try {
            result = mockMvc.perform(requestBuilder).andReturn();
        } catch (Exception ex) {
            System.out.println("Problem performing request");
        }
    }
    @Test
    public void listTodosCheckOKStatusCode() throws Exception {

        int expectedStatus = 200;

        System.out.println("result.getResponse.getString: " + result.getResponse().getContentAsString());

        assertEquals(expectedStatus, result.getResponse().getStatus());
    }

    @Test
    public void listTodosCheckReceivedTodoField() throws Exception {

        String expectedTodoTitle = "This is a mock Todo";

        System.out.println("result.getResponse.getString: " + result.getResponse().getContentAsString());

        JSONArray receivedJsonArray = new JSONArray(result.getResponse().getContentAsString());
        JSONObject receivedJsonObject = new JSONObject(receivedJsonArray.getString(TARGET_JASON_OBJECT_INDEX));
        String receivedTodoTitle = receivedJsonObject.getString("title");

        assertEquals(expectedTodoTitle, receivedTodoTitle);
    }

    @Ignore
    @Test
    public void submitNewTodo() {
    }
}
