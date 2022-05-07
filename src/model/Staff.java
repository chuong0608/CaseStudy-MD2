package model;

public class Staff {
    private int id;
    private String nameStaff;
    private String ageStaff;
    private long CMND;
    private String type;
    private String status;
    private String address;
    private int numberOfWorkDay;
    private long monthlySalary;

    public Staff(int id, String nameStaff, String ageStaff,
                 long CMND, String type, String status, String address, int numberOfWorkDay,
                  long monthlySalary) {
        this.id = id;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.CMND = CMND;
        this.type = type;
        this.status = status;
        this.address = address;
        this.numberOfWorkDay = numberOfWorkDay;
        this.monthlySalary = monthlySalary;
    }

    public Staff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getAgeStaff() {
        return ageStaff;
    }

    public void setAgeStaff(String ageStaff) {
        this.ageStaff = ageStaff;
    }

    public long getCMND() {
        return CMND;
    }

    public void setCMND(long CMND) {
        this.CMND = CMND;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfWorkDay() {
        return numberOfWorkDay;
    }

    public void setNumberOfWorkDay(int numberOfWorkDay) {
        this.numberOfWorkDay = numberOfWorkDay;
    }
    public long getMonthlySalary() {
        if(type.equals("thợ chính")) {
            return numberOfWorkDay * 350000;
        }
        else if(type.equals("thợ phụ")){
            return numberOfWorkDay*250000;
        }
        return 0;
    }

    @Override
    public String toString() {
        return id +
                "," + nameStaff +
                "," + ageStaff + '\'' +
                "," + CMND +
                "," + type +
                "," + address +
                "," + numberOfWorkDay +
                "," + monthlySalary +
                '\n';
    }
}
