


public class testChanson{

	public static void main(String[] args){
	
	chanson	chanson1 = new chanson("titre1", "artiste1", 180, 0, "c:fichier", "genre1");
	chanson	chanson2 = new chanson("titre2", "artiste2", 180, 0, "c:fichier", "genre2");
	
	chanson1.affiche();

	chansons listeChanson = new chansons();
	listeChanson.add(chanson1);	
	listeChanson.add(chanson2);	
	listeChanson.save("chansons.csv");	


	chansons listeChanson1 = new chansons();
	listeChanson1.read("chansons.csv");	
	listeChanson1.affiche();
	
	}
}
