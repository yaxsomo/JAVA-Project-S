import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BaseAPI {

    private final String API_KEY = "?api_key=5d7eaea19babe0989427f96118405e1e";
    public final String BASE_API_FILM_DETAIL = "https://api.themoviedb.org/3/movie/";
    public final String BASE_API_TV_DETAIL = "https://api.themoviedb.org/3/tv/";
//    public final String BASE_API_FILM_SEARCH = "https://api.themoviedb.org/3/search/movie";
//    public final String BASE_API_TV_SEARCH = "https://api.themoviedb.org/3/search/tv";
    public final String BASE_API_MULTISEARCH = "https://api.themoviedb.org/3/search/multi"+ API_KEY + "&query=";

    private String id = "5";
    private String JSON;


    //Getters
    public void setId(String id) {
        this.id = id;
    }

    public void setJSON(String JSON) {
        this.JSON = JSON;
    }

    //Setters
    public String getJSON() {
        return JSON;
    }

    public String getId() {
        return id;
    }

    //Methods
    public String getMediaDataDetail(String BASE_API, String id){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_API + id + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()){
            return response.body().string();

        } catch (IOException ex){
            System.out.println("Error catching client response: " + ex);
            return null;
        }

    }

    public String getCollectionMultiSearch(String query){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_API_MULTISEARCH + query)
                .build();

        try (Response response = client.newCall(request).execute()){
            return response.body().string();

        } catch (IOException ex){
            System.out.println("Error catching client response: " + ex);
            return null;
        }

    }

}


class ParseJSON {

    private BaseAPI api;
    Gson gson = new GsonBuilder().create();

    public ParseJSON(BaseAPI api) {
        this.api = api;
    }

//    public Media parseMovieById(String myId) {
//        String data = api.getMediaDataDetail(this.api.BASE_API_FILM_DETAIL, myId);
////        System.out.println(data);
//        MediaParser film = gson.fromJson(data, MediaParser.class);
//        if (film == null) {
//           System.out.println("No Media found!");
//        }
//        return film.toMedia();
//    }

    public MediaCollection parseCollectionByName(String searchQuery){
        String data = api.getCollectionMultiSearch(searchQuery);
//        System.out.println(data);
        MediaCollectionParser medias = gson.fromJson(data, MediaCollectionParser.class);
        if (medias == null){
            System.out.println("No Media Collection Found!");
        }

        return medias.toMediaResults();

    }

    public MediaCollection parseCollectionByID(int Id){
        Media dataMovie = gson.fromJson(api.getMediaDataDetail(api.BASE_API_FILM_DETAIL, Integer.toString(Id)), Media.class);
        dataMovie.setMedia_type("movie");
        Media dataTv = gson.fromJson(api.getMediaDataDetail(api.BASE_API_TV_DETAIL, Integer.toString(Id)), Media.class);
        dataTv.setMedia_type("tv");
//        System.out.println(data);
        MediaCollectionParser medias = new MediaCollectionParser(new Media[]{dataMovie,dataTv});
        return medias.toMediaResults();

    }

}

