import java.util.*;

class ReservationSystem {
    private static Map<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your login id: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Add your authentication logic here (e.g., check against a database)

        // For demonstration purposes, let's assume the authentication is successful
        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Reservation Form");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationForm();
                    break;
                case 2:
                    cancellationForm();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void reservationForm() {
        Scanner scanner = new Scanner(System.in);

        // Collect necessary details for reservation
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        // Assume trainName is fetched from a database based on trainNumber
        String trainName = getTrainName(trainNumber);
        System.out.print("Enter class type: ");
        String classType = scanner.next();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.next();
        System.out.print("Enter source station: ");
        String source = scanner.next();
        System.out.print("Enter destination station: ");
        String destination = scanner.next();

        // Save the reservation details to the central database
        String pnr = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(name, trainNumber, trainName, classType, dateOfJourney, source, destination);
        reservations.put(pnr, reservation);

        System.out.println("Reservation successful. Your PNR number is: " + pnr);
    }

    public static void cancellationForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PNR number: ");
        String pnr = scanner.next();

        if (reservations.containsKey(pnr)) {
            Reservation reservation = reservations.get(pnr);
            System.out.println("Passenger Name: " + reservation.getName());
            System.out.println("Train Number: " + reservation.getTrainNumber());
            System.out.println("Train Name: " + reservation.getTrainName());
            System.out.println("Class Type: " + reservation.getClassType());
            System.out.println("Date of Journey: " + reservation.getDateOfJourney());
            System.out.println("Source Station: " + reservation.getSource());
            System.out.println("Destination Station: " + reservation.getDestination());

            System.out.print("Do you want to cancel this reservation? (Enter 'Y' for Yes, 'N' for No): ");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("Y")) {
                reservations.remove(pnr);
                System.out.println("Reservation with PNR " + pnr + " cancelled successfully.");
            }
        } else {
            System.out.println("Invalid PNR number. Please try again.");
        }
    }

    public static String getTrainName(int trainNumber) {
        // Assume this method fetches the train name from a database based on train number
        // For demonstration purposes, let's return a dummy value
        return "Sample Train";
    }
}

class Reservation {
    private String name;
    private int trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String source;
    private String destination;

    public Reservation(String name, int trainNumber, String trainName, String classType, String dateOfJourney, String source, String destination) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.source = source;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}
