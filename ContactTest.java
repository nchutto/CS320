package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Elm");
        });
    }

    @Test
    public void testInvalidPhoneLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234", "123 Elm");
        });
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }
}
