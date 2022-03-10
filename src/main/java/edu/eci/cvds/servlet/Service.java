package edu.eci.cvds.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;

import edu.eci.cvds.servlet.model.ToDo;

public class Service {

   public static ToDo getTodo(int id) throws MalformedURLException, IOException {
       URL urldemo = new URL("https://jsonplaceholder.typicode.com/todos/" + id);
       URLConnection yc = urldemo.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
       Gson gson = new Gson();
       ToDo toDo = gson.fromJson(in, ToDo.class);
       in.close();
       return toDo;
   }

   private static String todoToHTMLRow(ToDo toDo) {
       return new StringBuilder("<tr>")
           .append("<td>")
           .append(toDo.getUserId())
           .append("</td><td>")
           .append(toDo.getId())
           .append("</td><td>")
           .append(toDo.getTitle())
           .append("</td><td>")
           .append(toDo.getCompleted())
           .append("</td>")
           .append("</tr>")
           .toString();
   }

   public static String todosToHTMLTable(List<ToDo> toDoList) {
       StringBuilder stringBuilder = new StringBuilder("<table>")
           .append("<tr>")
           .append("<th>User Id</th>")
           .append("<th>Id</th>")
           .append("<th>Title</th>")
           .append("<th>Completed</th>")
           .append("</tr>");

       for (ToDo toDo : toDoList) {
           stringBuilder.append(todoToHTMLRow(toDo));
       }

       return stringBuilder.append("</table>").toString();
   }
}