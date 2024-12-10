/*управляет операциями с файлами.*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "unemployed.txt";

    public void saveUnemployed(Unemployed unemployed) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(unemployed.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    public List<Unemployed> searchUnemployed(String query) {
        List<Unemployed> found = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Unemployed unemployed = Unemployed.fromString(line);
                if (unemployed.profession.contains(query) ||
                        unemployed.education.contains(query) ||
                        unemployed.lastJob.contains(query) ||
                        unemployed.reasonForDismissal.contains(query) ||
                        unemployed.maritalStatus.contains(query) ||
                        unemployed.livingConditions.contains(query) ||
                        unemployed.contactInfo.contains(query) ||
                        unemployed.jobRequirements.contains(query)) {
                    found.add(unemployed);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return found;
    }

    public void removeUnemployed(String contactInfoToRemove) {
        List<Unemployed> unemployedList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Unemployed unemployed = Unemployed.fromString(line);
                if (!unemployed.contactInfo.equals(contactInfoToRemove)) {
                    unemployedList.add(unemployed);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Unemployed u : unemployedList) {
                writer.write(u.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}

