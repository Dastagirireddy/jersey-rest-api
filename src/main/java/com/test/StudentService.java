package com.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/students")
public class StudentService {
    StudentDAO studentDAO = StudentDAO.getInstance();
    ObjectMapper objectMapper = new ObjectMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student add(String str) throws IOException {
        JsonNode jsonNode = objectMapper.readValue(str, JsonNode.class);
        return studentDAO.add(jsonNode.get("name").asText());
    }

}
