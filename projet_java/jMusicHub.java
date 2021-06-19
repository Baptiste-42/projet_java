import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
class principale  
 
*/

public class jMusicHub{


public static void main(String[] args){

	chansons listeChanson = new chansons();
	livres listeLivre = new livres();
	albums listeAlbum = new albums();
	playlists listePlaylist = new playlists();

	String choice;
		
	System.out.println("Bienvenue sur jMusicHub");

	Scanner saisie = new Scanner(System.in);
	
	listeChanson.read("saveChanson.data");
	listeLivre.read("saveLivre.data");
	listeAlbum.read("saveAlbum.data");
	listePlaylist.read("savePlaylist.data");

	do{
		
		System.out.println("what do you want to do? [h for help]");
		choice = saisie.nextLine();

		char touche = choice.charAt(0);

		switch(touche){
			case 'q':
				System.out.println("au revoir");
				System.exit(0);
				break;

			case 'c':
				System.out.println("ajout d'une nouvelle chanson");
				chanson newChanson;
				newChanson = askNewChanson();	
				newChanson.affiche();
				System.out.println("chanson créée");
				listeChanson.add(newChanson);
				break;

			case 'a':
				System.out.println("rajout d'un nouveau album");
				album newAlbum;
				newAlbum = askNewAlbum();
				newAlbum.affiche();
				System.out.println("album créée");
				listeAlbum.add(newAlbum);
				break;

			case '+':
				System.out.println("rajout d'une chanson existante dans un album");
				addChansonToAlbum(listeAlbum, listeChanson);

				break;

			case 'l':
				System.out.println("rajout d'un nouveau livre audio");
				livre newLivre;
				newLivre = askNewLivre();
				newLivre.affiche();
				System.out.println("livre audio créée");
				listeLivre.add(newLivre);
				System.out.println("sauvegarde");

				break;

			case 'p':
				System.out.println("Création d'une nouvelle playlist à partir de chanson et livre audio existant");
				playlist newPlaylist;
				newPlaylist = askNewPlaylist(listeChanson, listeLivre, listePlaylist);
				newPlaylist.affiche();
				System.out.println("playlist créée");
				listePlaylist.add(newPlaylist);
				System.out.println("sauvegarde");
				break;

			case '-':
				System.out.println("supression d'une playlist");
				break;

			case 's':
				System.out.println("sauvegarde");
				saveChansons(listeChanson);
				saveLivres(listeLivre);
				saveAlbums(listeAlbum);
				savePlaylist(listePlaylist);
				break;
			
			case 't':
				System.out.println("liste des chansons :");
				afficheChansons(listeChanson);
				break;

			case 'u':
				System.out.println("liste des livres audio :");
				afficheLivres(listeLivre);
				break;	

			case 'k':
				System.out.println("liste des albums : ");
				afficheAlbums(listeAlbum);
				break;

			case 'b':
				System.out.println("liste des chansons de l'album: ");
				afficheChansonAlbum(listeAlbum, listeChanson);	
				break;
			
			case 'o':
				System.out.println("liste des playlists");
				affichePlaylist(listePlaylist);
				break;

			case 'h':
				System.out.println("                         ");
				System.out.println("h: print this help screen");
				System.out.println("q: quitter le programme");
				System.out.println("c: ajout d'une nouvelle chanson");
				System.out.println("a: rajout d'un nouveau album");
				System.out.println("+: rajout d'une chanson existante dans un album");
				System.out.println("l: rajout d'un nouveau livre audio");
				System.out.println("p: Création d'une nouvelle playlist à partirs de chanson et livre audio existant");
				System.out.println("-: supression d'une playlist");
				System.out.println("s: sauvegarde");
				System.out.println("t: affiche la liste des chansons");
				System.out.println("u: affiche la liste des livres audio");
				System.out.println("k: affiche la liste des albums");
				System.out.println("b: affiche la liste des chansons d'un album");
				System.out.println("os: affiche la liste des playlists");
				break;
		
			default:
				System.out.println("Commande inconnue. tapper 'h' pour afficher l'aide");
		
		}	
	
	
	
	}while(true);



}

//------------------------------------------------------------------
	private static chanson askNewChanson(){
		Scanner saisieChanson = new Scanner(System.in);

		System.out.println("Saisir le titre: ");
		String titre = saisieChanson.nextLine();

		System.out.println("Saisir l'artiste: ");
		String artiste = saisieChanson.nextLine();

		System.out.println("saisir la duree: ");
		int duree = new Integer(saisieChanson.nextLine());

		System.out.println("chemin du fichier: ");
		String fichier = saisieChanson.nextLine();

		System.out.println("choisir le genre (saisir le numero): ");
		genres[] valuesArray = genres.values();
		for(int i = 0; i < valuesArray.length; i++){
			System.out.println(valuesArray[i]);
		}
		int genreId = new Integer(saisieChanson.nextLine());
		String genreStr = valuesArray[genreId - 1].getGenre();
		

		chanson newChanson = new chanson(titre, artiste, duree, 0, fichier, genreStr);
		return newChanson;
	
	}
	
	private static void afficheChansons(chansons listeChanson){	
		listeChanson.affiche();
	}

	private static void saveChansons(chansons listeChanson){
		listeChanson.save("saveChanson.data");
	}
//------------------------------------------------------------------------
	private static livre askNewLivre(){
		Scanner saisieLivre = new Scanner(System.in);

		System.out.println("saisir le titre");
		String titre = saisieLivre.nextLine();

		System.out.println("saisir l'auteur");
		String auteur = saisieLivre.nextLine();

		System.out.println("saisir la duree");
	    int duree = new Integer(saisieLivre.nextLine());	

		System.out.println("chemin du fichier");
		String fichier = saisieLivre.nextLine();	
		
		System.out.println("choisir la categorie (saisir le numero)");
		categories[] valuesArray = categories.values();
		for(int i = 0; i < valuesArray.length; i++){
			System.out.println(valuesArray[i]);
		}
		int categorieId = new Integer(saisieLivre.nextLine());
		String categorieStr = valuesArray[categorieId - 1].getCategorie();

		System.out.println("choisir la langue (saisir le numero)");
		langues[] valuesArray2 = langues.values();	
		for(int i = 0; i < valuesArray2.length; i++){
			System.out.println(valuesArray2[i]);
		}
		int langueId = new Integer(saisieLivre.nextLine());
		String langueStr = valuesArray2[langueId - 1].getLangue();

		livre newLivre = new livre(titre, auteur, duree, 0, fichier, categorieStr, langueStr);
		return newLivre;
	}

	private static void afficheLivres(livres listeLivre){
		listeLivre.affiche();
	}

	private static void saveLivres(livres listeLivre){
		listeLivre.save("saveLivre.data");
	}
//----------------------------------------------------------------------------
	private static album askNewAlbum(){
		Scanner saisieAlbum = new Scanner(System.in);
		boolean lecture = false;
		String date = null;

		System.out.println("Saisir le titre: ");
		String titre = saisieAlbum.nextLine();

		System.out.println("Saisir l'artiste: ");
		String artiste = saisieAlbum.nextLine();

		System.out.println("saisir la duree: ");
		int duree = new Integer(saisieAlbum.nextLine());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		do{
			try{
				System.out.println("saisir la date de sortie au format jj/mm/aaaa: ");
				date = saisieAlbum.nextLine();
				simpleDateFormat.parse(date);
				lecture = true;
			}
			catch (ParseException e){
				System.err.println("erreur de saisie");
			}
		}while(lecture == false);

		album newAlbum = new album(titre, artiste, duree, date, 0);
		return newAlbum;
	
	}
	
	private static void afficheAlbums(albums listeAlbum){	
		listeAlbum.affiche();
	}

	private static void saveAlbums(albums listeAlbum){
		listeAlbum.save("saveAlbum.data");
	}

//-----------------------------------------------------------------------
	private static void addChansonToAlbum(albums listeAlbums, chansons listeChansons){	
		album _album = null;
		Scanner saisie = new Scanner(System.in); 
		afficheAlbums(listeAlbums);
		
		System.out.println("Saisir l'id de l'album à éditer");
		int idAlbum = new Integer(saisie.nextLine());
		
		_album = listeAlbums.getAlbum(idAlbum);	
		_album.affiche();
	
		listeChansons.affiche();
		System.out.println("Saisir l'id de la chanson à insérer");
		int idChanson = new Integer(saisie.nextLine());		
		_album.add(idChanson);	
	}
//-----------------------------------------------------------------------------
	private static void afficheChansonAlbum(albums listeAlbums, chansons listeChansons){
		album _album = null;
		Scanner saisie = new Scanner(System.in); 
		afficheAlbums(listeAlbums);
		
		System.out.println("Saisir l'id de l'album à afficher");
		int idAlbum = new Integer(saisie.nextLine());
		
		_album = listeAlbums.getAlbum(idAlbum);	
		_album.affiche();
		
		List liste = _album.get();
		for (int i=0; i<liste.size();i++){
			listeChansons.affiche((int) liste.get(i));
		}

	}
//------------------------------------------------------------------------------------
	
	private static playlist askNewPlaylist(chansons listeChansons, livres listeLivres, playlists listePlaylists){
		char choix;
		String nom;
		Scanner saisiePlaylist = new Scanner(System.in);	
		System.out.println("Saisir le nom: ");
		nom = saisiePlaylist.nextLine();
		playlist playList = new playlist(nom, 0);
		listePlaylists.add(playList);


		do{		
			System.out.println("1: chanson 2: livre audio 3: quitter");
			nom = saisiePlaylist.nextLine();
		 	choix = nom.charAt(0);
			
			if(choix == '1'){
				listeChansons.affiche();
				System.out.println("Saisir l'id de la chanson à insérer");
				int idChanson = new Integer(saisiePlaylist.nextLine());		
				playList.addChanson(idChanson);	
			}
			else if(choix == '2'){
				listeLivres.affiche();
				System.out.println("Saisir l'id du livre audio à insérer");
				int idLivre = new Integer(saisiePlaylist.nextLine());		
				playList.addLivre(idLivre);	
			}

		}while(choix != '3');

		playlist newPlaylist = new playlist(nom, 0);
		return newPlaylist;
	}	

	private static void savePlaylist(playlists listePlaylist){
		listePlaylist.save("savePlaylist.data");
	}
	
	private static void affichePlaylist(playlists listePlaylist){	
		listePlaylist.affiche();
	}
}
