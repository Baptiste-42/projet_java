import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collections;

public class livres extends fichierData{

	List<livre> listLivres = new ArrayList<>();

	public void add(livre _livre){  //pour rajouter une chanson dans la liste
		int id = listLivres.size() + 1;
		_livre.setId(id);
		listLivres.add( _livre);
		System.out.println("add livre");
	}

	public void save(String filePass){    //serialisation
		System.out.println("save livre");	
	
		ObjectOutputStream oos = null;

		try{
			final FileOutputStream fichierLivre = new FileOutputStream(filePass);
			oos = new ObjectOutputStream(fichierLivre);

			oos.writeObject(listLivres);

			oos.flush();
			oos.close();
		}
		catch (final java.io.IOException e){  
			System.err.println("erreur de sauvegarde");
		}

	}

	public void read(String filePass){  //deserialisation
		
		System.out.println("read livre");
	
		ObjectInputStream oos = null;	
	
		try{
			final FileInputStream fichierLivre = new FileInputStream(filePass);
			oos = new ObjectInputStream(fichierLivre);
	   		listLivres = (ArrayList) oos.readObject();
			oos.close();	
		}	
		catch (final java.io.IOException e){
			System.err.println("erreur de lecture");
		}
		catch (final Exception e){
			e.printStackTrace();
		}

	}

	public void affiche(){
		System.out.println("affiche livre");
		System.out.println(listLivres.size());

		Collections.sort(listLivres);

		for(int i = 0; i < listLivres.size(); i++){
			livre _livre = listLivres.get(i);
			_livre.affiche();
		}

	}

}
