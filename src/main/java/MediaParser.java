public class MediaParser {

    public int id;
    public String original_title;

    public String original_name;

    public String media_type;
    public String overview;

    public double vote_average;
    public double vote_count;

    public Media toMedia(){
        return new Media(id, original_title,media_type,overview,vote_average,vote_count);
    }
}


