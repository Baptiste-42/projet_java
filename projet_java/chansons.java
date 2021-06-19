import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//cette classe permet de stocker des chansons dans une liste 

public class chansons extends fichierData{

	List<chanson> listChansons = new ArrayList<>();
	
	public void add(chanson _chanson){  //pour rajouter une chanson dans la liste
		int id = listChansons.size() + 1;
		_chanson.setId(id);
		listChansons.add( _chanson);
		System.out.println("add chanson");
	}

	public void save(String filePass){  //serialisation
		System.out.println("save chanson");

		ObjectOutputStream oos = null;

		try{
			final FileOutputStream fichier = new FileOutputStream(filePass);
			oos = new ObjectOutputStream(fichier);

			oos.writeObject(listChansons);

			oos.flush();
			oos.close();
		}
		catch (final java.io.IOException e) {
			e.printStackTrace();
		}	

	}
	
	
	public void read(String filePass){  //deserialisation
	
		System.out.println("read chanson");
		
		ObjectInputStream oos = null;
		
		try{
			final FileInputStream fichier = new FileInputStream(filePass);
			oos = new ObjectInputStream(fichier);
			listChansons = (ArrayList) oos.readObject();
			oos.close();
		}
		catch (final java.io.IOException e){
			e.printStackTrace();
		}	
		catch (final Exception e){
			e.printStackTrace();
		}
	
	}

	public void affiche(){			//affiche la liste des chansons
		System.out.println("affiche");
		System.out.println(listChansons.size());

		for(int i = 0; i < listChansons.size(); i++){
			chanson _chanson = listChansons.get(i);
			_chanson.affiche();
		}
	}

	public void affiche(int j){			//affiche la liste des chansons
		System.out.println("affiche");
		System.out.println(listChansons.size());

		for(int i = 0; i < listChansons.size(); i++){
			chanson _chanson = listChansons.get(i);
			if(_chanson.id() == j){
				_chanson.affiche();
			}
		}
	}

}

