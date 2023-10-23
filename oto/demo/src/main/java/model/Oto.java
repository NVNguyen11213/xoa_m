package model;

public class Oto {
    private int id;
    private String name;
    private String company;
    private int yearOfProduction;
    private boolean delete;

    public Oto(int id, String name, String company, int yearOfProduction) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.yearOfProduction = yearOfProduction;
        this.delete = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Oto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
