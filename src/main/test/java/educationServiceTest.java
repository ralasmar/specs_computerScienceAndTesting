package main.test.java;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

public class educationServiceTest {

    public Object MockitoJUnit;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private StudentDataObject studentDataObject;

    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;

    @Test
    public void testStudentsByClass(){
        //given
        Student studentJM = new Student("Joy Ma", "Spanish");
        Student studentJH = new Student("Julio Hernandez", "Algebra");
        Student studentJJ = new Student("Jenny Jones", "Calculus");
        List<Object> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);
        given(studentDataObject.getAllStudents()).willReturn(allStudents);
        //when
        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject("math");
        //then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJJ, studentJH));
    }

    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

    @Test
    public void testMarkInactive(){
        //given
        Class geometry = new Class("Geometry", "Summer 2022");
        Class envSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        //when
        clientBusinessObjectImpl.markCurrentClassesInactive();

        //then
        verify(classDataObject.markInactive(geometry));
        assertEquals(geometry, classArgumentCaptor.getValue());

//        verify(classDataObject, Mockito.never()).markInactive(envSci);
//        verify(classDataObject, Mockito.never().markInactive(compLit));
//        verify(classDataObject, Mockito.times(1).markInactive(geometry));


    }

}
