public abstract class AbstractMedia {

    //Variables used in Standard Film Search
    private int id;
    private String original_title;

    private String original_name;
    private String media_type;
        //Additional variables used in Detailed Film Search
    private String overview;
    private double vote_average;
    private double vote_count;



    public AbstractMedia(int myID, String myOriginalTitle,String myMediaType, String myOverview, double myVoteAverage, double myVoteCount){
        id = myID;
        if (myOriginalTitle.equals("movie")){
            original_title = myOriginalTitle;
        } else {
            original_name = myOriginalTitle;
        }
        media_type = myMediaType;
        overview = myOverview;
        vote_average = myVoteAverage;
        vote_count = myVoteCount;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getOriginal_title(){
        return original_title;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public String getMedia_type() {return media_type; }

    public String getOverview(){
        return overview;
    }

    public double getVote_average() {
        return vote_average;
    }

    public double getVote_count() {
        return vote_count;
    }


    //Setters


    public void setId(int id) {
        this.id = id;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public void setVote_count(double vote_count) {
        this.vote_count = vote_count;
    }

}
