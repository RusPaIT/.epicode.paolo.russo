package es3d2;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Pino Lino", "555-555-5555");
        phoneBook.addContact("Gino Biricchino", "555-555-5556");
        phoneBook.addContact("Anna Panna", "555-555-5557");

        System.out.println("Contatto con nome Pino Lino: " + phoneBook.findByName("Pino Lino"));
        System.out.println("Contatto con numero 555-555-5556: " + phoneBook.findByPhoneNumber("555-555-5556"));

        phoneBook.removeContact("Anna Panna");
        System.out.println("Contatti dopo la rimozione di Anna Panna:");
        phoneBook.printContacts();
    }
}

