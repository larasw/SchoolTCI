import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class SchoolTest {
    @Test
    public void schoolNameNotNull() throws ParseException {
        // arrange
        School school = new School();

        // act
        school.setName(null);
        String schoolName = school.getName();

        // assert
        Assert.assertNotNull("School Name is null", schoolName);
    }

    @Test
    public void schoolDateNotNull() throws ParseException {
        // arrange
        School school = new School();

        // act
        school.setDate(null);
        Date schoolDate = school.getDate();

        // assert
        Assert.assertNotNull("School Date is null", schoolDate);
    }

    @Test
    public void oneCourseAddedToSchool() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "02-01-2018");
        int courseAdded = school.totalCourses();

        // assert
        Assert.assertEquals("course failed to add",1, courseAdded);
    }

    @Test(expected = CourseException.class)
    public void courseEndDateSetAfterBeginDate() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "31-12-2017");
        int courseAdded = school.totalCourses();

        // assert
        Assert.assertEquals("course with end date before start date success to add",0, courseAdded);
    }

    @Test
    public void nameOfTheCOurseMustBeUnique() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "31-12-2018");
        school.addCourse("Math", "01-07-2018", "31-12-2018");
        int courseAdded = school.totalCourses();

        // assert
        Assert.assertEquals("Course with the same name has successfully been added",1, courseAdded);
    }
}
