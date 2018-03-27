import controller.DoctorController;
import exceptions.PatientException;
import model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientTester {

    DoctorController controller;

    @BeforeEach
    void setup(){
        controller = new DoctorController(new Repository("FilePatients.txt", "FileConsultations.txt"));
    }

    @Test
    void testAddValidPatient() throws PatientException {
        assertEquals(true, controller.addPatient(new Patient("Name1", "1234567899999", "Address1")));
    }

    @Test
    void testAddInvalidPatient() throws PatientException {
        assertEquals(false, controller.addPatient(new Patient("Name1", "123412", "Address1")));
    }
}
