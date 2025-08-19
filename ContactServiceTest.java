package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setup() {
        service = new ContactService();
        contact = new Contact("001", "Alice", "Smith", "1112223333", "456 Oak Ave");
        service.addContact(contact);
    }

    @Test
    public void testAddContactSuccess() {
        Contact newContact = new Contact("002", "Bob", "Brown", "9998887777", "789 Pine St");
        service.addContact(newContact);
        assertDoesNotThrow(() -> service.updateAddress("002", "New Address"));
    }

    @Test
    public void testAddDuplicateContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(new Contact("001", "New", "Name", "0000000000", "Somewhere"));
        });
    }

    @Test
    public void testDeleteContact() {
        service.deleteContact("001");
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("001", "Test"));
    }

    @Test
    public void testUpdateFields() {
        service.updateFirstName("001", "Alex");
        assertEquals("Alex", contact.getFirstName());

        service.updateLastName("001", "Johnson");
        assertEquals("Johnson", contact.getLastName());

        service.updatePhone("001", "2223334444");
        assertEquals("2223334444", contact.getPhone());

        service.updateAddress("001", "123 Maple Dr");
        assertEquals("123 Maple Dr", contact.getAddress());
    }
}
