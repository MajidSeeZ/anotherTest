import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;

/**
 some interactions between Member and Book Class are done here
 */
public class Borrow {
    private int idofmember;
    public int getIdofmember() {
        return idofmember;
    }
    public void setIdofmember(int idofmember) {
        this.idofmember = idofmember;
    }

    private int idofbook;
    public int getIdofbook() {
        return idofbook;
    }
    public void setIdofbook(int idofbook) {
        this.idofbook = idofbook;
    }

    private LocalDate Borroingdate;
    public void setBorroingdate() {
        Borroingdate = LocalDate.now();
    }
    public LocalDate getBorroingdate() {
        return Borroingdate;
    }

    private LocalDate EndOfBorrowingTime;
    public void setEndOfBorrowingTime(int target) {
        this.EndOfBorrowingTime = Borroingdate.plusDays(target);
    }
    public LocalDate getEndOfBorrowingTime() {
        return EndOfBorrowingTime;
    }

    private boolean Filled = false;
    public boolean getFilled(){
        return Filled;
    }
    public void setFilled (boolean newSet){
        this.Filled = newSet;
    }
}
