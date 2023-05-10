import java.util.Scanner;

public class Menu extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int nChoix = 0;

    private String[] listeChoix = {"1. Chercher un media par nom", "2. Consulter les details d'un media specifique", "3. Fermer le programme"};

    public void begin(){
        Scanner ans = new Scanner(System.in);
        while (nChoix!=3 && nChoix != 2 && nChoix != 1){
            for (String choix:listeChoix) {
                System.out.println(choix);
            }
            try {
                nChoix = ans.nextInt();
                switch (nChoix){
                    case 1: RechercheMediaNom();
                            break;
                    case 2: DetailMedia(); break;
                    case 3: ans.close();System.exit(0);
                    default: System.out.println("Rentrez une valeur numerique comprise entre 1 et " + listeChoix.length + " :");
                }
            }
            catch (Exception ex){
                System.out.println("Rentrez une valeur numerique :");
                ans.next();
            }
        }

    }

    private static void RechercheMediaNom() {
        Scanner ans = new Scanner(System.in);
        System.out.println("Bienvenue dans la section 'Recherche des medias par nom' !");
        System.out.println("Veuillez entrer le nom du media desiré: ");
        String userSearch = ans.nextLine();
        RehcercheMedia r = new RehcercheMedia(userSearch);
        String result = r.execute();
        System.out.println("Voici les 15 premiers resultats: \n--------------------------------------------\n" + result +
                "Que souhaitez-vous faire? [1 - Relancer une recherche | 2 - Retour au menu principal | 3 - Quitter le programme]");
        int res = ans.nextInt();
        switch (res){
            case 1: RechercheMediaNom();
            case 2: Menu m = new Menu();
                    m.begin();
            case 3: System.out.println("Au revoir!");
            		ans.close();
                    System.exit(0);
        }
    }

    private static void DetailMedia() {
        Scanner ans = new Scanner(System.in);
        System.out.println("Bienvenue dans la section 'Obtenir details d'un media' !");
        System.out.println("Veuillez entrer l'ID du media desiré: ");
        int userSearch = ans.nextInt();
        DetailMedia d = new DetailMedia(userSearch);
        String result = d.execute();
        System.out.println("Voici les resultats correspondants: \n--------------------------------------------\n" + result +
                "Que souhaitez-vous faire? [1 - Relancer une recherche | 2 - Retour au menu principal | 3 - Quitter le programme]");
        int res = ans.nextInt();
        switch (res){
            case 1: DetailMedia();
            case 2: Menu m = new Menu();
                    m.begin();
            case 3: System.out.println("Au revoir!");
            		ans.close();
                    System.exit(0);
        }
    }
}


