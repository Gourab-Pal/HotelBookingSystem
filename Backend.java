
import java.util.HashMap;
import java.util.Scanner;

public class Backend {

    public String[][] roomMatrix;
    public int[] floorNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public String[] roomID = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
        "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public HashMap<Integer, String> actionMap = new HashMap<>();
    public HashMap<String, String> bookingMap = new HashMap<>();
    int coins = 0;

    // constructor method
    public Backend() {
        roomMatrix = new String[floorNumber.length][roomID.length];
        actionMap.put(-1, "Stop");
        actionMap.put(0, "Hotel details");
        actionMap.put(1, "Show the room matrix");
        actionMap.put(2, "Bulk checkin");
        actionMap.put(3, "Show active bookings");
        actionMap.put(4, "Single checkout");
        actionMap.put(5, "Fetch coin balance");
        actionMap.put(6, "Fetch customer name by room number");
        actionMap.put(7, "Fetch customer room number by name");
    }

    // create 2D maxtrix of hotel room names architechtute
    public String[][] populateHotelRoomsWithNames() {
        for (int i = 0; i < floorNumber.length; i++) {
            for (int j = 0; j < roomID.length; j++) {
                roomMatrix[i][j] = floorNumber[i] + roomID[j];
            }
        }
        return roomMatrix;
    }

    // options for actions
    public void displayActionList() {

        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.println("************* Welcome to Hotel Rising Star **************");
        System.out.println("******************** Date - " + java.time.LocalDate.now() + "*******************");
        System.out.println("******************* SELECT CHOICE ***********************");
        System.out.println();
        for (int key : actionMap.keySet()) {
            System.out.println(key + " --->> " + actionMap.get(key));
        }
        System.out.println();
        System.out.println("*********************************************************");
        System.out.println("---------------------------------------------------------");
        System.out.println();
    }

    //callback actionList
    public int callbackActionList() {
        displayActionList();
        System.out.print("Enter your action choice: ");
        Scanner backendSc = new Scanner(System.in);
        int choice = backendSc.nextInt();
        return choice;
    }

    // abort execution
    public void abortExecution() {
        System.out.println("Execution aborted by user...");
        System.exit(0);
    }

    // hotel details
    public void displayHotelDetails(int choiceNum) {
        System.out.println();
        System.out.println("************* Result: " + actionMap.get(choiceNum) + " **************");
        System.out.println();
        System.out.println("Hotel name -->> Hotel Rising Star");
        System.out.println("Address -->> Bengaluru");
        System.out.println("Pincode -->> 560003");
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
    }

    // display hotel room matrix
    public void displayRoomMatrix(int choiceNum) {
        System.out.println();
        System.out.println("************* Result: " + actionMap.get(choiceNum) + " **************");
        System.out.println();
        for (int i = floorNumber.length - 1; i >= 0; i--) {
            for (int j = 0; j < roomID.length; j++) {
                System.out.print(roomMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("**********************************************************");
        System.out.println();
    }

    //bulk checkin
    public void bulkCheckIn(String roomNumber, String customerName) {
        bookingMap.put(roomNumber, customerName);
        coins += 100;
    }

    //get booking details for all customers
    public void getActiveBooking(int choiceNum) {
        System.out.println();
        System.out.println("************* Result: " + actionMap.get(choiceNum) + " **************");
        System.out.println();
        if (bookingMap.isEmpty()) {
            System.out.println("No booking yet. Please perform some checkin first...");
        } else {
            for (String key : bookingMap.keySet()) {
                System.out.println("Room No. : " + key + " -->> Customer: " + bookingMap.get(key));
            }
        }
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
    }

    //checkout
    public void checkOut(String customerName) {
        int flag = 0;
        System.out.println();
        System.out.println("************* Enter customer name for checkout ****************");
        System.out.println();
        for (String key : bookingMap.keySet()) {
            if (bookingMap.get(key).equals(customerName)) {
                bookingMap.remove(key);
                flag++;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Name not found...");
        } else {
            System.out.println("Checkout successfull");
        }
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
    }

    //get coinBalance
    public void getCoinBalance(int choiceNum) {
        System.out.println();
        System.out.println("************* Result: " + actionMap.get(choiceNum) + " **************");
        System.out.println();
        System.out.println("Current coin balance: " + coins);
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
    }

    //search customer name by room number
    public void getCustomerName(String roomID, int choiceNum) {
        int flag = 0;
        System.out.println();
        System.out.println("************* Result: " + actionMap.get(choiceNum) + " **************");
        System.out.println();
        for (String key : bookingMap.keySet()) {
            if (key.equals(roomID)) {
                flag ++ ;
                System.out.println(roomID + " -->> " + bookingMap.get(key));
            }
        }
        if(flag==0){
            System.out.println("Invalid room id...");
        }
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
    }

    //search customer room number by name
    public void getCustomerRoomId(String customerName, int choiceNum) {
        int flag = 0;
        System.out.println();
        System.out.println("************* Result: " + actionMap.get(choiceNum) + " **************");
        System.out.println();
        for (String key : bookingMap.keySet()) {
            if (bookingMap.get(key).equals(customerName)) {
                flag ++ ;
                System.out.println(customerName + " -->> " + key);
            }
        }
        if(flag==0){
            System.out.println("No such customer...");
        }
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
    }
}
