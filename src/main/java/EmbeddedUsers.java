import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class EmbeddedUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surName;
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITYNAME")),
            @AttributeOverride(name = "house", column = @Column(name = "HOUSE")),
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET"))})
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITYNAME")),
            @AttributeOverride(name = "house", column = @Column(name = "OFFICE_NUMBER")),
            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_ROAD"))})
    private  Address office;
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {


        this.name = name;
    }

    public String getSurName() {

        return surName;
    }

    public void setSurName(String surName) {

        this.surName = surName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Address getAddress() {

        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getOffice() {
        return office;
    }

    public void setOffice(Address office) {
        this.office = office;
    }
}
