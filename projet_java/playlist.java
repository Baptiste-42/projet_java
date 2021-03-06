import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class playlist implements Serializable{
	
	String nom;
	int id;
	
	List<piste> listPiste = new ArrayList<>();
	
	public void affiche(){
		System.out.println("id:"+id+" nom: "+nom);
	}

	public playlist(String nom, int _id){
		this.nom = nom;
	}

	public String nom(){
		return this.nom;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}	

	public void addChanson(int id){
		piste p = new piste('c',id);
		listPiste.add(p);
	}

	public void addLivre(int id){
		piste p = new piste('l',id);
		listPiste.add(p);
	}

	public List get(){
		return this.listPiste;
	}
}
