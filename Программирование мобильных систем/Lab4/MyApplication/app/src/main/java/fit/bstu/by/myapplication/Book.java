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
    private String phoneNumber;
    private String mail;
    private String url;

    @JsonIgnore
    private static ArrayList<Book> allBooks = new ArrayList<Book>();

    Book(){}
    Book(String publHome, String genre, String publDate, String nameAuth, String bookQnt, String authQnt, String bookName,
         String phoneNumber, String mail, String url){
        this.publHome    = publHome;
        this.genre       = genre;
        this.publDate    = publDate;
        this.nameAuth    = nameAuth;
        this.bookQnt     = bookQnt;
        this.authQnt     = authQnt;
        this.bookName    = bookName;
        this.phoneNumber = phoneNumber;
        this.mail        = mail;
        this.url         = url;
    }

    public void SteUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getMail()
    {
        return  this.mail;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber()
    {
        return this.phoneNumber;
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

    public static void addBook(Book book){
        allBooks.add(book);
    }
    public static ArrayList<Book> getAllBooks(){
        return allBooks;
    }
    public static void addAllBooks(ArrayList<Book> booklist)
    {
        allBooks.addAll(booklist);
    }
}
