import java.time.LocalDate;

public class Task {
    private String name,details;
    private int id;
    private LocalDate crDate, comDate;
    private Boolean completed;
    public Task(int id, String name, String details,LocalDate crDate, LocalDate comDate){
        this.id = id;
        this.name = name;
        this.details = details;
        this.crDate = crDate;
        this.comDate = comDate;
        completed = false;

        if (comDate.isBefore(LocalDate.now())) completed = true;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDetails(){
        return this.details;
    }
    public Boolean isCompleted(){
        return this.completed;
    }
    public LocalDate getCrDate(){
        return crDate;
    }
    public LocalDate getComDate(){
        return comDate;
    }
}
