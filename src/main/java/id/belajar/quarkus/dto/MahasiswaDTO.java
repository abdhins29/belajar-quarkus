package id.belajar.quarkus.dto;

public class MahasiswaDTO {
    private String name;
    private String address;
    private String email;

    public MahasiswaDTO() {
    }

    public MahasiswaDTO(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
