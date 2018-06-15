import org.junit.Assert.*;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class CourseTest {
    @Test
    public void courseNameCannotBeNull() throws ParseException {
        // arrange
        Course course = new Course();

        // act
        course.setName(null);
        String schoolName = course.getName();

        // assert
        assertNotNull("Course Name is null", schoolName);

        // Hamcrest
        assertThat(schoolName, is(notNullValue()));

        // AssertJ
//        assertThat(schoolName).isNotNull();
    }

    @Test
    public void courseStartDateCannotBeNull() throws ParseException {
        // arrange
        Course course = new Course();

        // act
        course.setStartDate(null);
        Date schoolStartDate = course.getStartDate();

        // assert
        assertNotNull("Course Start Date is null", schoolStartDate);

        // Hamcrest
        assertThat(schoolStartDate, is(notNullValue()));

        // AssertJ
//        assertThat(schoolStartDate).isNotNull();
    }

    @Test
    public void courseEndDateCannotBeNull() throws ParseException {
        // arrange
        Course course = new Course();

        // act
        course.setEndDate(null);
        Date schoolEndDate = course.getEndDate();

        // assert
        assertNotNull("Course Start Date is null", schoolEndDate);

        // Hamcrest
        assertThat(schoolEndDate, is(notNullValue()));

        // AssertJ
//        assertThat(schoolEndDate).isNotNull();
    }
}
