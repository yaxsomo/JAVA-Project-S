public class Application {

    private String phraseDeBienvenu = "Bienvenu/e dans le moteur de recherche 'TheMovieDB!' \nChoisissez une fonctionnalité parmi les suivantes :";
    void start(){
        System.out.println(phraseDeBienvenu);
        Menu menu = new Menu();
        menu.begin();
    }

}


