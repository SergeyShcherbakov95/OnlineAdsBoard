package shcherbakov.sergey.onlineAdsBoard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sergey.shcherbakov
 *
 */

@Entity
@Table( name = "Images")
public class Img {
	
	// Fields
	// ------------------------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "idImage")
	private Integer idImage;
	
	@Column( name = "image")
	private String pathToImage;
	
	// Constructors
	// -----------------------------------------------------------------------------------------

	public Img(){
		
	}
	
	public Img(String pathToImage) {
		super();
		this.pathToImage = pathToImage;
	}

	// Getters
	// -----------------------------------------------------------------------------------------
	
	public Integer getIdImage() {
		return idImage;
	}

	public String getPathToImage() {
		return pathToImage;
	}
	
	// Setters
	// ------------------------------------------------------------------------------------------

	public void setIdImage(Integer idImage) {
		this.idImage = idImage;
	}

	public void setPathToImage(String pathToImage) {
		this.pathToImage = pathToImage;
	}
}
