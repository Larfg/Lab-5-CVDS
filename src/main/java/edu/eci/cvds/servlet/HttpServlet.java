package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.ToDo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(
        urlPatterns = "/ToDo"
)
public class HttpServlet extends SampleServlet{

    private ArrayList<ToDo> todos;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        todos = new ArrayList<>();
        try {
            Optional<Integer> optId = Optional.ofNullable(Integer.parseInt(req.getParameter("id")));
            Integer id = optId.isPresent() ? optId.get() : -1;
            if (id == -1) throw new ServletException();
            ToDo tarea = Service.getTodo(id);
            resp.setStatus(HttpServletResponse.SC_OK);
            todos.add(tarea);
            writer.write(Service.todosToHTMLTable(todos));
        } catch(FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            writer.write("<h1> NO SE ENCONTRO EL ID DE LA TAREA </h1>");
        } catch(NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch(IOException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        ArrayList<ToDo> toDo =new ArrayList();
        try{
            Optional<String> optID = Optional.ofNullable(req.getParameter("id"));
            String id = optID.isPresent() && !optID.get().isEmpty() ? optID.get() : "";
            ToDo todo = Service.getTodo(Integer.parseInt(id));
            toDo.add(todo);
            resp.setStatus(HttpServletResponse.SC_OK);
            writer.write(Service.todosToHTMLTable(toDo));
        } catch(FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            writer.write("<h1> NO SE ENCONTRO EL ID DE LA TAREA </h1>");
        } catch(NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        writer.flush();
    }
}
