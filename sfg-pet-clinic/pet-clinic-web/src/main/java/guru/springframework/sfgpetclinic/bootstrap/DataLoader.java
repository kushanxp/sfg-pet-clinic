package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Kushan");
        owner.setLastName("Jayathilake");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Rangika");
        owner1.setLastName("Abeysinghe");

        ownerService.save(owner1);
        System.out.println("Owners loaded!!!");

        Vet vet = new Vet();
        vet.setId(3L);
        vet.setFirstName("Russel");
        vet.setLastName("Peters");

        Vet vet1 = new Vet();
        vet1.setId(4L);
        vet1.setFirstName("Bradd");
        vet1.setLastName("Pitt");

        System.out.println("Vets loaded!!!!");

    }
}
