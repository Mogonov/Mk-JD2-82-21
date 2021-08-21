package by.it_academy.jd2.Mk_JD2_82_21.Person.dto;

public class PersonDTO {
    private final String name;
    private final String lastName;
    private final int age;


    public PersonDTO(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
