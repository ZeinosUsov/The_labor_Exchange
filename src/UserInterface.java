/*управление и взаимодействием с пользователем.*/

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final FileHandler fileHandler;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.fileHandler = new FileHandler();
    }

    public void start() {
        while (true) {
            System.out.println("1. Добавить вакансию");
            System.out.println("2. Искать");
            System.out.println("3. Удалить вакансию");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // потребляем новую строку

            switch (choice) {
                case 1:
                    addUnemployed();
                    break;
                case 2:
                    searchUnemployed();
                    break;
                case 3:
                    removeUnemployed();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Некорректный ввод.");
            }
        }
    }

    private void addUnemployed() {
        System.out.print("Введите профессию: ");
        String profession = scanner.nextLine();

        System.out.print("Введите образование: ");
        String education = scanner.nextLine();

        System.out.print("Введите место и должность последней работы: ");
        String lastJob = scanner.nextLine();

        System.out.print("Введите причину увольнения: ");
        String reasonForDismissal = scanner.nextLine();

        System.out.print("Введите семейное положение: ");
        String maritalStatus = scanner.nextLine();

        System.out.print("Введите жилищные условия: ");
        String livingConditions = scanner.nextLine();

        System.out.print("Введите контактные координаты: ");
        String contactInfo = scanner.nextLine();

        System.out.print("Введите требования к будущей работе: ");
        String jobRequirements = scanner.nextLine();

        Unemployed unemployed = new Unemployed(profession, education, lastJob, reasonForDismissal,
                maritalStatus, livingConditions, contactInfo, jobRequirements);
        fileHandler.saveUnemployed(unemployed);
        System.out.println("Вакансия добавлена.");
    }

    private void searchUnemployed() {
        System.out.print("Введите критерий для поиска: ");
        String query = scanner.nextLine();
        List<Unemployed> found = fileHandler.searchUnemployed(query);

        if (found.isEmpty()) {
            System.out.println("Вакансия не найдена.");
        } else {
            for (Unemployed u : found) {
                System.out.println(u);
            }
        }
    }

    private void removeUnemployed() {
        System.out.print("Введите контактные координаты для удаления: ");
        String contactInfoToRemove = scanner.nextLine();
        fileHandler.removeUnemployed(contactInfoToRemove);
        System.out.println("Вакансия с указанными контактными координатами удалена.");
    }
}




