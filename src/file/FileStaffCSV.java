package file;

import model.Account;
import model.Staff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStaffCSV {
    public static void writeToFile(List<Staff> staffs) throws IOException {
        File staffFile = new File("staff.csv");
        staffFile.createNewFile();
        PrintWriter printWriter = new PrintWriter(staffFile);
        printWriter.println("id,nameStaff,ageStaff,CMND,type,status,address,numberOfWorkDay,monthlySalary");
        for (int i = 0; i < staffs.size(); i++) {
            printWriter.print(staffs.get(i));
        }
        printWriter.close();
    }
    public static List<Staff> readFormFile() throws FileNotFoundException {
        File staffFile = new File("staff.csv");
        List<Staff> staffs = new ArrayList<>();
        Scanner scanner = new Scanner(staffFile);
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            } else {
                String[] arr = line.split(",");
                staffs.add(new Staff(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), arr[3], arr[4],arr[5],
                        arr[6], Integer.parseInt(arr[7])));
            }
        }
        return staffs;
    }

}
