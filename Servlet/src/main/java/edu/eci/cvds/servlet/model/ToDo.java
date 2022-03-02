package edu.eci.cvds.servlet.model;
/*
* Usamos la libreria lombok
*/
import lombok.*;

public class ToDo {

    @Getter @Setter int userId;
    @Getter @Setter int id;
    @Getter @Setter String title;
    @Getter @Setter String completed;
    public ToDo(){}

}