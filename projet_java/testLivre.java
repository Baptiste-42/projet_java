


public class testLivre{

	public static void main(String[] args){
	
	livre	livre1 = new livre("titre1", "auteur1", 180, 0, "c:fichier", "categorie1","francais");
	livre	livre2 = new livre("titre2", "auteur2", 180, 0, "c:fichier", "categorie2","francais");
	
	livre1.affiche();

	livres listeLivre = new livres();
	listeLivre.add(livre1);	
	listeLivre.add(livre2);	
	listeLivre.save("livres.csv");	


	livres listeLivre1 = new livres();
	listeLivre1.read("livres.csv");	
	listeLivre1.affiche();
	
	}
}
