


public class testAlbum{

	public static void main(String[] args){
	
	album	album1 = new album("titre1", "artiste1", 180, "10/10/2000", "c:fichier", 0);
	album	album2 = new album("titre2", "artiste2", 180, "12/12/2012", "c:fichier", 0);
	
	album1.affiche();

	albums listeAlbums = new albums();
	listeAlbums.add(album1);	
	listeAlbums.add(album2);	
	listeAlbums.save("chansons.csv");	


	albums listeAlbum1 = new albums();
	listeAlbum1.read("chansons.csv");	
	listeAlbum1.affiche();
	
	}
}
