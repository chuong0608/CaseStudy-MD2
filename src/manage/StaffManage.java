package manage;

import file.FileStaffCSV;
import interfaces.InterfaceGenara;
import interfaces.InterfaceStaff;
import model.Staff;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffManage implements InterfaceGenara<Staff>, InterfaceStaff<Staff> {
    List<Staff> staffList = new ArrayList<>();

    public StaffManage() throws FileNotFoundException {
        staffList = FileStaffCSV.readFormFile();

    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }


    @Override
    public void add(Staff staff) {
        staffList.add(staff);
    }

    @Override
    public void edit(String name, Staff staff) {
        staffList.set(findByName(name), staff);
    }

    @Override
    public void delete(String name) {
        staffList.remove(findByName(name));

    }

    @Override
    public int findByName(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getNameStaff().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void printAll() {
        for (Staff s : staffList
        ) {
            System.out.println(s);
        }

    }

    @Override
    public void checkStatus(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getNameStaff().contains(name)) {
                System.out.println(staffList.get(i).getStatus());
            }
        }
    }

    @Override
    public void printByType(String type) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals(type)) {
                System.out.println(staffList.get(i));
            }
        }
    }

    @Override
    public void printDiligence(String name) {
//        for (int i = 0; i < staffList.size(); i++) {
//            if (staffList.get(i).getType().equals(name)) {
//                System.out.println(staffList.get(i).getNumberOfWorkDay());
//            }
//        }

    }

    @Override
    public void printByName(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getNameStaff().contains(name)) {
                System.out.println(staffList.get(i));
            }
        }
    }
}
