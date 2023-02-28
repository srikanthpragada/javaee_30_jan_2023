package inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "inheritance.Player")
@DiscriminatorValue("1")  // Value to be stored in Discriminator Column 
public class Player extends Person {
	private String game;

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "Player :  " +  id + " " + name + " " + game ;
	}
 
}
