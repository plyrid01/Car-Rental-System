import java.util.Scanner;

public class Rent_A_Car {
    public static void main(String[] args) {
        Car[] car = new Car[10];
        Client[] client = new Client[10];
        int totalCars = 0;
        int totalClients = 0;
        int choice;
        Scanner intScanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Choice ---\n 1 For Adding Cars\n 2 For Renting Cars\n 3 For Giving Back Car\n4 For EXIT");
            choice = intScanner.nextInt();

            if (choice == 1) {
                car[totalCars] = new Car();

                System.out.println("Enter Car Model");
                car[totalCars].model = scanner.nextLine();

                System.out.println("Enter Car Number");
                car[totalCars].setCarNumber(scanner.nextLine());

                System.out.println("Enter Price");
                car[totalCars].price = intScanner.nextInt();

                car[totalCars].isAvailable = true;
                totalCars++;
            } else if (choice == 2) {
                System.out.println("Available Cars Are ---");
                for (int i = 0; i < totalCars; i++) {
                    if (car[i].isAvailable) {
                        System.out.println("------------------------");
                        System.out.println("Car Model : " + car[i].model + "\nCar Number : " + car[i].getCarNumber()
                                + "\nPrice : Rs. " + car[i].price + "\nCar ID : " + Integer.toString(i));
                        System.out.println("------------------------");
                    }
                }
                System.out.println("Enter ID of Your Desired Car : ");
                car[intScanner.nextInt()].isAvailable = false;

                client[totalClients] = new Client();

                System.out.println("Enter Your Adhar Number");
                client[totalClients].setAdharNumber(scanner.nextLine());

                System.out.println("Enter Mobile Number ");
                client[totalClients].mob = scanner.nextLine();

                client[totalClients].carNumber = car[totalCars - 1].getCarNumber();

                System.out.println("Enter hours of Renting");
                client[totalClients].payment = intScanner.nextInt() * car[totalCars - 1].price;

                System.out.println("Cost : " + Integer.toString(client[totalClients].payment));
                totalClients++;
            }

            else if(choice==3){
                System.out.println("Enter Car ID ");
                car[intScanner.nextInt()].isAvailable=true;
                totalClients--;
            }

            else if(choice==4){
                break;
            }
        }
    }
}

class Car {
    private String numb;
    public String model;
    public boolean isAvailable;
    public int price;

    public void setCarNumber(String carNumber) {
        numb = carNumber;
    }

    public String getCarNumber() {
        return numb;
    }
}

class Client {
    private String adharNo;
    public String mob;
    public String carNumber;
    public int payment;

    public void setAdharNumber(String adharNumber) {
        adharNo = adharNumber;
    }

    public String getAdharNumber() {
        return adharNo;
    }
}
