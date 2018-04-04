import controller.DoctorController;
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
        assert(controller.addPatient(new Patient("Name1", "1234567899999", "Address1")));
    }

    @Test
    public void testAddInvalidPatient() {
        assert (!controller.addPatient(new Patient("Name1", "123412", "Address1")));
    }

    @Test // TC 1
    public void testAllFieldsValid() {
        assert(controller.addPatient(new Patient("Test", "1234567891234", "TestAddress")));
    }

    @Test // TC 2
    public void testNameWithDigit(){
        assert(!controller.addPatient(new Patient("Test23", "1234567891234", "TestAddress")));
    }

    @Test // TC 3
    public void testNameEmpty(){
        assert(!controller.addPatient(new Patient("", "1234567891234", "TestAddress")));
    }

    @Test // TC 4
    public void testAddressEmpty(){
        assert(!controller.addPatient(new Patient("Test", "1234567891234", "")));
    }

    @Test // TC 5
    public void testSSNContainsLetters(){
        assert(!controller.addPatient(new Patient("Test", "123456789123A", "TestAddress")));
    }

    @Test // TC 6
    public void testSSNTooLong(){
        assert(!controller.addPatient(new Patient("Test", "1234", "TestAddress")));
    }

    @Test // TC 7
    public void testSSNTooShort(){
        assert(!controller.addPatient(new Patient("Test", "12345678912346789", "TestAddress")));
    }
}
