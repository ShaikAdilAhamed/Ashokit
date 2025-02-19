package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
public class User_dtls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String user_name;

  
    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    
    private List<Roles_dtls> roles_dtls;

    // Getters and setters
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public List<Roles_dtls> getRoles_dtls() {
        return roles_dtls;
    }

    public void setRoles_dtls(List<Roles_dtls> roles_dtls) {
        this.roles_dtls = roles_dtls;
    }
}
