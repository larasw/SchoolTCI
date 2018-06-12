import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SchoolTest {
    @Test
    public void schoolNameNotNull() throws ParseException {
        // arrange
        School school = new School();

        // act
        school.setName(null);
        String schoolName = school.getName();

        // assert
        assertNotNull("School Name is null", schoolName);

        // Hamcrest
        assertThat(schoolName, is(notNullValue()));

        // AssertJ
        assertThat(schoolName).isNotNull();
    }

    @Test
    public void schoolDateNotNull() throws ParseException {
        // arrange
        School school = new School();

        // act
        school.setDate(null);
        Date schoolDate = school.getDate();

        // assert
        assertNotNull("School Date is null", schoolDate);

        // Hamcrest
        assertThat(schoolDate, is(notNullValue()));

        // AssertJ
        assertThat(schoolDate).isNotNull();
    }

    @Test
    public void oneCourseAddedToSchool() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "02-01-2018");
        int courseAdded = school.totalCourses();

        // assert
        assertEquals("course failed to add",1, courseAdded);

        // Hamcrest
        assertThat(courseAdded, is(equalTo(1)));

        // AssertJ
        assertThat(courseAdded).isEqualTo(1);
    }

    @Test(expected = CourseException.class)
    public void courseEndDateSetAfterBeginDate() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "31-12-2017");
        int courseAdded = school.totalCourses();

        // assert
        assertEquals("course with end date before start date success to add",
                0, courseAdded);

        // Hamcrest
        assertThat(courseAdded, is(equalTo(0)));

        // AssertJ
        assertThat(courseAdded).isEqualTo(0);
    }

    @Test
    public void nameOfTheCourseMustBeUnique() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "31-12-2018");
        school.addCourse("Math", "01-07-2018", "31-12-2018");
        int courseAdded = school.totalCourses();

        // assert
        assertEquals("Course with the same name has successfully been added",
                1, courseAdded);

        // Hamcrest
        assertThat(courseAdded, is(equalTo(1)));

        // AssertJ
        assertThat(courseAdded).isEqualTo(1);
    }

    @Test
    public void getCourseByCourseName() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "31-12-2018");
        Course course = school.getCourseByName("Math");

        // assert
        assertNotNull("Cannot take course by its name", course);

        // Hamcrest
        assertThat(course, is(notNullValue()));

        // AssertJ
        assertThat(course).isNotNull();
    }

    @Test
    public void listOfCourseNames() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "31-12-2018");
        school.addCourse("Science", "01-01-2018", "31-12-2018");
        school.addCourse("Biology", "01-01-2018", "31-12-2018");

        String[] courseNames = school.getCourseNames();
        int total = school.totalCourses();

        // assert
        assertEquals("Cannot take list of course names", total, courseNames.length);

        // Hamcrest
        assertThat(courseNames.length, is(equalTo(total)));

        // AssertJ
        assertThat(courseNames.length).isEqualTo(total);
    }

    @Test
    public void listOfAllCourses() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "01-01-2018", "31-12-2018");
        school.addCourse("Science", "01-01-2018", "31-12-2018");
        school.addCourse("Biology", "01-01-2018", "31-12-2018");

        ArrayList<Course> courseList = school.getListCourses();
        int total = school.totalCourses();

        // assert
        assertEquals("Cannot take list of courses", total, courseList.size());

        // Hamcrest
        assertThat(courseList.size(), is(equalTo(total)));

        // AssertJ
        assertThat(courseList.size()).isEqualTo(total);
    }

    @Test(expected = CourseException.class)
    public void courseBeginAddSetBeforeSchoolBeginDate() throws ParseException, CourseException {
        // arrange
        School school = new School();

        // act
        school.addCourse("Math", "30-12-2017", "31-12-2018");
        int total = school.totalCourses();

        // assert
        assertEquals("Course with start date before School begin date has successfully been added",
                0, total);

        // Hamcrest
        assertThat(total, is(equalTo(0)));

        // AssertJ
        assertThat(total).isEqualTo(0);
    }
}
