import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course {
    private String name;
    private Date startDate, endDate;

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public Course() throws ParseException {
        this.name = "Nameless course";
        this.startDate = DATE_FORMAT.parse("01-01-2018");
        this.endDate = DATE_FORMAT.parse("02-01-2018");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        if(startDate != null) {
            this.startDate = DATE_FORMAT.parse(startDate);
        }
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) throws ParseException {
        if(endDate != null) {
            this.endDate = DATE_FORMAT.parse(endDate);
        }
    }
}
