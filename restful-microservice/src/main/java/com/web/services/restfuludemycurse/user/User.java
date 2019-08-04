package com.web.services.restfuludemycurse.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ApiModel(description = "Details about the user.")
@Entity
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "Unique Identifier for each user.")
    private Integer id;

    @ApiModelProperty(notes = "Name should have at least two characters.")
    @Size(min = 2, message = "Name should have at least two characters.")
    private String name;

    @ApiModelProperty(notes = "Date must be less than today.")
    @Past(message = "Date must be less than today.")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User() {
        super();
        //Default constructor to avoid 500 internal server error:
        /*"Type definition error:
            [simple type, class com.web.services.restfuludemycurse.user.User];
            nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
                Cannot construct instance of `com.web.services.restfuludemycurse.user.User`
                (no Creators, like default construct, exist):
                    cannot deserialize from Object value (no delegate- or property-based Creator)\n at
                        [Source: (PushbackInputStream); line: 2, column: 3]"*/
    }

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}