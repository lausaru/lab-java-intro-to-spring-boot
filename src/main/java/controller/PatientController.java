package controller;

import model.EmployeeStatus;
import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.PatientService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getDoctors() {
        return patientService.findAll();
    }

    @GetMapping("/patients/{id}")
    public Optional<Patient> findByPatientId(int patientId) {
        return patientService.findByPatientId(patientId);
    }

    @GetMapping("/patients/date_of_birth_range")
    public List<Patient> findAllByDateOfBirthBetween(Date minDate, Date maxDate) {
        return patientService.findAllByDateOfBirthBetween(minDate, maxDate);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> findAllByDoctorDepartment(String department) {
        return patientService.findAllByDoctorDepartment(department);
    }

    @GetMapping("/patients/status/{status}")
    public List<Patient> findAllByDoctorStatus(EmployeeStatus status) {
        return patientService.findAllByDoctorStatus(status);
    }
}