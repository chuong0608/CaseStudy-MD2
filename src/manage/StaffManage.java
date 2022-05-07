package manage;

import interfaces.InterfaceGenara;
import interfaces.InterfaceStaff;
import model.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffManage implements InterfaceGenara<Staff>, InterfaceStaff<Staff> {
    List<Staff> staffList =  new ArrayList<>();

    public StaffManage() {
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
    public void edit(int id, Staff staff) {
        staffList.set(findById(id),staff);
    }

    @Override
    public void delete(int id) {
        staffList.remove(findById(id));

    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if(staffList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void printAll() {
        for (Staff s: staffList
             ) {
            System.out.println(s);
        }

    }

    @Override
    public void checkStatus(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getNameStaff().contains(name)){
                System.out.println(staffList.get(i).getStatus());
            }
        }
    }

    @Override
    public void printByType(String type) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals(type)){
                System.out.println(staffList.get(i));
            }
        }

    }

    @Override
    public void printDiligence(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals(name)){
                System.out.println(staffList.get(i).getNumberOfWorkDay());
            }
        }

    }

    @Override
    public void findByName(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getNameStaff().contains(name)){
                System.out.println(staffList.get(i));
            }
        }
    }
}
