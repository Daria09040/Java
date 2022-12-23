import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mgr {
    ArrayList<Task> tasks;
    Scanner in;
    int id;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


    public Mgr(){
        tasks = new ArrayList<>();
        in = new Scanner(System.in);
        id = 0;
        showMenu();
    }

    private void showMenu(){
        System.out.println("1 : Создать задание");
        System.out.println("2 : Удалить задание");
        System.out.println("3 : Отредактировать задание");
        System.out.println("4 : Посмотреть списов всех заданий");
        System.out.println("5 : Посмотреть список выполненных заданий");
        System.out.println("6 : Посмотреть список не выполненных заданий");
        System.out.println("7 : Посмотреть список по дате выполнения");
        System.out.println("8 : Посмотреть список по дате создания");
        System.out.println("9 : Посмотреть детальную информацию о задании");
        System.out.println("Всё остальное для выхода");
        try{
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("---------------------");
                    createTask();
                break;
                case 2:
                    System.out.println("---------------------");
                    showTasks();
                    removeTask();
                break;
                case 3:
                    System.out.println("---------------------");
                    showTasks();
                    changeTask();
                break;
                case 4:
                    System.out.println("---------------------");
                    showTasks();
                    showMenu();
                break;
                case 5:
                    System.out.println("---------------------");
                    showCompletedTasks();
                    showMenu();
                break;
                case 6:
                    System.out.println("---------------------");
                    showPendingTasks();
                    showMenu();
                break;
                case 7:
                    System.out.println("---------------------");
                    System.out.println("Введите дату выполнения");
                    showByCompDate(dateInput());
                    showMenu();
                    break;
                    case 8:
                    System.out.println("---------------------");
                    System.out.println("Введите дату создания");
                    showByCreationDate(dateInput());
                    showMenu();
                break;
                case 9:
                    System.out.println("---------------------");
                System.out.println("");
                break;
                default:
                
                break;
            }
        } catch (InputMismatchException e){

        }
        

    }

    private LocalDate dateInput(){
        LocalDate ldate;
        while (true)
        {
            try{
                System.out.println("Введите дату в формате ДД/ММ/ГГГГ");
                String date = in.next();
                ldate = LocalDate.parse(date,formatter);
            } catch (java.time.format.DateTimeParseException e){
                System.out.println("Неверный формат!");
                continue;
            }
            break;
        }
        return ldate;
    }    
    //1
    private void createTask(){

        System.out.println("Введите имя задачи");
        String name = in.next();

        System.out.println("Введите дополнительные сведения");
        String details= in.next();

        LocalDate ldate;

        System.out.println("Введите дату выполнения");
        ldate = dateInput();
        tasks.add(new Task(id, name, details,LocalDate.now(), ldate));
        id += 1;
        System.out.println("---------------------");
        showMenu();
    }
    //4
    private void showTasks(){
        System.out.println("Список всех задач:");
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + " : " + task.getName());
        }
        System.out.println("---------------------");
    }
    //5
    private void showCompletedTasks(){
        System.out.println("Список выполненных задач:");
        for (Task task : tasks) {
            if (task.isCompleted())
            System.out.println(tasks.indexOf(task) + " : " + task.getName());
        }
        System.out.println("---------------------");
    }
    //6
    private void showPendingTasks(){
        System.out.println("Список не выполненных задач:");
        for (Task task : tasks) {
             if (!task.isCompleted())
            System.out.println(tasks.indexOf(task) + " : " + task.getName());
        }
        System.out.println("---------------------");
    }
    //7
    private void showByCompDate(LocalDate ldate){
        System.out.println("Список задач для выполнения " + ldate.toString());
        for (Task task : tasks) {
            if (task.getComDate().equals(ldate))
            System.out.println(tasks.indexOf(task) + " : " + task.getName());
        }
        System.out.println("---------------------");
    }
    //7
    private void showByCreationDate(LocalDate ldate){
            System.out.println("Список задач, созданных " + ldate.toString());
            for (Task task : tasks) {
            if (task.getCrDate().equals(ldate))
            System.out.println(tasks.indexOf(task) + " : " + task.getName());
        }
        System.out.println("---------------------");
    }
    //2
    private void removeTask(){
        try{
            System.out.println("Введите id задачи, которую надо удалить");
            tasks.remove(in.nextInt());
            System.out.println("---------------------");
        } catch (IndexOutOfBoundsException e) {System.out.println("Нет такого индекса");}
        showMenu();
    }
    //3
    private void changeTask(){
        
        System.out.println("Введите id задачи, которую надо отредактировать");

        try{
            int taskID = in.nextInt();
            try{
                Task nowTask = tasks.get(taskID);
                int id = nowTask.getId();
                String name = nowTask.getName();
                String details = nowTask.getDetails();
                LocalDate crDate = nowTask.getCrDate();
                LocalDate comDate = nowTask.getComDate();
                System.out.println("--------");
                System.out.println("1 - Имя: " + name);
                System.out.println("2 - Доп. сведения: " + details); 
                System.out.println("3 - Дата создания: " + crDate.toString());
                System.out.println("4 - Дата выполнения: " + comDate.toString());
                System.out.println("--------");
                System.out.println("Что вы хотите изменить? (1-4 выбор, все остальное вернуться в меню)");
                try{
                    int input = in.nextInt();
                    switch (input){
                        case 1:
                        System.out.println("Введите новое имя:");
                        name = in.next();
                        break;
                        case 2:
                        System.out.println("Введите новые доп.сведения:");
                        details = in.next();
                        break;
                        case 3:  
                        System.out.println("Введите новую дату создания ");
                        crDate = dateInput();
                        break;
                        case 4:
                        System.out.println("Введите новую дату выполнения");
                        comDate = dateInput();
                        break;
                        default:
                        break;
                        
                    }
                    tasks.set(taskID, new Task(id, name, details, crDate, comDate));
                } catch (InputMismatchException e){}
            } catch (IndexOutOfBoundsException e) {System.out.println("Нет такого индекса");}            
        } catch (InputMismatchException e) {System.out.println("Только цифры!");}
            
        showMenu();
    }
}
