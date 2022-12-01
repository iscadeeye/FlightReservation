package academy.learningProgramming;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private final List<Passenger> confirmedList = new ArrayList<>();
    private final Deque<Passenger> waitingList = new ArrayDeque<>();

    // This getter is used only by the junit test case.
    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    /**
     * Returns true if passenger could be added into either confirmedList or
     * waitingList. Passenger will be added to waitingList only if confirmedList
     * is full.
     * <p>
     * Return false if both passengerList & waitingList are full
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
        if (confirmedList.size() < CONFIRMEDLIST_LIMIT) {
            return confirmedList.add(passenger);

        }
        if (confirmedList.size() == CONFIRMEDLIST_LIMIT && waitingList.size() < WAITINGLIST_LIMIT) {
            waitingList.add(passenger);
            return true;
        }
        System.out.println("The size is " + confirmedList.size());
        return false;

    }

    /**
     * Removes passenger with the given confirmationNumber. Passenger could be
     * in either confirmedList or waitingList. The implementation to remove the
     * passenger should go in removePassenger() method and removePassenger method

     * <p>
     * If passenger is in confirmedList, then after removing that passenger, the
     * passenger at the front of waitingList (if not empty) must be moved into
     * passengerList.
     */
    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> passengerIterator = confirmedList.iterator();

        if (removePassenger(passengerIterator, confirmationNumber)) {
            Passenger newPassenger = waitingList.poll();
            if (newPassenger != null) {
                for ( Passenger oldPassenger : confirmedList ) {
                    if (oldPassenger.getConfirmationNumber().equals(confirmationNumber)) {
                        confirmedList.remove(oldPassenger);
                        confirmedList.add(newPassenger);
                        return true;
                    }
                }

            }
        }


        // if confirmationNumber is not in the confirmedList
        passengerIterator = waitingList.iterator();

        if (removePassenger(passengerIterator, confirmationNumber)) {
            waitingList.removeIf(passenger -> passenger.getConfirmationNumber().equals(confirmationNumber));
            return true;
        }
        return false;


    }

    /**
     * Removes passenger with the given confirmation number.
     * Returns true only if passenger was present and removed. Otherwise, return false.
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {

        while (iterator.hasNext()) {

            if (iterator.next().getConfirmationNumber().equals(confirmationNumber)) {

                return true;
            }


        }

        return false;
    }


    public void printPassengers() {
        int counter = 1;
        StringBuilder customerDetails = new StringBuilder(String.format("%-20s%-20s%s%n", "First Name", "Last Name",
                "Confirm Number"));
        System.out.println("Passengers in the Confirmed List");
        System.out.println("-----------------------------------------------------");
        for ( Passenger passenger : confirmedList ) {

            customerDetails.append(String.format("%-20s", passenger.getFirstName()));
            customerDetails.append(String.format("%-20s", passenger.getLastName()));
            customerDetails.append(String.format("%s%n", passenger.getConfirmationNumber()));
        }
        if (confirmedList.size() == 0){
            System.out.println("There are no customers in the confirm list");
        } else {
            System.out.println(customerDetails);
        }


        System.out.println("Passengers in the Wainting List");
        System.out.println("------------------------------------------");
        customerDetails = new StringBuilder(String.format("%-20s%-20s%s%n", "First Name", "Last Name",
                "Confirm Number"));

        for ( Passenger passenger: waitingList ){
            customerDetails.append(String.format("%-20s", passenger.getFirstName()));
            customerDetails.append(String.format("%-20s", passenger.getLastName()));
            customerDetails.append(String.format("%s%n", passenger.getConfirmationNumber()));
        }
        if (waitingList.size() == 0){
            System.out.println("There are no customers in the waiting list.");
        } else {
            System.out.println(customerDetails);
        }



    }

}
