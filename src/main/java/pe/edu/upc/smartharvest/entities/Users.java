package pe.edu.upc.smartharvest.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(length = 30, unique = true)
    private String username;
    @Column(length = 200)
    private String password;
    private Boolean enabled;
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idRol")
    private List<Role> roles;
    @Column(name = "preferred_language", length = 20)
    private String preferredLanguage;
    @Column(name = "display_theme", length = 20)
    private String displayTheme;
    @ElementCollection
    @CollectionTable(name = "user_favorite_sections", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "section_name")
    private List<String> favoriteSections;


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getDisplayTheme() {
        return displayTheme;
    }

    public void setDisplayTheme(String displayTheme) {
        this.displayTheme = displayTheme;
    }

    public List<String> getFavoriteSections() {
        return favoriteSections;
    }

    public void setFavoriteSections(List<String> favoriteSections) {
        this.favoriteSections = favoriteSections;
    }
}
