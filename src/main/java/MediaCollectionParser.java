public class MediaCollectionParser {

    public Media[] results;

    public MediaCollectionParser(Media[] myResults){
        results = myResults;
    }

    public MediaCollection toMediaResults(){
        MediaCollection collection = new MediaCollection(results);
        return collection;
    }


}
