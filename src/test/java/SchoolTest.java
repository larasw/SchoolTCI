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
    public void oneCourseAddedToSchool() throws ParseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "01-01-2018");
        int courseAdded = school.getCourseList().size();

        // assert
        Assert.assertEquals("course failed to add",1, courseAdded);
    }
}
