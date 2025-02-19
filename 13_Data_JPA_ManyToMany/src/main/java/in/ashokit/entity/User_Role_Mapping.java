package in.ashokit.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
public class User_Role_Mapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "user_role_mapping", // Join table name
        joinColumns = @JoinColumn(name = "user_id"), // Foreign key to User
        inverseJoinColumns = @JoinColumn(name = "role_id") // Foreign key to Role
    )
    private List<User_dtls> user_dtls;

    @ManyToMany
    @JoinTable(
       // Same join table
        joinColumns = @JoinColumn(name = "role_id"), // Foreign key to Role
        inverseJoinColumns = @JoinColumn(name = "user_id") // Foreign key to User
    )
    private List<Roles_dtls> roles_dtls;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User_dtls> getUser_dtls() {
        return user_dtls;
    }

    public void setUser_dtls(List<User_dtls> user_dtls) {
        this.user_dtls = user_dtls;
    }

    public List<Roles_dtls> getRoles_dtls() {
        return roles_dtls;
    }

    public void setRoles_dtls(List<Roles_dtls> roles_dtls) {
        this.roles_dtls = roles_dtls;
    }
}
