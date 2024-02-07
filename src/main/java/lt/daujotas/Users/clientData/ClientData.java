package lt.daujotas.Users.clientData;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lt.daujotas.validation.PhoneNumber;
import lt.daujotas.validation.PhoneNumberType;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.sql.Date;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Table(name = "clientaccountdata")
@Builder
@Setter
@NoArgsConstructor
@ToString

public class ClientData implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{NotEmpty.Name.message.userName}")
    @Column(name = "username")
    private String userName;
    @NotEmpty(message = "{NotEmpty.Name.message.Name}")
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;
    @NotEmpty(message = "{NotEmpty.Name.message.lastName}")
    @Column(name = "lastname")
    private String lastName;
    @NotEmpty(message = "{NotEmpty.Name.message.postAddress}")
    @Column(name = "postaddress")
    private String postAddres;
    @NotEmpty(message = "{NotEmpty.Name.message.phone}")
    @Column(name = "phonenumber")
    @PhoneNumber(numberType = PhoneNumberType.GLOBAL)
    private String phoneNumber;
    @NotEmpty
    @NotEmpty(message = "{NotEmpty.Name.message.password}")
    private String password;
    @NotEmpty(message = "{NotEmpty.Name.message.email}")
    @Column(name = "emailaddress")
    private String emailAddress;
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    private String gender;

    @Column(columnDefinition = "BINARY(16)", name = "uuid")
    private UUID accountUuid;

    @Column(nullable = false)
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Autohority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     Hibernate.initialize(authorities);
        return authorities;
    }


    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostAddres() {
        return postAddres;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }



    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public UUID getAccountUuid() {
        return accountUuid;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
