import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course {
    private String name;
    private Date startDate, endDate;

    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        } else {
            this.setName("Nameless course");
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        if(startDate != null) {
            this.startDate = DATE_FORMAT.parse(startDate);
        } else {
            this.setStartDate("01-01-2018");
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) throws ParseException {
        if(endDate != null) {
            this.endDate = DATE_FORMAT.parse(endDate);
        } else {
            this.setEndDate("01-01-2018");
        }
    }
}
