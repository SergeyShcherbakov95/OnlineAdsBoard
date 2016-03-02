package shcherbakov.sergey.onlineAdsBoard.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sergey.shcherbakov
 *
 */

@Entity
@Table( name = "Ads")
public class Ad {
	
	// Fields
	// -----------------------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "idAd")
	private Integer idAd;
	
	@Column( name = "title")
	private String title;
	
	@Column( name = "description")
	private String description;
	
	@Column( name = "views")
	private Integer views;
	
	@Column( name = "isActive")
	private Boolean isActive;
	
	@Column( name = "price")
	private Double price;
	
	@Column( name = "region")
	private String region;
	
	@Column( name = "city")
	private String city;
	
	@Column( name = "phoneNumber")
	private String phoneNumber;
	
	@ManyToOne
    @JoinColumn(name="idUser", nullable=false)
	private User userAd;
	
	@ManyToOne
    @JoinColumn(name="idCategory", nullable=true)
	private Category adCategory;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idImage", nullable=true)
	private Img adImage;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "AdsAndImages", joinColumns = { 
			@JoinColumn(name = "idAd", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "idImage", 
					nullable = false, updatable = false) })
	private Set<Img> adImages = new HashSet<Img>();
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "adsFavourites")
	private Set<User> usersFavourites = new HashSet<User>();

	// Constructors
		// -----------------------------------------------------------------------------------------

	public Ad(){
			
	}
	
	public Ad(String title, String description, Integer views, Boolean isActive, Double price, String region, String city,
			String phoneNumber, User userAd, Category adCategory, Img adImage) {
		super();
		this.title = title;
		this.description = description;
		this.views = views;
		this.isActive = isActive;
		this.price = price;
		this.region = region;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.userAd = userAd;
		this.adCategory = adCategory;
		this.adImage = adImage;
	}

	// Getters
	// -----------------------------------------------------------------------------------------
	
	public Integer getIdAd() {
		return idAd;
	}


	public String getTitle() {
		return title;
	}


	public String getDescription() {
		return description;
	}


	public Integer getViews() {
		return views;
	}


	public Boolean isActive() {
		return isActive;
	}


	public Double getPrice() {
		return price;
	}


	public String getRegion() {
		return region;
	}


	public String getCity() {
		return city;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public User getUserAd() {
		return userAd;
	}


	public Category getAdCategory() {
		return adCategory;
	}


	public Img getAdImage() {
		return adImage;
	}


	public Set<Img> getAdImages() {
		return adImages;
	}


	public Set<User> getUsersFavourites() {
		return usersFavourites;
	}

	// Setters
	// -----------------------------------------------------------------------------------------

	public void setIdAd(Integer idAd) {
		this.idAd = idAd;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setViews(Integer views) {
		this.views = views;
	}


	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setUserAd(User userAd) {
		this.userAd = userAd;
	}


	public void setAdCategory(Category adCategory) {
		this.adCategory = adCategory;
	}


	public void setAdImage(Img adImage) {
		this.adImage= adImage;
	}


	public void setAdImages(Set<Img> adImages) {
		this.adImages = adImages;
	}


	public void setUsersFavourites(Set<User> usersFavourites) {
		this.usersFavourites = usersFavourites;
	}
}








