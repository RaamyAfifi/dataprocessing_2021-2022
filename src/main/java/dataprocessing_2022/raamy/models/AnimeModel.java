package dataprocessing_2022.raamy.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;

@Entity
@Table(name="anime")
public class AnimeModel
{
    @Id
    private int uid;
    @NotBlank(message = "Uid is mandatory")
    private String title;
    @NotNull(message = "Title is mandatory")
    private String genre;
    @NotNull(message = "Genre is mandatory")
    private String aired;
    @NotBlank(message = "Aired is mandatory")
    private String episodes;
    @NotNull(message = "Episodes is mandatory")
    private int members;
    private float score;

    public AnimeModel(int uid, @NotBlank(message = "Uid is mandatory") String title, @NotBlank(message = "Title is mandatory") String genre, @NotNull(message = "Genre is mandatory") String aired, @NotBlank(message = "Aired is mandatory") String episodes, @NotNull(message = "Episodes is mandatory") int members, float score)
    {
        this.uid = uid;
        this.title = title;
        this.genre = genre;
        this.aired = aired;
        this.episodes = episodes;
        this.members = members;
        this.score = score;
    }

    public AnimeModel()
    {

    }

    public int getUid()
    {
        return uid;
    }

    public void setUid(int uidAnime)
    {
        this.uid = uidAnime;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getAired()
    {
        return aired;
    }

    public void setAired(String aired)
    {
        this.aired = aired;
    }

    public String getEpisodes()
    {
        return episodes;
    }

    public void setEpisodes(String episodes)
    {
        this.episodes = episodes;
    }

    public int getMembers()
    {
        return members;
    }

    public void setMembers(int members)
    {
        this.members = members;
    }

    public float getScore()
    {
        return score;
    }

    public void setScore(float score)
    {
        this.score = score;
    }
}
