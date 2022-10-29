package readers;

public class Reader {
    private String name;
    private int number;
    private String date;
    private String phone;
    private String facult;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFacult(String facult) {
        this.facult = facult;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String getFacult() {
        return facult;
    }

    public void takeBook(String book) {
        System.out.println("Студент " + name + " взял книгу " + book);
    }

    public void returnBook(String book) {
        System.out.println("Студент " + name + " вернул книгу " + book);
    }

    public void info() {
        System.out.println(name + " " + number + " " + facult + " " + phone);
    }
}
