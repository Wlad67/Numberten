package sample;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MyNewLIB {
    SimpleDateFormat objSDF= new SimpleDateFormat("s=dd-mm-yyyy");
    public String title;
    public String author;
    public int year;
    public String publ;
    public double value;
    public String state;
    public Date date;

    MyNewLIB (String title, String author, int year, String publ,  double value, String state,Date date) {
        this.title=title;
        this.author=author;
        this.year=year;
        this.publ=publ;
        this.value=value;
        this.state=state;
        this.date=date;
    }
    public String librinfo () {
        String linex=("Книга: " + title + "; Автор: " + author + "; Год: "+year+"; Издательство: "+publ+"; Цена: "+value+"; Состояние: " +state+"; Дата выдачи на руки: "+date);
        //System.out.println(linex);
        return linex;
    }
    public String newstate(String state){
        this.state=state;
        String linem=("Книга: " + title + "; Автор: " + author + "; Год: "+year+"; Издательство: "+publ+"; Цена: "+value+"; Состояние(обновленно): " +state+"; Дата выдачи на руки: "+date);
        //System.out.println(linem);
        return linem;
    }
}
