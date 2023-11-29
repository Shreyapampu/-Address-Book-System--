package Java_Programming;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;


    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String getName(){
        return name;
    }


    public String getPhoneNumber(){
        return phoneNumber;
    }


    public String getEmail(){
        return email;
    }


    public String toString(){
        return "Name: " + name + ",Phone: " + phoneNumber + ",Email: " + email;
    }
}


class  AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();


    public void addContact(Contact contact){
        contacts.add(contact);
    }


    public void removeContact(String name){
        contacts.removeIf(contact -> contact.getName().equals(name));
    }


    public Contact searchContact(String name){
        for(Contact contact : contacts){
            if (contact.getName().equals(name)) {
               return contact; 
            }
        }
        return null;
    }


    public void displayAllContacts(){
        for(Contact contact : contacts){
             System.out.println(contact);
        }
    }

    
}

public class AddressBookSystem {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        try (Scanner scanner = new Scanner(System.in)) {
            while(true){
                System.out.println("\nAddress Book Manu: ");
                System.out.println("1. Add a new contact ");
                System.out.println("2. Remove a contact ");
                System.out.println("3. Search for a contact ");
                System.out.println("4. Display all contacts ");
                System.out.println("5. Exit ");


                System.out.println("Enter your choice (1-5): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter phone number: ");
                        String phoneNumber =scanner.nextLine();
                        System.out.println("Enter email address: ");
                        String email = scanner.nextLine();


                        if (!name.isEmpty() && !phoneNumber.isEmpty() && !email.isEmpty()) {
                            Contact newContact = new Contact(name, phoneNumber, email);
                            addressBook.addContact(newContact);        
                        } else {
                            System.out.println("Invalid input. All fields must be non-empty. ");
                        }
                        
                        break;


                    case 2:
                        System.out.println("Enter the name of the contact to remove : ");
                        String nameToRemove = scanner.nextLine();
                        addressBook.removeContact(nameToRemove);
                        break;


                    case 3:
                        System.out.println("Enter the name of the contact to search: ");
                        String nameToSearch = scanner.nextLine();
                        Contact foundContact = addressBook.searchContact(nameToSearch);
                        if (foundContact != null) {
                            System.out.println("Contact found: " + foundContact);
                        } else {
                            System.out.println("Contact not found. ");
                        }
                    
                        break;

                    case 4:
                        System.out.println("All contacts ");
                        addressBook.displayAllContacts();
                        break;


                    case 5:
                        System.out.println("Exiting Address Book. Goodbye! ");
                        System.exit(0);
                
                    default:
                        System.out.println("Invalid choice. please enter a number between 1 to 5. ");
                }

            }
        }
    }
}
