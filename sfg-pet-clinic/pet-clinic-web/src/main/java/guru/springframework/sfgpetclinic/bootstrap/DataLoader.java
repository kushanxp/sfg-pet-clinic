package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("Kushan");
        owner.setLastName("Jayathilake");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Rangika");
        owner1.setLastName("Abeysinghe");

        ownerService.save(owner1);
        System.out.println("Owners loaded!!!");

        Vet vet = new Vet();
        vet.setFirstName("Russel");
        vet.setLastName("Peters");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Bradd");
        vet1.setLastName("Pitt");

        vetService.save(vet1);
        System.out.println("Vets loaded!!!!");

    }
}
