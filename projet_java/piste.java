import java.io.Serializable;

//la classe piste permet de différencier l'id des chansons et des albums

public class piste implements Serializable{

	char type;
	int id;

	public piste(char _type, int _id){
		this.type = _type;
		this.id = _id;
	}


	public char getType(){
		return this.type;
	}

	public int getId(){
		return this.id;
	}

}
