import java.util.ArrayList;

class Pet {
    public enum PetType {
        DOG("Собака"),
        CAT("Кошка");

        private final String description;

        PetType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    String name;
    int age;
    PetType petType;

    public Pet(String name, int age, PetType petType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
    }

    void displayInfo() {
        System.out.println("Имя: " + name + "\nВозраст: " + age + "\nТип: " + petType.getDescription());
    }
}

class Dog extends Pet {
    String breed;

    public Dog(String name, int age, String breed) {
        super(name, age, PetType.DOG);
        this.breed = breed;
    }

    @Override
    void displayInfo() {
        System.out.println("Имя: " + name + "\nВозраст: " + age + "\nТип: " + petType.getDescription() + "\nПорода: " + breed);
    }
}

class Cat extends Pet {
    String color;

    public Cat(String name, int age, String color) {
        super(name, age, PetType.CAT);
        this.color = color;
    }

    @Override
    void displayInfo() {
        System.out.println("Имя: " + name + "\nВозраст: " + age + "\nТип: " + petType.getDescription() + "\nЦвет: " + color);
    }
}

class PetClinic {
    ArrayList<Pet> pets;

    public PetClinic() {
        this.pets = new ArrayList<>();
    }

    void addPet(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Нельзя добавить пустого питомца.");
        }
        for (Pet existingPet : pets) {
            if (existingPet.name.equals(pet.name)) {
                throw new IllegalArgumentException("Питомец с таким именем уже существует: " + pet.name);
            }
        }
        pets.add(pet);
    }

    void displayPets() {
        for (Pet pet : pets) {
            pet.displayInfo();
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        PetClinic clinic = new PetClinic();

        try {
            Dog dog1 = new Dog("Бобик", 3, "Шерстяная");
            Cat cat1 = new Cat("Мурка", 2, "Черный");

            clinic.addPet(dog1);
            clinic.addPet(cat1);

            Dog dog2 = new Dog("Бобик", 5, "Лабрадор");
            clinic.addPet(dog2);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Выводим оставшихся питомцев
        System.out.println("\nСписок питомцев в клинике:");
        clinic.displayPets();
    }
}

