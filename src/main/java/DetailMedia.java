public class DetailMedia {

    private int id;

    public DetailMedia(int myId){
        id = myId;
    }


    public String execute(){
        BaseAPI api = new BaseAPI();
        ParseJSON search = new ParseJSON(api);
        MediaCollection collection =  search.parseCollectionByID(id);

        return collection.getDetailResults();
    }


}
