package fit.bstu.by.myapplication;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@JsonAutoDetect
public class Book {

    private String publHome;
    private String genre;
    private String publDate;
    private String nameAuth;
    private String bookQnt;
    private String authQnt;
    private String bookName;

    @JsonIgnore
    private static ArrayList<Book> allBooks = new ArrayList<Book>();

    Book(){}
    Book(String publHome, String genre, String publDate, String nameAuth, String bookQnt, String authQnt, String bookName){
        this.publHome = publHome;
        this.genre    = genre;
        this.publDate = publDate;
        this.nameAuth = nameAuth;
        this.bookQnt  = bookQnt;
        this.authQnt  = authQnt;
        this.bookName = bookName;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public String getBookName(){
        return this.bookName;
    }

    public void setAuthQnt(String authQnt){
        this.authQnt = authQnt;
    }

    public String getAuthQnt(){
        return this.authQnt;
    }

    public void setBookQnt(String bookQnt){
        this.bookQnt = bookQnt;
    }

    public String getBookQnt(){
        return this.bookQnt;
    }

    public void setNameAuth(String nameAuth){
        this.nameAuth = nameAuth;
    }

    public String getNameAuth(){
        return this.nameAuth;
    }

    public void setPublDate(String publDate){
        this.publDate = publDate;
    }

    public String getPublDate(){
        return this.publDate;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }

    public void setPublHome(String publHome){
        this.publHome = publHome;
    }
    public String getPublHome(){
        return this.publHome;
    }

    public static void saveBook(Book book){

        allBooks.add(book);
    }

    public static void saveAllBooksIntoFile() {
        String jsonstr;
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileOutputStream stream = new FileOutputStream("/data/data/fit.bstu.by.myapplication/files/Lab3.json");
            mapper.writeValue(stream, allBooks);
        }catch (IOException e){
            Log.d("ERROR!", e.getMessage());
        }
    }
}
