package dto;

/**
 * Class representing owner.
 */
public class OwnerDTO {

    private String name;
    private int mobileNumber; // TODO: Verify type
    private String password; // TODO: Verify type

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}