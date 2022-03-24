package dataprocessing_2022.raamy.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="review")
public class ReviewModel
{
    @Id
    @ApiModelProperty(notes = "Uid of a specific review", dataType = "int")
    private int uid;

    @NotBlank(message = "Profile is mandatory. ")
    @ApiModelProperty(notes = "Profile name of a specific user", dataType = "String")
    private String profile;

    @NotNull(message = "Anime_uid is mandatory. ")
    @ApiModelProperty(notes = "Uid of an anime", dataType = "int")
    private int anime_uid;

    @NotBlank(message = "score might be empty but not null. ")
    @ApiModelProperty(notes = "score given by a user", dataType = "int")
    private int score;

    @NotBlank(message = "Link is mandatory. ")
    @ApiModelProperty(notes = "link of a comment of a user", dataType = "String")
    private String link;

    public ReviewModel(int uid, @NotBlank(message = "Profile is mandatory. ") String profile, @NotNull(message = "Anime_uid is mandatory. ") int anime_uid, @NotBlank(message = "score might be empty but not null. ") int score, @NotBlank(message = "Link is mandatory. ") String link)
    {
        this.uid = uid;
        this.profile = profile;
        this.anime_uid = anime_uid;
        this.score = score;
        this.link = link;
    }

    public ReviewModel()
    {

    }

    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    public int getAnime_uid()
    {
        return anime_uid;
    }

    public void setAnime_uid(int animeUid)
    {
        this.anime_uid = animeUid;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
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

