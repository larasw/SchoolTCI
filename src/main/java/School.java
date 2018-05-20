import java.util.ArrayList;
import java.util.Date;

public class School {
    private String name;
    private Date date;
    private ArrayList<Course> courseList;

    public School(){
        courseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
