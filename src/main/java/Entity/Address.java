package Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.Internal;

@Embeddable
public class Address {
    private String houseNo;
    private String address;
    private String city;

    public Address() {
    }

    public Address(String houseNo, String address, String city) {
        this.houseNo = houseNo;
        this.address = address;
        this.city = city;
    }

    public String gethouseNo() {
        return houseNo;
    }

    public void sethouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getAdd() {
        return address;
    }

    public void setAdd(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
