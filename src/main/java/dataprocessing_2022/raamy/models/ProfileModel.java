package dataprocessing_2022.raamy.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;



@Entity
@Table(name="profile")
public class ProfileModel
{
    @Id
    @ApiModelProperty(notes = "Name of an specific user", dataType = "String")
    private String profile;

    @NotNull(message = "Gender might be empty but not null. ")
    @ApiModelProperty(notes = "Gender of a user ", dataType = "String")
    private String gender;

    @NotNull(message = "Birthday might be empty but not null. ")
    @ApiModelProperty(notes = "Birthday of a user", dataType = "String")
    private String birthday;

    @NotNull(message = "Favorite_anime might be empty but not null. ")
    @ApiModelProperty(notes = "favorite animes of a user", dataType = "String")
    private String favorites_anime;

    @NotBlank(message = "Link is mandatory. ")
    @ApiModelProperty(notes = "Specific link of a user", dataType = "String")
    private String link;

    public ProfileModel(String profile, @NotNull(message = "Gender might be empty but not null. ") String gender, @NotNull(message = "Birthday might be empty but not null. ") String birthday, @NotNull(message = "Favorite_anime might be empty but not null. ") String favorites_anime, @NotBlank(message = "link is mandatory") String link)
    {
        this.profile = profile;
        this.gender = gender;
        this.birthday = birthday;
        this.favorites_anime = favorites_anime;
        this.link = link;
    }

    public ProfileModel()
    {

    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getFavorites_anime()
    {
        return favorites_anime;
    }

    public void setFavorites_anime(String favorites_anime)
    {
        this.favorites_anime = favorites_anime;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }
}

