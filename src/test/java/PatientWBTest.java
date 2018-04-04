import controller.DoctorController;
import org.junit.Test;
import repository.Repository;

public class PatientWBTest {
    DoctorController controller;

    public PatientWBTest(){
        controller = new DoctorController(new Repository("FilePatients.txt", "FileConsultations.txt"));
    }

    @Test
    public void testCase1(){
        assert(true);
    }

    @Test
    public void testCase2(){
        assert(true);
    }
}
