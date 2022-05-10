package menu;

import file.FileAccountCSV;
import file.FileStaffCSV;
import manage.AccountManage;
import manage.StaffManage;
import model.Account;
import model.Staff;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        AccountManage accountManage = new AccountManage();
        StaffManage staffManage = new StaffManage();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("-----------Menu----------");
            System.out.println("1.       Đăng nhập       ");
            System.out.println("2.        Đăng kí        ");
            System.out.println("Nhập lựa chọn !    ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Đăng nhập ");
                    System.out.println("Nhập vào tên tài khoản ");
                    String name = scanner.nextLine();
                    System.out.println("Nhập vào password ");
                    String pass = scanner.nextLine();
                    accountManage.login(name, pass);
                    if (accountManage.login(name, pass) == 1) {
                        if (AccountManage.currentAccount.getRole().equalsIgnoreCase("Admin")) {
                            try {
                                do {
                                    System.out.println("╔===================================================╗");
                                    System.out.println("║       ▂ ▃ ▅ ▆ █ QUẢN LÝ NHÂN VIÊN █ ▆ ▅ ▃ ▂       ║");
                                    System.out.println("╠===================================================╣");
                                    System.out.println("║>[1]. Thêm nhân viên                               ║");
                                    System.out.println("║>[2]. Tìm kiếm nhân viên                           ║");
                                    System.out.println("║>[3]. Xóa nhân viên                                ║");
                                    System.out.println("║>[4]. Hiển thị danh sách nhân viên                 ║");
                                    System.out.println("║>[5]. Kiểm tra trạng thái nhân viên                ║");
                                    System.out.println("║>[6]. Sửa thông tin nhân viên                      ║");
                                    System.out.println("║>[7]. Đổi mật khẩu                                 ║");
                                    System.out.println("║>[0]. Logout                                        ║");
                                    System.out.println("╚===================================================╝");
                                    System.out.println("[\uD83D\uDD11] Nhập lựa chọn:");
                                    int choice1 = scanner.nextInt();
                                    if (choice1 < 0 || choice1 > 7) {
                                        System.out.println();
                                        System.out.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                                        System.out.println("--------------------");
                                        System.out.println();
                                    }
                                    switch (choice1) {
                                        case 1:

                                            System.out.println("Nhập id: ");
                                            int id = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nhập tên nhân viên : ");
                                            String nameStaff = scanner.nextLine();
                                            System.out.println("Nhập tuổi nhân viên : ");
                                            int ageStaff = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nhập vào số CMND/CCCD : ");
                                            String identity = scanner.nextLine();
                                            System.out.println("Nhập loại công việc :  ");
                                            String type = scanner.nextLine();
                                            System.out.println("Nhập trạng thái làm việc : ");
                                            String status = scanner.nextLine();
                                            System.out.println("Nhập địa chỉ : ");
                                            String address = scanner.nextLine();
                                            System.out.println("Nhập số ngày đi làm : ");
                                            int numberOfWorkDay = scanner.nextInt();
                                            staffManage.add(new Staff(id, nameStaff, ageStaff, identity, type, status, address, numberOfWorkDay));
                                            FileStaffCSV.writeToFile(staffManage.getStaffList());
                                            break;
                                        case 2:
                                            System.out.println("Nhập nhân viên muốn tìm kiếm : ");
                                            String nameFind = scanner.nextLine();
                                            staffManage.printByName(nameFind);
                                            break;
                                        case 3:
                                            System.out.println("Nhập tên nhân viên muốn xóa:");
                                            String nameDelete = scanner.nextLine();
                                            staffManage.delete(nameDelete);
                                            break;
                                        case 4:
                                            staffManage.printAll();
                                            break;
                                        case 5:
                                            System.out.println("Nhập tên nhân viên muốn kiểm tra:");
                                            String checkStatus = scanner.nextLine();
                                            staffManage.checkStatus(checkStatus);
                                            break;
                                        case 6:
                                            System.out.println("Nhập tên nhân viên muốn sửa:");
                                            String nameEdit = scanner.nextLine();
                                            System.out.println("Nhập id: ");
                                            int idEdit = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nhập tên nhân viên : ");
                                            String nameStaffEdit = scanner.nextLine();
                                            System.out.println("Nhập tuổi nhân viên : ");
                                            int ageStaffEdit = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Nhập vào số CMND/CCCD : ");
                                            String identityEdit = scanner.nextLine();
                                            System.out.println("Nhập loại công việc :  ");
                                            String typeEdit = scanner.nextLine();
                                            System.out.println("Nhập trạng thái làm việc : ");
                                            String statusEdit = scanner.nextLine();
                                            System.out.println("Nhập địa chỉ : ");
                                            String addressEdit = scanner.nextLine();
                                            System.out.println("Nhập số ngày đi làm : ");
                                            int numberOfWorkDayEdit = scanner.nextInt();
                                            staffManage.edit(nameEdit, new Staff(idEdit, nameStaffEdit, ageStaffEdit,
                                                    identityEdit, typeEdit, statusEdit, addressEdit, numberOfWorkDayEdit));
                                            FileStaffCSV.writeToFile(staffManage.getStaffList());
                                            break;
                                        case 7:
                                            System.out.println("Đổi mật khẩu ");
                                            scanner.nextLine();
                                            String newPass = scanner.nextLine();
                                            AccountManage.currentAccount.setPassword(newPass);
                                            System.out.println("Đổi mật khẩu thành công ! ");
                                            FileStaffCSV.writeToFile(staffManage.getStaffList());
                                            break;
                                        case 0:
                                            AccountManage.currentAccount = null;
                                    }
                                } while (true);
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println();
                                System.out.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
                                System.out.println("--------------------");
                                System.out.println();
                            }
                        } else {
                            try {
                                do {
                                    System.out.println("╔===================================================╗");
                                    System.out.println("║       ▂ ▃ ▅ ▆ █ MENU NHÂN VIÊN █ ▆ ▅ ▃ ▂          ║");
                                    System.out.println("╠===================================================╣");
                                    System.out.println("║>[1]. Xem thông tin tài khoản                      ║");
                                    System.out.println("║>[2]. Sửa thông tin                                ║");
                                    System.out.println("║>[3]. Đổi mật khẩu                                 ║");
                                    System.out.println("║>[0]. Thoát                                        ║");
                                    System.out.println("╚===================================================╝");
                                    System.out.println("[\uD83D\uDD11] Nhập lựa chọn:");
                                    int choice1 = scanner.nextInt();
                                    if (choice1 < 0 || choice1 > 7) {
                                        System.out.println();
                                        System.out.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                                        System.out.println("--------------------");
                                        System.out.println();
                                    }
                                    switch (choice1) {
                                        case 1:{
                                            System.out.println("Nhập tên nhân viên");
                                            String nameStaff = scanner.nextLine();
                                            accountManage.findByNameAccount(nameStaff);
                                        }
                                        case 2: {
                                            System.out.println("Nhập  số điện thoại mới");
                                            scanner.nextLine();
                                            String numberPhone= scanner.nextLine();
                                            AccountManage.currentAccount.setNumberPhone(numberPhone);
                                            System.out.println("Nhập email mới");
                                            String newEmail = scanner.nextLine();
                                            AccountManage.currentAccount.setFullname(newEmail);
                                            System.out.println("Nhập  họ tên mới");
                                            String newName= scanner.nextLine();
                                            AccountManage.currentAccount.setFullname(newName);
                                            FileAccountCSV.writeToFile(accountManage.getAccountList());
                                        }
                                        case 3:{
                                            System.out.println("Đổi mật khẩu ");
                                            scanner.nextLine();
                                            String newPass = scanner.nextLine();
                                            AccountManage.currentAccount.setPassword(newPass);
                                            System.out.println("Đổi mật khẩu thành công ! ");
                                            FileStaffCSV.writeToFile(staffManage.getStaffList());
                                            break;
                                        }
                                        case 0:{
                                            AccountManage.currentAccount=null;
                                        }
                                    }
                                }while (true);
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println();
                                System.out.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
                                System.out.println("--------------------");
                                System.out.println();
                            }
                        }
                    }

                    break;
                case 2:
                    System.out.println("Đăng ký ");
                    System.out.println("Nhập vào tên tài khoản ");
                    String nameAccount = scanner.nextLine();
                    System.out.println("Nhập vào password ");
                    String password = scanner.nextLine();
                    System.out.println("Nhập vào số điện thoại ");
                    String numberPhone = scanner.nextLine();
                    System.out.println("Nhập vào email ");
                    String email = scanner.nextLine();
                    System.out.println("Nhập vào họ tên ");
                    String fullname = scanner.nextLine();
                    System.out.println("Nhập vào tuổi ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập vào quyền truy cập ");
                    String role = scanner.nextLine();
                    Account account = new Account(nameAccount, password, numberPhone, email, fullname, age, role);
                    accountManage.add(account);
                    System.out.println("Đăng ký thành công");
                    FileAccountCSV.writeToFile(accountManage.getAccountList());
                    break;
            }
        }

    }
}

