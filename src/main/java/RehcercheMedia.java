public class RehcercheMedia {
    private String search;
//    private MediaCollection[] searchResults;



    public RehcercheMedia(String mySearch){
        search = mySearch;
    }


    public String execute(){
        BaseAPI api = new BaseAPI();
        ParseJSON search = new ParseJSON(api);
        MediaCollection collection =  search.parseCollectionByName(this.search);

        return collection.getCollectionResults();
    }


}
