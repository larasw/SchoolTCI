import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class School {
    private String name;
    private Date date;
    private ArrayList<Course> courseList = new ArrayList<>();

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public School() throws ParseException {
        this.name = "Fontys University";
        this.date = DATE_FORMAT.parse("31-12-2017");
    }

    public void addCourse(String name, String startDate, String endDate)
            throws ParseException, CourseException {
        if(checkCourseStartDate(startDate) && checkUniqueName(name) && checkCourseEndDate(startDate, endDate)) {
            Course course = new Course();
            course.setName(name);
            course.setStartDate(startDate);
            course.setEndDate(endDate);
            courseList.add(course);
        }
    }

    private boolean checkCourseStartDate(String startDate)
            throws CourseException, ParseException {
        Date start = DATE_FORMAT.parse(startDate);
        if(start.compareTo(date) > 0){
            return true;
        }
        throw new CourseException("Course Start Date should be After School Begin Date",
                new Throwable().getCause());
    }

    private boolean checkUniqueName(String name){
        for(int i = 0; i < totalCourses(); i++){
            if(name.equals(courseList.get(i).getName())){
                return false;
            }
        }
        return true;
    }

    private boolean checkCourseEndDate(String startDate, String endDate)
            throws ParseException, CourseException {
        Date start = DATE_FORMAT.parse(startDate);
        Date end = DATE_FORMAT.parse(endDate);
        if (end.compareTo(start) > 0) {
            return true;
        }
        throw new CourseException("End Date should be After Start Date");
    }

    public Course getCourseByName(String courseName) {
        for(int i = 0; i<totalCourses(); i++){
            if(courseName.equals(courseList.get(i).getName())){
                return courseList.get(i);
            }
        }
        return null;
    }

    public String[] getCourseNames() {
        String[] courseNames = new String[totalCourses()];
        for(int i = 0; i<totalCourses(); i++){
            courseNames[i] = courseList.get(i).getName();
        }
        return courseNames;
    }

    public ArrayList<Course> getListCourses() {
        return courseList;
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
