import controller.DoctorController;
import exceptions.PatientException;
import model.Patient;
import org.junit.Test;
import repository.Repository;

public class PatientTest {

    DoctorController controller;

    public PatientTest(){
        controller = new DoctorController(new Repository("FilePatients.txt", "FileConsultations.txt"));
    }

    @Test
    public void testAddValidPatient() {
        try {
            assert(controller.addPatient(new Patient("Name1", "1234567899999", "Address1")));
        } catch (PatientException e) {
            assert(false);
        }
    }

    @Test
    public void testAddInvalidPatient() {
        try {
            assert(!controller.addPatient(new Patient("Name1", "123412", "Address1")));
        } catch (PatientException e) {
            assert(false);
        }
    }
}
