package gefp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "checkpoint")

public class Checkpoint implements Serializable {
private static final long serialVersionUID = 1L;
			
			
			@Id
		    @GeneratedValue
		    private Integer id;
			
			private String name;
			
			@ManyToOne
			private Runway runway;
			
			@ManyToOne
			private Stage stage;
			
			
			public Checkpoint(){
				
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Runway getRunway() {
				return runway;
			}

			public void setRunway(Runway runway) {
				this.runway = runway;
			}

			public Stage getStage() {
				return stage;
			}

			public void setStage(Stage stage) {
				this.stage = stage;
			}
}

