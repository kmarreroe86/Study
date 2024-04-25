package builder;

import builder.models.Person;

import static builder.models.Person.Builder.aPerson;

public class BuilderTestMain {

    public static void main(String[] args) {

        Person p = aPerson()
                .withFirstname("Lucas")
                .withLastname("Moy")
                .withPhone("123123123")
                .withEmail("lucasmoy@yahoo.com")
                .build();


        if ("Moy".equals(p.getLastname())) {
            System.out.println("Yes");
        }

    }
}
