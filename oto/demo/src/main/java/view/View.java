package view;

import controller.OtoController;
import model.Oto;

import java.util.Scanner;

public class View {
    private static OtoController otoController = new OtoController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Oto oto = createOto();
                    otoController.create(oto);
                    break;
                case 2:
                    System.out.println("id of oto you want update");
                    int idUpdate = scanner.nextInt();
                    Oto otoUpdate = createOto();
                    otoController.update(otoUpdate,idUpdate);
                    break;
                case 3:
                    System.out.println("id of oto you want delete");
                    int idDelete = scanner.nextInt();
                    otoController.delete(idDelete);
                    break;
                case 4:
                    otoController.getAll();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("try again");
            }
        }

    }

    private static void showMenu() {
        System.out.println("1. Add oto");
        System.out.println("2. Update oto");
        System.out.println("3. Delete oto");
        System.out.println("4. Show oto");
        System.out.println("5. Exit");
        System.out.print("Enter Your Choice: ");
    }
    public static Oto createOto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        int id = scanner.nextInt();
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("company: ");
        String company = scanner.nextLine();
        System.out.print("yearOfProduction: ");
        int yearOfProduction = scanner.nextInt();
        Oto oto = new Oto(id, name, company, yearOfProduction);
        return oto;
    }
}