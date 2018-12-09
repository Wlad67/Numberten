package sample;

import java.net.URL;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import  java.io.*;
import java.util.Date;
import java.util.ArrayList;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button butt;

    @FXML
    private TextField Aname;

    @FXML
    private TextArea infoarea;

    @FXML
    void initialize() throws ParseException {


        BufferedReader br = null;

        Scanner name = new Scanner(System.in);
        Date daten=new Date();
        SimpleDateFormat objSDF= new SimpleDateFormat("dd-mm-yyyy");
        //library[] library=new library[10];
        ArrayList<MyNewLIB> library=new ArrayList<>(10);
        library.add(0,new MyNewLIB("Зеленая миля", "Стивен Кинг", 1996, "Росмэн", 150, "Хорошое",objSDF.parse("24-07-2017")));
        library.add (1 , new MyNewLIB("Искусство программирования","Кнут Дональд",1968,"Addison–Wesley",85,"Отличное", objSDF.parse("08-04-2017")));
        library.add (2,new MyNewLIB("Техника и философия хакерских атак","Крис Касперски",1999,"СОЛОН-Р",120,"Удовлетворительное",objSDF.parse("14-09-2017")));
        library.add (3, new MyNewLIB("Алиса в Стране чудес","Льюис Кэрролл",1865,"Macmillan and Co",130,"Хорошое",objSDF.parse("07-05-2017")));
        library.add(4, new MyNewLIB("2001: Космическая одиссея ","Артур Кларк",1968,"New American Library",95,"Отличное",objSDF.parse("23-06-2017")));
        library.add(5, new MyNewLIB("Убийство в «Восточном экспрессе»","Агата Кристи",1934,"Collins Crime Club",140,"Хорошое",objSDF.parse("17-01-2017")));
        library.add(6,new MyNewLIB("Сияние","Стивен Кинг",1977,"Doubleday",132,"Удовлетворительное",objSDF.parse("08-08-2017")));
        library.add(7,new MyNewLIB("Оно","Стивен Кинг",1986,"Viking",88,"Хорощое",objSDF.parse("24-03- 2017")));
        library.add(8,new MyNewLIB("Смерть в облаках","Агата Кристи",1935,"Эксмо-Пресс",90,"Отличное",objSDF.parse("05-06-2017")));
        library.add(9,new MyNewLIB("11/22/63","Стивен Кинг",2011,"Charles Scribner's Sons",143,"Хорошое",objSDF.parse("19-04-2017" )));

        try {
            File filex = new File("text.txt");
            if (!filex.exists()) {
                filex.createNewFile();
            }
            PrintWriter pw = new PrintWriter(filex);
            for(int i=0;i<10;i++){
                pw.println(library.get(i).librinfo());
            }
            pw.close();

            br = new BufferedReader(new FileReader("text.txt"));
            String line;
            while((line = br.readLine())!=null){System.out.println(line);}

        } catch (IOException e) {
            System.out.println("Error" + e);
        }finally {
            try{
                br.close();
            }catch (IOException e){System.out.println("Error" + e);}
        }


        System.out.println("\nИзменить состояние книг, изданных больше N лет назад : \n");
        for(int i=0;i<10;i++){
            if(library.get(i).year<1990){System.out.println(library.get(i).newstate("Удовлетворительное"));}
            else {}
        }
        System.out.println("\nВывести названия всех книг, цена на которые > 100 гривен :\n ");
        for(int i=0;i<10;i++){
            if(library.get(i).value>100){System.out.println(library.get(i).librinfo());}
            else {}
        }
        System.out.println("\nВывести названия всех книг данного автора :\n ");
        String aut = name.nextLine();
        for(int i=0;i<10;i++){
            if(library.get(i).author.equals(aut)){System.out.println(library.get(i).librinfo());}
            else {}
        }
        System.out.println("\nВывести информацию о книгах, которые находятся на руках дольше 3 месяцев :\n ");
        Date tod =objSDF.parse("01-11-2017");

        for(int i=0;i<10;i++){
            if(library.get(i).date.compareTo(tod)>-95){System.out.println(library.get(i).librinfo());}
            else {}
        }

        butt.setOnAction(event -> {

            String text= Aname.getText();
            for(int i=0;i<10;i++){
                if(library.get(i).author.equals(text)){infoarea.appendText("\n"+library.get(i).librinfo());}
                else {}
            }
       });

    }
}
