package tn.esprit.spring.services;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.*;


import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeServiceTest {
    @Autowired
    IEmployeService employeeService;
    @Autowired
    EntrepriseRepository enterpriseRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    ContratRepository contratRepository;


    Entreprise entreprise;
    Contrat contract_1, contract_2, contract_3;
    Departement department_1;
    Employe employee_2 = new Employe("Ala", "Hamrouni", "Hamrouni.ala@esprit.tn", true, Role.INGENIEUR);
    Employe employee_1 = new Employe("Ghada", "Ayadi", "ghada-ayadi@mail.com", true, Role.INGENIEUR);
    Employe employee_3 = new Employe("zaineb", "Hamdouch", "Zaineb@Hamdouch.tn", true, Role.CHEF_DEPARTEMENT);

    @Test
    void getNombreEmployeJPQL() {
        int count = employeeService.getNombreEmployeJPQL();
        if (count == 0)
            employeeService.ajouterEmploye(employee_1);
        Assert.assertNotEquals(40, count);
    }
    @Test
    void getAllEmployeByEntreprise() {
        entreprise = new Entreprise("Accretio", "Accretio France");
        department_1 = new Departement("Mobile", employeeService.getAllEmployes(), entreprise);
        entreprise.addDepartement(department_1);
        enterpriseRepository.save(entreprise);
        departementRepository.save(department_1);
        List<Employe> actual_employee_by_enterprise = employeeService.getAllEmployeByEntreprise(entreprise);
        Assert.assertNotNull(actual_employee_by_enterprise);
    }
    @Test
    void deleteAllContratJPQL() {
        employeeService.deleteAllContratJPQL();
        long count = contratRepository.count();
        Assert.assertEquals("deleteAllContractJPQL... ", 0, count);
    }


}