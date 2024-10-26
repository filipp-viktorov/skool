package sk.viktorov.skool.homework.file_operations;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public void printDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("The path provided is not a directory.");
        }
    }

    public boolean writeUserInputToFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter file name: ");
            String fileName = reader.readLine();
            System.out.print("Enter content: ");
            String content = reader.readLine();

            String[] words = content.split(" ");
            StringBuilder formattedContent = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                formattedContent.append(words[i]);
                if ((i + 1) % 4 == 0) {
                    formattedContent.append("\n");
                } else {
                    formattedContent.append(" ");
                }
            }

            Files.write(Paths.get(fileName), formattedContent.toString().getBytes());

            readFromFile(fileName);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean areTextFilesEqual(String filePath1, String filePath2) {
        try {
            List<String> file1Lines = Files.readAllLines(Paths.get(filePath1));
            List<String> file2Lines = Files.readAllLines(Paths.get(filePath2));

            return file1Lines.equals(file2Lines);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean invertFile(String filepath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filepath));
            List<String> invertedLines = new ArrayList<>();
            for (String line : lines) {
                invertedLines.add(new StringBuilder(line).reverse().toString());
            }

            String invertedFilePath = "inverted_" + Paths.get(filepath).getFileName().toString();
            Files.write(Paths.get(invertedFilePath), invertedLines);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
