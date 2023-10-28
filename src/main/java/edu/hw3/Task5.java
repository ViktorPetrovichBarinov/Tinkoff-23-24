package edu.hw3;

public class Task5 {
    static class Contact {
        private final String firstName;
        private final String lastName;

        public Contact(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFullName() {
            if (lastName != null && !lastName.isEmpty()) {
                return lastName + " " + firstName;
            } else {
                return firstName;
            }
        }

        @Override
        public String toString() {
            return getFullName();
        }
    }

    public static Contact[] parseContacts(Contact[] contacts, boolean ascending) {
        Arrays.sort(contacts, Comparator.comparing((Contact c) -> c.lastName == null ? c.firstName : c.lastName)
            .thenComparing(c -> c.firstName));

        if (!ascending) {
            for (int i = 0; i < contacts.length / 2; i++) {
                Contact temp = contacts[i];
                contacts[i] = contacts[contacts.length - i - 1];
                contacts[contacts.length - i - 1] = temp;
            }
        }

        return contacts;
    }
}
