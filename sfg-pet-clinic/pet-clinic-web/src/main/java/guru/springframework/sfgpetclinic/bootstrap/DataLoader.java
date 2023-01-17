package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtiesService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petService;

    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petService.findAll().size();
        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Kushan");
        owner.setLastName("Jayathilake");
        owner.setAddress("Glen Meadow Road");
        owner.setCity("Franklin");
        owner.setTelephone("1231231231");

        Pet kushansPet = new Pet();
        kushansPet.setPetType(savedDogPetType);
        kushansPet.setOwner(owner);
        kushansPet.setDateOfBirth(LocalDate.now());
        kushansPet.setName("Banu");
        owner.getPets().add(kushansPet);

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Rangika");
        owner1.setLastName("Abeysinghe");
        owner1.setAddress("Glen Meadow Road");
        owner1.setCity("Franklin");
        owner1.setTelephone("89898989");

        Pet rangikasPet = new Pet();
        rangikasPet.setName("Meow");
        rangikasPet.setPetType(savedCatPetType);
        rangikasPet.setOwner(owner1);
        rangikasPet.setDateOfBirth(LocalDate.now());
        owner1.getPets().add(rangikasPet);


        ownerService.save(owner1);
        System.out.println("Owners loaded!!!");

        Speciality radiologySpeciality = new Speciality();
        radiologySpeciality.setDescription("Radiology");
        Speciality savedRadiologySpeciality = specialtiesService.save(radiologySpeciality);

        Speciality surgerySpeciality = new Speciality();
        surgerySpeciality.setDescription("Surgery");
        Speciality savedSurgerySpeciality = specialtiesService.save(surgerySpeciality);

        Speciality dentistrySpeciality = new Speciality();
        dentistrySpeciality.setDescription("Dentistry");
        Speciality savedDentistrySpeciality = specialtiesService.save(dentistrySpeciality);

        Vet vet = new Vet();
        vet.setFirstName("Russel");
        vet.setLastName("Peters");
        vet.getSpecialities().add(savedRadiologySpeciality);

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Bradd");
        vet1.setLastName("Pitt");
        vet1.getSpecialities().add(savedSurgerySpeciality);

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Keanu");
        vet2.setLastName("Reeves");
        vet2.getSpecialities().add(savedDentistrySpeciality);

        vetService.save(vet2);
        System.out.println("Vets loaded!!!!");
    }
}
