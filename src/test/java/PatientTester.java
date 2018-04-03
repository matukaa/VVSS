import controller.DoctorController;
import exceptions.PatientException;
import model.Patient;
import org.junit.Test;
import repository.Repository;

public class PatientTester {

    DoctorController controller;

    public PatientTester(){
        controller = new DoctorController(new Repository("FilePatients.txt", "FileConsultations.txt"));
    }

    @Test
    void testAddValidPatient() {
        try {
            assert(controller.addPatient(new Patient("Name1", "1234567899999", "Address1")));
        } catch (PatientException e) {
            assert(false);
        }
    }

    @Test
    void testAddInvalidPatient() {
        try {
            assert(!controller.addPatient(new Patient("Name1", "123412", "Address1")));
        } catch (PatientException e) {
            assert(false);
        }
    }
}
