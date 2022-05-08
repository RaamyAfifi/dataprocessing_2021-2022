package dataprocessing_2022.raamy.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="anime")
public class AnimeModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "beschrijving", dataType = "int")
    private int uid;
    @NotBlank(message = "Uid is mandatory")
    @ApiModelProperty(notes = "title on an anime", dataType = "String")
    private String title;
    @NotNull(message = "Title is mandatory")
    @ApiModelProperty(notes = "Genre of an anime", dataType = "String")
    private String genre;
    @NotNull(message = "Genre is mandatory")
    @ApiModelProperty(notes = "Date when anime aired", dataType = "String")
    private String aired;
    @NotBlank(message = "Aired is mandatory")
    @ApiModelProperty(notes = "Amount of episode per anime", dataType = "String")
    private String episodes;
    @NotNull(message = "Episodes is mandatory")
    @ApiModelProperty(notes = "Members of a specific anime", dataType = "int")
    private int members;
    @ApiModelProperty(notes = "Average score of an anime", dataType = "String")
    private String score;

    public AnimeModel(int uid, @NotBlank(message = "Uid is mandatory") String title, @NotBlank(message = "Title is mandatory") String genre, @NotNull(message = "Genre is mandatory") String aired, @NotBlank(message = "Aired is mandatory") String episodes, @NotNull(message = "Episodes is mandatory") int members, String score)
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

    public String getScore()
    {
        return score;
    }

    public void setScore(String score)
    {
        this.score = score;
    }
}
