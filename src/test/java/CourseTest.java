import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class CourseTest {
    @Test
    public void courseNameCannotBeNull() throws ParseException {
        // arrange
        Course course = new Course();

        // act
        course.setName(null);
        String schoolName = course.getName();

        // assert
        Assert.assertNotNull("Course Name is null", schoolName);
    }

    @Test
    public void courseStartDateCannotBeNull() throws ParseException {
        // arrange
        Course course = new Course();

        // act
        course.setStartDate(null);
        Date schoolStartDate = course.getStartDate();

        // assert
        Assert.assertNotNull("Course Start Date is null", schoolStartDate);
    }

    @Test
    public void courseEndDateCannotBeNull() throws ParseException {
        // arrange
        Course course = new Course();

        // act
        course.setEndDate(null);
        Date schoolEndDate = course.getEndDate();

        // assert
        Assert.assertNotNull("Course Start Date is null", schoolEndDate);
    }
}
