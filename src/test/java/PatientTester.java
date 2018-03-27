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
    void testAddValidPatient() throws PatientException {
        assert(controller.addPatient(new Patient("Name1", "1234567899999", "Address1")));
    }

    @Test
    void testAddInvalidPatient() throws PatientException {
        assert(!controller.addPatient(new Patient("Name1", "123412", "Address1")));
    }
}
