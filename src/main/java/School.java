import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class School {
    private String name;
    private Date date;
    private ArrayList<Course> courseList;

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public School() throws ParseException {
        this.name = "Fontys University";
        this.date = DATE_FORMAT.parse("01-01-2018");
        courseList = new ArrayList<>();
    }

    public void addCourse(String name, String startDate, String endDate)
            throws ParseException, CourseException {

        Date start = DATE_FORMAT.parse(startDate);
        Date end = DATE_FORMAT.parse(endDate);

        if(checkUniqueName(name)) {
            if (end.compareTo(start) > 0) {
                Course course = new Course();
                course.setName(name);
                course.setStartDate(startDate);
                course.setEndDate(endDate);

                courseList.add(course);
            } else {
                throw new CourseException("End Date should be After Start Date");
            }
        }
    }

    private boolean checkUniqueName(String name){
        for(int i = 0; i < totalCourses(); i++){
            if(name.equals(courseList.get(i).getName())){
                return false;
            }
        }
        return true;
    }

    public int totalCourses(){
        return courseList.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        if(date != null){
            this.date = DATE_FORMAT.parse(String.valueOf(date));
        }
    }
}
