/**
 I made a book class so all the vars and methods for books will be developed there
 */
public class Member {
    private String FirstName;
    public String getFirstName(){
        return FirstName;
    }
    public void setFirstName(String newName){
        this.FirstName = newName;
    }

    private String LastName;
    public String getLastName(){
        return LastName;
    }
    public void setLastName(String newName){
        this.LastName = newName;
    }

    private int ID;
    public  int getID(){
        return ID;
    }

    public void setID(){
        double id = Math.random();
        id = 100000*id;

        this.ID = (int) id;
    }

    private int age;
    public  int getAge(){
        return age;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }

    private char Gender;
    public char getGender(){
        return Gender;
    }
    public void setGender(char gender){
        this.Gender = gender;
    }

    private boolean Filled = false;
    public boolean getFilled(){
        return Filled;
    }
    public void setFilled (boolean newSet){
        this.Filled = newSet;
    }

    private boolean borrowing = false;
    public boolean getBorrowing(){
        return borrowing;
    }
    public void setBorrowing(boolean newset){
        this.borrowing = newset;
    }
}
