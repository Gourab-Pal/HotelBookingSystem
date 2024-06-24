
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        // create hotel object and scanner object
        Backend hotels = new Backend();
        Scanner hotelInput = new Scanner(System.in);

        // choice for actions
        hotels.displayActionList();

        // input the choice
        System.out.print("Enter your action choice: ");
        int choice = hotelInput.nextInt();

        // populate hotel room names
        hotels.populateHotelRoomsWithNames();

        while (true) {

            switch (choice) {
                case -1 -> {
                    hotels.abortExecution();
                    break;
                }
                case 0 -> {
                    hotels.displayHotelDetails(choice);
                    choice = hotels.callbackActionList();
                }
                case 1 -> {
                    hotels.displayRoomMatrix(choice);
                    choice = hotels.callbackActionList();
                }
                case 2 -> {
                    System.out.println();
                    System.out.println("************* How many customer to checkin? **************");
                    System.out.print("Input: ");
                    int numberCustomerCheckin = hotelInput.nextInt();
                    for (int i = 0; i < numberCustomerCheckin; i++) {
                        System.out.println();
                        System.out.println("************* Enter customer " + (i + 1) + " details ***************");
                        System.out.println();
                        System.out.print("Enter customer name: ");
                        String customerName = hotelInput.next();
                        System.out.print("Enter preferred floor: ");
                        int customerFloor = hotelInput.nextInt();
                        System.out.print("Enter preferred room name: ");
                        String customerRoomName = hotelInput.next();
                        hotels.bulkCheckIn(customerFloor + customerRoomName, customerName);
                    }
                    choice = hotels.callbackActionList();
                }
                case 3 -> {
                    hotels.getActiveBooking(choice);
                    choice = hotels.callbackActionList();
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("**************** Customer checkout portal ********************");
                    System.out.println();
                    System.out.print("Enter customer name: ");
                    String customerName = hotelInput.next();
                    hotels.checkOut(customerName);
                    choice = hotels.callbackActionList();
                }
                case 5 -> {
                    hotels.getCoinBalance(choice);
                    choice = hotels.callbackActionList();
                }
                case 6 -> {
                    System.out.println();
                    System.out.println("**************** Customer name search portal ********************");
                    System.out.println();
                    System.out.print("Enter customer room name: ");
                    String roomID = hotelInput.next();
                    hotels.getCustomerName(roomID, choice);
                    choice = hotels.callbackActionList();
                }
                case 7 -> {
                    System.out.println();
                    System.out.println("**************** Customer room search portal ********************");
                    System.out.println();
                    System.out.print("Enter customer name: ");
                    String customerName = hotelInput.next();
                    hotels.getCustomerRoomId(customerName, choice);
                    choice = hotels.callbackActionList();
                }
                default -> {
                    System.out.println("Invalid input. Try again...");
                    choice = hotels.callbackActionList();
                }
            }
        }
    }
}
