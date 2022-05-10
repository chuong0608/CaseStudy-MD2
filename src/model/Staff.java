package model;

public class Staff {
    private int id;
    private String nameStaff;
    private int ageStaff;
    private String cmnd;
    private String type;
    private String status;
    private String address;
    private int numberOfWorkDay;
    private Double monthlySalary;

    public Staff(int id, String nameStaff, int ageStaff,
                 String cmnd, String type, String status, String address,
                 int numberOfWorkDay) {
        this.id = id;
        this.nameStaff = nameStaff;
        this.ageStaff = ageStaff;
        this.cmnd = cmnd;
        this.type = type;
        this.status = status;
        this.address = address;
        this.numberOfWorkDay = numberOfWorkDay;
        this.monthlySalary = 1d;
        if (this.type.equalsIgnoreCase("thợ chính")) {
            this.monthlySalary = (double) (this.numberOfWorkDay * 350000);
        } else if (this.type.equalsIgnoreCase("thợ phụ")) {
            this.monthlySalary = (double) (this.numberOfWorkDay * 250000);
        }

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

    public int getAgeStaff() {
        return ageStaff;
    }

    public void setAgeStaff(int ageStaff) {
        this.ageStaff = ageStaff;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
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

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return id +
                "," + nameStaff +
                "," + ageStaff +
                "," + cmnd +
                "," + type +
                "," + status +
                "," + address +
                "," + numberOfWorkDay +
                "," + monthlySalary +
                '\n';
    }
}
