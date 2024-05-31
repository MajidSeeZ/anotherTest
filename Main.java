import java.util.Objects;
import java.util.Scanner;

/**
 All actions related to other classes are done in the Main class
 */

public class Main {

    /**
     used array of objects to handel data from members
     */
    public static Member[] Members = new Member[100];
    /**
     used array of objects to handel data from books
     */
    public static Book[] Books = new Book[100]; //  An array of object
    /**
     used array of objects to handel data from interactions between members and books
     */
    public static Borrow[] BorrowList = new Borrow[100];//

    /**

     Main Menu is where program starts and librarian can do his job
1    */
    public static void mainMenu() {
            System.out.print("[MAIN MENU]\n\n1.MEMBERS\n2.BOOKS\n3.BORROW\n4.EXIT\n\n>>");
            Scanner Choice = new Scanner(System.in);
            String C = Choice.nextLine();

            switch (C)
                {
                    case "1":
                        memberMenu();
                        break;
                    case "2":
                        booksMenu();
                    case "3":
                        borrowMenu();
                    case "4":
                        System.exit(0);
                    default:
                        System.out.print("\n[THERE IS NOT SUCH AN OPTION]\n\n");
                        mainMenu();
                }
        }

    /*

     * - Member Maneging

     */
    public static void memberMenu(){
            System.out.print("[MEMBERS MENU]\n\n1.ADD\n2.SHOW\n3.UPDATE\n4.DELETE\n5.BACK\n\n>>");
            Scanner Choice = new Scanner(System.in);
            String C = Choice.nextLine();

            switch (C)
                {
                    case "1":
                        addMember();
                        break;
                    case "2":
                        showMember();
                        break;
                    case "3":
                        updateMember();
                        break;
                    case "4":
                        deleteMember();
                        break;
                    case "5":
                        mainMenu();
                    default:
                        System.out.print("\n\n[THERE IS NOT SUCH AN OPTION]\n\n");
                        memberMenu();
                }
        }
    public static void addMember(){
        int p = 0;
        while(p <= 99)
            {
                if(!Members[p].getFilled())
                    break;
                else
                    p++;
            }

        Scanner Filler = new Scanner(System.in);
        System.out.print("\n\nFirst Name\n>>");
        Members[p].setFirstName(Filler.nextLine());

        System.out.print("\nLast Name\n>>");
        Members[p].setLastName(Filler.nextLine());

        System.out.print("\nAge\n>>");
        Members[p].setAge(Filler.nextInt());

        while(1 < 2){
            System.out.print("\nGender\n[1]Male\n[2]Female\n>>");
            int c = Filler.nextInt();
            if(c == 1){
                Members[p].setGender('M');
                break;
            }

            else if(c == 2){
                Members[p].setGender('F');
                break;
            }
            else
                System.out.print("\n[THERE IS NOT SUCH AN OPTION]\n");
        }
        int i = 0;
        Members[p].setID();
        do{
            if((Members[p].getID() == Members[i].getID() && p != i) || (Members[p].getID() <= 9999)) {
                Members[p].setID();
                i = 0;
                continue;
            }

            i++;
        }while(i <= p);

        System.out.print("\n[YOU JUST JOINED TO THE LIBRARY]\n\n");
        printCurrentMember(p);

        Members[p].setFilled(true);

        memberMenu();
    }
    public static void showMember(){
        int p = 0 , count = 0;
        System.out.print("[MEMBERS]\n");
        while(p <= 99){

            if(!Members[p].getFilled()){
                p++;
                continue;
            }

            else{
                count++;
                System.out.println("-------------------------------------");
                printCurrentMember(p);
                p++;
            }
        }
        if (count == 0){
            System.out.print("\n[THERE IS NO ACCOUNT TO SHOW]\n\n");
            memberMenu();
        }
        else {
            System.out.println("-------------------------------------");
        }
        System.out.print("[SEARCH : 1] [EXIT : 0]\n>>");
        Scanner Scanner = new Scanner(System.in);
        String temp;
        while(true){
            temp = Scanner.nextLine();
            switch(temp){
                case "1":
                    searchThroughMembersMenu();
                case "0":
                    memberMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]");
            }
        }
    }
    public static void updateMember(){
        Scanner id = new Scanner(System.in);
        System.out.print("\nEnter Your ID [Enter 1 to exit]\n>>");
        int search = id.nextInt();
        if(search == 1)
            memberMenu();
        int i = 0;
        while (true){
            if(search == Members[i].getID()){
                Scanner update = new Scanner(System.in);
                System.out.print("[UPDATE]\n\n[1].Name\n[2].Age\n[3].Back\n\n>>");
                int C = update.nextInt();
                Scanner Filler = new Scanner(System.in);
                while (true){
                    switch (C){
                        case 1: System.out.print(i);
                            System.out.print("\n\nFirst Name\n>>");
                            Members[i].setFirstName(Filler.nextLine());

                            System.out.print("\nLast Name\n>>");
                            Members[i].setLastName(Filler.nextLine());
                            break;
                        case 2:System.out.print("\nAge\n>>");
                            Members[i].setAge(Filler.nextInt());
                            break;
                        case 3:memberMenu();
                        default:
                            System.out.print("\n\n[THERE IS NOT SUCH AN OPTION]\n\n");
                    }
                    if(C == 1 || C == 2 || C == 3)
                        break;
                }
                System.out.print("\n[THIS IS YOUR NEW INFORMATION]\n\n");
                printCurrentMember(i);
                break;
            }
            i++;
            if(i == 99)
                break;
        }
        memberMenu();
    }
    public static void deleteMember(){
        System.out.print("[DELETE]\nenter your ID [Enter 1 to exit]\n>>");
        Scanner id = new Scanner(System.in);
        int ID = id.nextInt();
        if(ID == 1)
            memberMenu();
        int i = 0;
        while (i <= 99){
            if(ID == Members[i].getID()){
                System.out.print("\n[THIS IS YOUR INFORMATION FIELD]\n\n");
                printCurrentMember(i);
               while (true){
                   System.out.print("[ARE YOU SURE?]\n\n[1].YES      [2].NO\n>>");
                   Scanner C = new Scanner(System.in);
                   int c = C.nextInt();

                   if(c == 1){
                       Members[i].setFilled(false);
                       System.out.print("\n[THE ACCOUNT HAS BEEN DELETED]\n\n");
                       memberMenu();
                   }
                   else if(c == 2){
                       System.out.print("\n[THE PROCESS HAS BEEN CANCELED]\n\n");
                       memberMenu();
                   }

                   else {
                       System.out.print("\n[THERE IS NOT SUCH AN OPTION]\n");
                   }
               }
            }
            else
                i++;
        }
        System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS ID]\n\n");
        deleteMember();
    }


    public static void searchThroughMembersMenu(){
        String C;
        Scanner Scanner = new Scanner(System.in);
        System.out.print("[SEARCH MEMBER MENU]\n\n1.By ID\n2.By FIRST NAME\n3.By LAST NAME\n4.Back\n\n>>");
        C = Scanner.nextLine();
        switch(C){
            case "1":
                searchThroughMembersByID();
                break;
            case "2":
                searchThroughMembersByFirstName();
                break;
            case "3":
                searchThroughMembersByLastName();
                break;
            case "4":
                memberMenu();
        }
    }
    public static void searchThroughMembersByID(){
        int member = 0 , id;
        System.out.print("\nEnter Members ID\n>>");
        Scanner Scanner = new Scanner(System.in);
        id = Scanner.nextInt();
        while(true){
            if(Members[member].getID() == id && Members[member].getFilled()) {
                System.out.print("------------------------------------\n");
                printCurrentMember(member);
                break;
            }
            member++;
            if(member >= 99)
                break;
        }
        if(Members[member].getID() == id)
            System.out.print("------------------------------------\n");
        else
            System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS ID]\n");
        String C;
        while(true){
            System.out.print("[BACK : 0] [SEARCH : 1]\n>>");
            C = Scanner.nextLine();
            switch(C){
                case "0":
                    memberMenu();
                case "1":
                    searchThroughMembersMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]\n");
            }
        }
    }
    public static void searchThroughMembersByFirstName(){
        int count = 0, member = 0;
        String Name;
        Scanner Scanner = new Scanner(System.in);
        System.out.print("\nEnter Members Name\n>>");
        Name = Scanner.nextLine();
        while(true){
            if(Objects.equals(Members[member].getFirstName(), Name) && Members[member].getFilled()){
                System.out.print("------------------------------------\n");
                printCurrentMember(member);
                count++;
            }
            member++;
            if(member >= 99)
                break;
        }
        if(count == 0)
            System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS NAME]\n");
        else
            System.out.print("------------------------------------\n              " + count + " result\n");

        String C;
        while(true){
            System.out.print("[BACK : 0] [SEARCH : 1]\n>>");
            C = Scanner.nextLine();
            switch(C){
                case "0":
                    memberMenu();
                case "1":
                    searchThroughMembersMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]\n");
            }
        }
    }
    public static void searchThroughMembersByLastName(){
        int count = 0, member = 0;
        String Name;
        Scanner Scanner = new Scanner(System.in);
        System.out.print("\nEnter Members Last Name\n>>");
        Name = Scanner.nextLine();
        while(true){
            if(Objects.equals(Members[member].getLastName(), Name) && Members[member].getFilled()){
                System.out.print("------------------------------------\n");
                printCurrentMember(member);
                count++;
            }
            member++;
            if(member >= 99)
                break;
        }
        if(count == 0)
            System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS NAME]\n");
        else
            System.out.print("------------------------------------\n              " + count + " result\n");

        String C;
        while(true){
            System.out.print("[BACK : 0] [SEARCH : 1]\n>>");
            C = Scanner.nextLine();
            switch(C){
                case "0":
                    memberMenu();
                case "1":
                    searchThroughMembersMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]\n");
            }
        }
    }
    /*

     * - Book maneging

     */

    public static void booksMenu(){
        System.out.print("[BOOKS MENU]\n\n1.ADD\n2.SHOW\n3.UPDATE\n4.DELETE\n5.BACK\n\n>>");
        Scanner Choice = new Scanner(System.in);
        String C = Choice.nextLine();

        switch (C)
        {
            case "1":
                addBook();
                break;
            case "2":
                showBook();
                break;
            case "3":
                updateBook();
                break;
            case "4":
                deleteBook();
                break;
            case "5":
                mainMenu();
                break;
            default:
                System.out.print("\n\n[THERE IS NOT SUCH AN OPTION]\n\n");
                memberMenu();
        }
    }
    public static void addBook(){
        int p = 0;
        while(p <= 99)
        {
            if(!Books[p].getFilled())
                break;
            else
                p++;
        }

        Scanner Filler = new Scanner(System.in);
        System.out.print("\n\nBooks Name\n>>");
        Books[p].setBooksName(Filler.nextLine());

        while(true){
            System.out.print("\n[TOPIC]\n[1]. HISTORICAL\n[2]. ROMANCE\n[3]. SCIENTIFIC\n[4]. SCHOOLBOOK\n>>");
            String C = Filler.nextLine();
            switch(C){
                case "1":
                    Books[p].setTopic(topic.Historical);
                    break;
                case "2":
                    Books[p].setTopic(topic.romance);
                    break;
                case "3":
                    Books[p].setTopic(topic.scientific);
                    break;
                case "4":
                    Books[p].setTopic(topic.schoolbook);
                    break;
                default:
                    System.out.print("\n[THERE IS NOT SUCH AN OPTION]\n");
            }
            if(C.equals("1") || C.equals("2") || C.equals("3") || C.equals("4"))
                break;
        }
        Scanner Scan = new Scanner(System.in);

        System.out.print("\nAuthors First Name\n>>");
        Books[p].setAuthorFirstName(Scan.nextLine());

        System.out.print("\nAuthors Last Name\n>>");
        Books[p].setAuthorsLastName(Scan.nextLine());

        System.out.print("\nVolume\n>>");
        Books[p].setVolume(Scan.nextLine());



        System.out.print("\nYear\n>>");
        Books[p].setYear(Filler.nextLine());

        int i = 0;
        Books[p].setID();
        while(i <= 99){
            if(i == p){
                i++;
                continue;
            }
            if((Books[p].getID() == Books[i].getID() || Books[p].getID() <= 9999)){
                i = 0;
                Books[p].setID();
                continue;
            }
            i++;
        }

        System.out.print("\n[YOU JUST ADDED A BOOK TO THE LIBRARY]\n");
        printCurrentBook(p);
        Books[p].setFilled(true);

        booksMenu();
    }
    public static void showBook(){
        int p = 0 , count =0;
        System.out.print("[BOOKS]\n");
        while(p <= 99){

            if(!Books[p].getFilled()){
                p++;
                continue;
            }

            else{
                count++;
                System.out.println("-------------------------------------");
                printCurrentBook(p);
                p++;
            }

        }
        if (count == 0){
            System.out.print("\n[THERE IS NO ACCOUNT TO SHOW]\n\n");
        }
        else
            System.out.println("-------------------------------------");
        System.out.print("[SEARCH : 1] [EXIT : 0]\n>>");
        Scanner Scanner = new Scanner(System.in);
        String temp;
        while(true){
            temp = Scanner.nextLine();
            switch(temp){
                case "1":
                    searchThroughBooksMenu();
                case "0":
                    memberMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]");
            }
        }
    }
    public static void updateBook(){
        Scanner id = new Scanner(System.in);
        System.out.print("\nEnter Books ID [Enter 1 to exit]\n\n>>");
        int search = id.nextInt();
        if(search == 1)
            booksMenu();
        int i = 0;
        while (true){
            if(search == Books[i].getID()){
                Scanner update = new Scanner(System.in);
                System.out.print("[UPDATE]\n\n[1].Books Name\n[2].Books Vol\n[3].Authors Name\n[4].Year\n[5].Back\n\n>>");
                int C = update.nextInt();
                Scanner Filler = new Scanner(System.in);
                while (true){
                    switch (C){
                        case 1:
                            System.out.print("\n\nBooks Name\n>>");
                            Books[i].setBooksName(Filler.nextLine());
                            break;
                        case 2:
                            System.out.print("\nVolume\n>>");
                            Books[i].setVolume(Filler.nextLine());
                            break;
                        case 3:
                            System.out.print("\nAuthors First Name\n>>");
                            Books[i].setAuthorFirstName(Filler.nextLine());

                            System.out.print("\nAuthors Last Name\n>>");
                            Books[i].setAuthorsLastName(Filler.nextLine());
                            break;
                        case 4:
                            System.out.print("\nYear\n>>");
                            Books[i].setYear(Filler.nextLine());
                        case 5:
                            booksMenu();
                            break;
                        default:
                            System.out.print("\n\n[THERE IS NOT SUCH AN OPTION]\n\n");
                    }
                    if(C >= 1 && C <= 5)
                        break;
                }
                System.out.print("\n[THIS IS BOOKS NEW INFORMATION]\n\n");
                printCurrentBook(i);
                break;
            }
            i++;
            if(i == 99)
                break;
        }
        booksMenu();
    }
    public static void deleteBook(){
        System.out.print("[DELETE]\nenter Books ID [Enter 1 to exit]\n>>");
        Scanner id = new Scanner(System.in);
        int ID = id.nextInt();
        if(ID == 1)
            booksMenu();
        int p = 0;
        while (p <= 99){
            if(ID == Books[p].getID()){
                System.out.print("\n[THIS IS BOOKS INFORMATION FIELD]\n\n");
                printCurrentBook(p);

                while (true){
                    System.out.print("[ARE YOU SURE?]\n\n[1].YES      [2].NO\n>>");
                    Scanner C = new Scanner(System.in);
                    int c = C.nextInt();

                    if(c == 1){
                        Books[p].setFilled(false);
                        System.out.print("\n[THE ACCOUNT HAS BEEN DELETED]\n\n");
                        booksMenu();
                    }
                    else if(c == 2){
                        System.out.print("\n[THE PROCESS HAS BEEN CANCELED]\n\n");
                        booksMenu();
                    }

                    else {
                        System.out.print("\n[THERE IS NOT SUCH AN OPTION]\n");
                    }
                }

            }
            else
                p++;
        }
        System.out.print("\n[THERE IS NOT ANY BOOK WITH THIS ID]\n\n");
        deleteBook();
    }


    public static void searchThroughBooksMenu(){
        String C;
        Scanner Scanner = new Scanner(System.in);
        System.out.print("[SEARCH BOOKS MENU]\n\n1.By ID\n2.By AUTHORS FIRST NAME\n3.By AUTHORS LAST NAME\n4.By BOOKS NAME\n5.Back\n\n>>");
        C = Scanner.nextLine();
        switch(C){
            case "1":
                searchThroughBooksByID();
                break;
            case "2":
                searchThroughBooksByAuthorsFirstName();
                break;
            case "3":
                searchThroughBooksByAuthorsByLastName();
                break;
            case "4":
                searchThroughBooksByBooksName();
            case "5":
                memberMenu();
        }
    }
    public static void searchThroughBooksByID(){
        int book = 0 , id;
        System.out.print("\nEnter Books ID\n>>");
        Scanner Scanner = new Scanner(System.in);
        id = Scanner.nextInt();
        while(true){
            if(Books[book].getID() == id && Books[book].getFilled()) {
                System.out.print("------------------------------------\n");
                printCurrentBook(book);
                break;
            }
            book++;
            if(book >= 99)
                break;
        }
        if(Books[book].getID() == id)
            System.out.print("------------------------------------");
        else
            System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS ID]\n");

        String C;
        while(true){
            System.out.print("\n[BACK : 0] [SEARCH : 1]\n>>");
            C = Scanner.nextLine();
            switch(C){
                case "0":
                    booksMenu();
                case "1":
                    searchThroughBooksMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]\n");
            }
        }
    }
    public static void searchThroughBooksByAuthorsFirstName(){
        int count = 0, book = 0;
        String Name;
        Scanner Scanner = new Scanner(System.in);
        System.out.print("\nEnter Books Authors Name\n>>");
        Name = Scanner.nextLine();
        while(true){
            if(Objects.equals(Books[book].getAuthorFirstName(), Name) && Books[book].getFilled()){
                System.out.print("------------------------------------\n");
                printCurrentBook(book);
                count++;
            }
            book++;
            if(book >= 99)
                break;
        }
        if(count == 0)
            System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS NAME]\n");
        else
            System.out.print("------------------------------------\n              " + count + " result\n");

        String C;
        while(true){
            System.out.print("[BACK : 0] [SEARCH : 1]\n>>");
            C = Scanner.nextLine();
            switch(C){
                case "0":
                    booksMenu();
                case "1":
                    searchThroughBooksMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]\n");
            }
        }
    }
    public static void searchThroughBooksByAuthorsByLastName(){
        int count = 0, book = 0;
        String Name;
        Scanner Scanner = new Scanner(System.in);
        System.out.print("\nEnter Authors Last Name\n>>");
        Name = Scanner.nextLine();
        while(true){
            if(Objects.equals(Books[book].getAuthorsLastName(), Name) && Books[book].getFilled()){
                System.out.print("------------------------------------\n");
                printCurrentBook(book);
                count++;
            }
            book++;
            if(book >= 99)
                break;
        }
        if(count == 0)
            System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS NAME]\n");
        else
            System.out.print("------------------------------------\n              " + count + " result\n");

        String C;
        while(true){
            System.out.print("[BACK : 0] [SEARCH : 1]\n>>");
            C = Scanner.nextLine();
            switch(C){
                case "0":
                    booksMenu();
                case "1":
                    searchThroughBooksMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]\n");
            }
        }
    }
    public static void searchThroughBooksByBooksName(){
        int count = 0, book = 0;
        String Name;
        Scanner Scanner = new Scanner(System.in);
        System.out.print("\nEnter Books Name\n>>");
        Name = Scanner.nextLine();
        while(true){
            if(Objects.equals(Books[book].getBooksName(), Name) && Books[book].getFilled()){
                System.out.print("------------------------------------\n");
                printCurrentBook(book);
                count++;
            }
            book++;
            if(book >= 99)
                break;
        }
        if(count == 0)
            System.out.print("\n[THERE IS NOT ANY ACCOUNT WITH THIS NAME]\n");
        else
            System.out.print("------------------------------------\n              " + count + " result\n");

        String C;
        while(true){
            System.out.print("[BACK : 0] [SEARCH : 1]\n>>");
            C = Scanner.nextLine();
            switch(C){
                case "0":
                    booksMenu();
                case "1":
                    searchThroughBooksMenu();
                default:
                    System.out.print("[THERE IS NOT SUCH AN OPTION]\n");
            }
        }
    }

    /*

     * - Borrow

     */

    public static void borrowMenu(){
        System.out.print("\n[BORROW MENU]\n\n1.ADD TO THE BORROWINGS\n2.SHOW BORROWINGS\n3.CHECK BORROWING DATES\n4.END A BORROWING\n5.BACK\n\n>>");
        Scanner Choice = new Scanner(System.in);
        String C = Choice.nextLine();

        switch (C)
        {
            case "1":
                borrowBook();
                break;
            case "2":
                borrowList();
                break;
            case "3":
                borrowDates();
                break;
            case "4":
                endBorrowing();
                break;
            case "5":
                mainMenu();
                break;
            default:
                System.out.print("\n\n[THERE IS NOT SUCH AN OPTION]\n\n");
                borrowMenu();
        }
    }
    public static void borrowBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Members ID [Enter 1 to exit]\n>>");
        int memberid = scanner.nextInt();
        int member = 0;
        if(memberid == 1) {
            mainMenu();
        }
        while(true){
            if(Members[member].getID() == memberid && !Members[member].getBorrowing())
                break;
            else if(member >= 99){
                System.out.print("\n[THERE IS NOT ANY MEMBER WITH THIS ID IN THE LIST OR THE MEMBER IS ALREADY BORROWING A BOOK]\n");
                borrowBook();
            }
            else
                member++;
        }
        int bookid;
        int book = 0;
        while(true){
            System.out.print("\nEnter Books ID [Enter 1 to exit]\n>>");
            bookid = scanner.nextInt();
            while(true){
                if(Books[book].getID() == bookid && !Books[book].getBorrowed())
                    break;
                else if(book >= 99){
                    System.out.print("\n[THERE IS NOT ANY BOOK WITH THIS ID IN THE LIST OR THE BOOK Is ALREADY BORROWED]\n");
                    break;
                }
                else
                    book++;
            }
            if(Books[book].getID() != bookid)
                continue;
            else
                break;
        }
        int borrow = 0;
        while(true){
            if(BorrowList[borrow].getFilled() == false)
                break;
            else
                borrow++;
        }

        int target = 0;
        while(true){
            System.out.print("\nFor how many days?\n>>");
            target = scanner.nextInt();
            if(target >= 2)
                break;
            else
                System.out.print("[NUMBER SHOULD BE MORE THAN ONE DAY!]");
        }

        System.out.print("\n[MEMBERS INFORMATION]\n");
        printCurrentMember(member);
        System.out.print("\n[BOOKS INFORMATION]\n");
        printCurrentBook(book);
        BorrowList[borrow].setIdofbook(bookid);
        BorrowList[borrow].setIdofmember(memberid);
        BorrowList[borrow].setBorroingdate();
        BorrowList[borrow].setEndOfBorrowingTime(target);

        System.out.print("\nFrom: " + BorrowList[borrow].getBorroingdate() + "\n");
        System.out.print("\nUntil: " + BorrowList[borrow].getEndOfBorrowingTime() + "\n");

        while(true){
            System.out.print("\n[ARE YOU SURE?]\n[1].YES         [2].NO\n>>");
            int c = scanner.nextInt();
            if(c == 1){
                BorrowList[borrow].setFilled(true);
                Members[member].setBorrowing(true);
                Books[book].setBorrowed(true);
                System.out.print("\n[BOOK HAS BEEN BORROWED]\n");
                borrowMenu();
            }
            else if(c == 2){
                System.out.print("\n[THE PROCESS HAS BEEN CANCELED]\n");
                borrowMenu();
            }
            else
                System.out.print("\n[THERE IS NOT SUCH AN OPTION]\n");
        }


    }
    public static void borrowList(){
        int p = 0 , count = 0;
        while(p <= 99){

            if(BorrowList[p].getFilled()){
                count++;
                int book = 0 , member = 0;

                while(true){
                    if(BorrowList[p].getIdofmember() == Members[member].getID())
                        break;
                    else
                        member++;
                }
                while (true){
                    if(BorrowList[p].getIdofbook() == Books[book].getID())
                        break;
                    else
                        book++;
                }

                System.out.println("-------------------------------------");

                System.out.print("\n[MEMBERS INFORMATION]\n");
                printCurrentMember(member);
                System.out.print("\n[BOOKS INFORMATION]\n");
                printCurrentBook(book);
            }
            p++;
        }
        if (count == 0){
            System.out.print("\n[THERE IS NO BORROWING TO SHOW]\n\n");
        }
        else
            System.out.println("-------------------------------------");
        borrowMenu();
    }
    public static void borrowDates(){
        Scanner c = new Scanner(System.in);
        System.out.print("\nEnter Members id\n>>");
        int searchid = c.nextInt();
        int p = 0;
        while(true){
            if(p >= 100)
                break;
            else if(BorrowList[p].getIdofmember() == searchid)
                compareDates(p);
            else
                p++;
        }
    }
    public static void compareDates(int borrow){
        System.out.print("\nBook Was Borrowed in: " + BorrowList[borrow].getBorroingdate() + "\n");
        System.out.print("\nBooks Borrowing Ends in: " + BorrowList[borrow].getEndOfBorrowingTime() + "\n");
        if(BorrowList[borrow].getBorroingdate().isAfter(BorrowList[borrow].getEndOfBorrowingTime()))
            System.out.print("\nEnd of time\n");
        else
            System.out.print("\nMember still got time\n");
        borrowMenu();
    }
    public static void endBorrowing(){
        Scanner Scanner = new Scanner(System.in);
        System.out.print("\nEnter Members id\n>>");
        int memberid = Scanner.nextInt();
        int p = 0 , member = 0 , book = 0;
        while(true){
            if(BorrowList[p].getIdofmember() == memberid && BorrowList[p].getFilled()){
                while(true){
                    if(Members[member].getID() == BorrowList[p].getIdofmember())
                        break;
                    else if(p >= 99){
                        System.out.print("\n[ERROR IN THE SEARCHING]");
                        endBorrowing();
                    }
                    else
                        p++;
                }
                while(true){
                    if(Books[book].getID() == BorrowList[p].getIdofbook())
                        break;
                    else if(p >= 99){
                        System.out.print("\n[ERROR IN THE SEARCHING]");
                        endBorrowing();
                    }
                    else
                        p++;
                }
                System.out.print("\n[MEMBER INFORMATION]");
                printCurrentMember(member);
                System.out.print("\n[BOOK INFORMATION]");
                printCurrentBook(book);
                System.out.print("\nBorrowed in: " + BorrowList[p].getBorroingdate());
               while(true){
                   System.out.print("\nDO YOU VERIFY THAT MEMBER HAS RETURNED THE BOOK?\n[1].yes          [2].no\n>>");
                   int c = Scanner.nextInt();
                   if(c == 1){
                       BorrowList[p].setFilled(false);
                       Members[member].setBorrowing(false);
                       Books[book].setBorrowed(false);
                       System.out.print("\n[ALL DONE]\n");
                       borrowMenu();
                   }
                   else if(c == 2){
                       System.out.print("\n[PROCESS HAS BEEN CANCELED]\n");
                       borrowMenu();
                   }
                   else{
                       System.out.print("\n[THERE IS NOT SUCH AN OPTION]\n");
                   }
               }

            }
            else if(p >= 99){
                System.out.print("\n[ID IS NOT VALID OR THERE IS NOT A BORROWING ON THIS ID]\n");
                borrowMenu();
            }
            else
                p++;
        }
    }

    /*
        working on my high rules(git)
     * - Show Functions

     */

    public static void printCurrentMember(int member){
        System.out.println("\nID: " + Members[member].getID());
        System.out.println("Name: " + Members[member].getFirstName() + " " + Members[member].getLastName() );
        System.out.println("Age: " + Members[member].getAge());
        if(Members[member].getGender() == 'M')
            System.out.println("Gender: Male\n");
        else
            System.out.println("Gender: Female\n");
    }

    public static void printCurrentBook(int book){
        System.out.println("\nID: " + Books[book].getID());
        System.out.println("Books Name: " + Books[book].getBooksName() + " vol." + Books[book].getVolume());
        System.out.println("Authors Name: " + Books[book].getAuthorFirstName() + " " + Books[book].getAuthorsLastName() );
        System.out.println("Year: " + Books[book].getYear());
        if(Books[book].getTopic() == "Historical")
            System.out.println("Topic: Historical\n");
        else if(Books[book].getTopic() == "Romance")
            System.out.println("Topic: Romance\n");
        else if(Books[book].getTopic() == "Scientific")
            System.out.println("Topic: Scientific\n");
        else
            System.out.println("Topic: Schoolbook\n");
    }

    public static void main(String[] args) {
        for(int i = 0 ; i <= 99 ; i++)
            Members[i] = new Member();
        for(int i = 0 ; i <= 99 ; i++)
            Books[i] = new Book();
        for(int i = 0 ; i <= 99 ; i++)
            BorrowList[i] = new Borrow();
        mainMenu();
    }
}
