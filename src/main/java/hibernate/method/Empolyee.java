package hibernate.method;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "empolyee")
public class Empolyee  {

   @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Integer empid;

    private String name;

    private String surname;


    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
