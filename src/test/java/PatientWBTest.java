import controller.DoctorController;
import org.junit.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class PatientWBTest {
    DoctorController controller;

    public PatientWBTest(){
        controller = new DoctorController(new Repository("FilePatients.txt", "FileConsultations.txt"));
    }

    @Test // Test invalid consultation
    public void testCase1(){
        List<String> meds = new ArrayList<String>();
        meds.add("Ibuprofen");
        assert(!controller.addConsultation("69", "123456789123", "Diag1", meds, "02/02/2016"));
    }

    @Test // Test valid consultation
    public void testCase2(){
        List<String> meds = new ArrayList<String>();
        meds.add("Ibuprofen");
        assert(controller.addConsultation("69", "1234567891234", "Diag1", meds, "02/02/2016"));
    }
}
