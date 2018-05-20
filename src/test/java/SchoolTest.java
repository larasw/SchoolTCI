import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SchoolTest {
    @Test
    public void schoolNameNotNull() {
        // arrange
        School school = new School();

        // act
        school.setName(null);
        String schoolName = school.getName();

        // assert
        Assert.assertNotNull("School Name is null", schoolName);
    }

    @Test
    public void schoolDateNotNull() {
        // arrange
        School school = new School();

        // act
        school.setDate(null);
        Date schoolDate = school.getDate();

        // assert
        Assert.assertNotNull("School Date is null", schoolDate);
    }


}
