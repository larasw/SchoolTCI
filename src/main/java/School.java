import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class School {
    private String name;
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private Date date;
    private ArrayList<Course> courseList;

    public School(){
        courseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        } else {
            this.setName("Fontys University");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        if(date != null){
            this.date = DATE_FORMAT.parse(String.valueOf(date));
        } else {
            this.setDate("01-01-2018");
        }
    }
}
