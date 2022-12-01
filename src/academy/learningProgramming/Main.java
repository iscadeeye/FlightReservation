
package academy.learningProgramming;


public class Main {
    public static void main(String[] args) {

//        arrayDequeDemo array = new arrayDequeDemo();
//        array.dequeTest();

        TicketReservation ticket  = new TicketReservation();
        ticket.bookFlight("Mohamed", "Hassan", 29, "Male", "business","A1" );
        ticket.bookFlight("John", "Nouh", 29, "Male", "business","A2" );
        ticket.bookFlight("Mike", "Mitch", 29, "Male", "business","A3" );
        ticket.bookFlight("Chris", "Wallace", 29, "Male", "business","A4" );
        ticket.bookFlight("Anna", "AbdiNuur", 29, "Female", "business","A5" );
        ticket.bookFlight("Liza", "kader", 29, "Female", "business","A6" );
        ticket.bookFlight("Ahmed", "Ismail", 29, "Male", "business","A7" );
        ticket.bookFlight("Khadija", "Mohamed", 29, "Female", "business","A8" );
        ticket.bookFlight("Maryam", "Mohamed", 29, "Female", "business","A9" );
        ticket.bookFlight("Hassan", "Ismail", 29, "Male", "business","A10" );
        ticket.bookFlight("Hoodo", "Daahir", 29, "Female", "business","A11" );
        ticket.bookFlight("Fatimo", "Abdikarim", 29, "Female", "business","A12" );
        ticket.bookFlight("Shamsa", "Hassan", 29, "Female", "business","A13" );
        ticket.bookFlight("Abdale", "Hassan", 29, "Male", "business","A14" );


        ticket.cancel("A10");
        ticket.cancel("A4");

       ticket.printPassengers();




    }
}