enum topic {
                Historical,
                romance,
                scientific,
                schoolbook;
           }

/**
 I made a book class so all the vars and methods for books will be developed there
 */
public class Book {
    private int ID;
    public int getID() {
        return ID;
    }
    public void setID() {
        double id = Math.random();
        id = 100000*id;
        this.ID = (int) id;
    }

    private String BooksName;
    public String getBooksName() {
        return BooksName;
    }
    public void setBooksName(String booksName) {
        BooksName = booksName;
    }

    private String Year;
    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        Year = year;
    }

    private topic Topic;
    public String getTopic() {
        if(Topic == topic.Historical)
            return "Historical";
        else if(Topic == topic.romance)
            return "Romance";
        else if(Topic == topic.scientific)
            return "Scientific";
        else
            return "Schoolbook";
    }
    public void setTopic(topic topic) {
        Topic = topic;
    }

    private String AuthorFirstName;
    public String getAuthorFirstName() {
        return AuthorFirstName;
    }
    public void setAuthorFirstName(String authorFirstName) {
        AuthorFirstName = authorFirstName;
    }

    private String AuthorsLastName;
    public String getAuthorsLastName() {
        return AuthorsLastName;
    }
    public void setAuthorsLastName(String authorsLastName) {
        AuthorsLastName = authorsLastName;
    }

    private String volume;
    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }

    private boolean Filled = false;
    public boolean getFilled(){
        return Filled;
    }
    public void setFilled(boolean newSet){
        this.Filled = newSet;
    }

    private boolean Borrowed = false;
    public boolean getBorrowed(){
        return Borrowed;
    }
    public void setBorrowed(boolean newset){
        this.Borrowed = newset;
    }
}
