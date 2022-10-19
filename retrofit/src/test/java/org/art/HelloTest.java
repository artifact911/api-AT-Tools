package org.art;

import org.art.entity.School;
import org.art.retrofit.HelloManager;
import org.art.retrofit.school.SchoolManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloTest {

    HelloManager helloManager = new HelloManager();
    SchoolManager schoolManager = new SchoolManager();

    @Test
    void getHello() {
        String hello = helloManager.getHello();
        List<School> schools = schoolManager.getSchools();

        assertEquals("Hello World!", hello);
        assertTrue(schools.size() > 2);
    }
}
