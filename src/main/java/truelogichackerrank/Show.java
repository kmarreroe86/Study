package truelogichackerrank;

public class Show implements Comparable<Show> {
    private Long id;
    private String name;
    private String runtimeOfSeries;
    private String certificate;
    private String runtime_of_episodes;
    private String genre;
    private Float imdb_rating;
    private String overview;
    private Integer noOfVotes;

    public Show() {
    }

    public Show(Long id, String name, String runtimeOfSeries, String certificate, String runtime_of_episodes,
                String genre, Float imdb_rating, String overview, Integer noOfVotes) {
        this.id = id;
        this.name = name;
        this.runtimeOfSeries = runtimeOfSeries;
        this.certificate = certificate;
        this.runtime_of_episodes = runtime_of_episodes;
        this.genre = genre;
        this.imdb_rating = imdb_rating;
        this.overview = overview;
        this.noOfVotes = noOfVotes;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRuntimeOfSeries() {
        return runtimeOfSeries;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getRuntime_of_episodes() {
        return runtime_of_episodes;
    }

    public String getGenre() {
        return genre;
    }

    public Float getImdb_rating() {
        return imdb_rating;
    }

    public String getOverview() {
        return overview;
    }


    public Integer getNoOfVotes() {
        return noOfVotes;
    }


    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", runtimeOfSeries='" + runtimeOfSeries + '\'' +
                ", certificate='" + certificate + '\'' +
                ", runtime_of_episodes='" + runtime_of_episodes + '\'' +
                ", genre='" + genre + '\'' +
                ", imdb_rating=" + imdb_rating +
                ", overview='" + overview + '\'' +
                ", noOfVotes=" + noOfVotes +
                '}';
    }

    @Override
    public int compareTo(Show other) {
        return Float.compare(this.imdb_rating, other.getImdb_rating());
    }
}
