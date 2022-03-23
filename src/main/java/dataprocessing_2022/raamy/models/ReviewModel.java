package dataprocessing_2022.raamy.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="review")
public class ReviewModel
{
    @Id
    private int uid;
    @NotBlank(message = "Profile is mandatory. ")
    private String profile;
    @NotNull(message = "Anime_uid is mandatory. ")
    private int anime_uid;
    @NotBlank(message = "score might be empty but not null. ")
    private int score;
    @NotBlank(message = "Link is mandatory. ")
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

