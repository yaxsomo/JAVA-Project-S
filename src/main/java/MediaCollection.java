public class MediaCollection{


    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";

    private Media[] results;


    public MediaCollection(Media[] myResults) {
        results = myResults;
    }

    public String getCollectionResults(){

        String result = "";
        final int MAX_RESULTS = 15;
        int count = 0;
        for (Media i:results) {
            if (count < MAX_RESULTS) {
                if (i.getMedia_type().equals("movie")) {
                    result += TEXT_BLUE + "ID: " + i.getId() + "\n" + "Nom: " + i.getOriginal_title() + "\n" + "Media Type: " + i.getMedia_type() +
                            "\n" + TEXT_RESET + "--------------------------------------------" + "\n";
                    count++;
                } else if (i.getMedia_type().equals("tv")) {
                    result += TEXT_GREEN + "ID: " + i.getId() + "\n" + "Nom: " + i.getOriginal_name() + "\n" + "Media Type: " + i.getMedia_type() +
                            "\n" + TEXT_RESET + "--------------------------------------------" + "\n";
                    count++;
                }
            } else break;
        }
        return result;
    }

    public String getDetailResults(){
        String result = "";
        for (Media i:results) {
                if (i.getMedia_type().equals("movie")) {
                    result += TEXT_BLUE + "ID: " + i.getId() + "\n" + "Nom: " + i.getOriginal_title() + "\n" + "Media Type: " + i.getMedia_type() +
                            "\n" + "Overview: " + i.getOverview() + "\n" + "Average Vote: " + i.getVote_average() + "\n" +
                            "Vote Count: " + i.getVote_count() + "\n" +
                            TEXT_RESET + "--------------------------------------------" + "\n";
                } else if (i.getMedia_type().equals("tv")) {
                    result += TEXT_GREEN + "ID: " + i.getId() + "\n" + "Nom: " + i.getOriginal_name() + "\n" + "Media Type: " + i.getMedia_type() +
                            "\n" + "Overview: " + i.getOverview() + "\n" + "Average Vote: " + i.getVote_average() + "\n" +
                            "Vote Count: " + i.getVote_count() + "\n" +
                            TEXT_RESET + "--------------------------------------------" + "\n";
                }
        }
        return result;
    }

//    public MediaCollection(int myID, String myOriginalTitle,String myMediaType) {
//        super(myID, myOriginalTitle, myMediaType);
//    }
//
//    public MediaCollection(int myID, String myOriginalTitle, String myOverview, double myVoteAverage, double myVoteCount) {
//        super(myID, myOriginalTitle, myOverview, myVoteAverage, myVoteCount);
//    }
//
//    public MediaCollection(int myID, String myOriginalTitle,String myMediaType, String myOverview, double myVoteAverage, double myVoteCount) {
//        super(myID, myOriginalTitle,myMediaType, myOverview, myVoteAverage, myVoteCount);
//    }



//    public String displaySearch(){
//        String filmInfo = "ID: " + this.getId() + "\n" + "Nom: " + this.getOriginal_title() + "\n" + "Media Type: " + this.getMedia_type();
//        return filmInfo;
//    }
//
//    public String displayDetails(){
//        String filmInfo = "ID: " + this.getId() + "\n" + "Nom: " + this.getOriginal_title() + "\n" +
//                "Media Type: " + this.getMedia_type() + "\n" + "Description: " + this.getOverview() + "\n" +
//                "Vote Average: " + this.getVote_average() + "\n" + "Vote Count: " + this.getVote_count();
//        return filmInfo;
//    }
}

