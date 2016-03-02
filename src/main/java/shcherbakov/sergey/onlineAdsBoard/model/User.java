package shcherbakov.sergey.onlineAdsBoard.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author sergey.shcherbakov
 *
 */

@Entity
@Table( name = "Users")
public class User {
	
	// Fields
	// ------------------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "idUser")
	private Integer idUser;
	
	@Column( name = "email")
	private String email;
	
	@Column( name = "password")
	private String userPassword;
	
	@Column( name = "surname")
	private String surname;
	
	@Column( name = "name")
	private String name;
	
	@Column( name = "sex")
	private Character sex;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idImage", nullable=true)
	private Img imageUser;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userAd")
	private Set<Ad> ads = new HashSet<Ad>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "UsersFavourites", joinColumns = { 
			@JoinColumn(name = "idUser", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idAd", nullable = false, updatable = false) })
	private Set<Ad> adsFavourites = new HashSet<Ad>();
	
	// Constructors
	// -----------------------------------------------------------------------------------

	public User(){
		
	}
	
	public User(String email, String userPassword, String surname, String name, Character sex, Img imageUser) {
		super();
		this.email = email;
		this.userPassword = userPassword;
		this.surname = surname;
		this.name = name;
		this.sex = sex;
		this.imageUser = imageUser;
	}
	
	// Getters
	// -----------------------------------------------------------------------------------------

	public Integer getIdUser() {
		return idUser;
	}

	public String getEmail() {
		return email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public Character getSex() {
		return sex;
	}

	public Img getImageUser() {
		return imageUser;
	}

	public Set<Ad> getAds() {
		return ads;
	}

	public Set<Ad> getAdsFavourites() {
		return adsFavourites;
	}

	// Setters
	// ---------------------------------------------------------------------------------------
	
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public void setImageUser(Img imageUser) {
		this.imageUser = imageUser;
	}

	public void setAds(Set<Ad> ads) {
		this.ads = ads;
	}

	public void setAdsFavourites(Set<Ad> adsFavourites) {
		this.adsFavourites = adsFavourites;
	}
}
