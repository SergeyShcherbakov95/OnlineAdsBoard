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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sergey.shcherbakov
 *
 */

@Entity
@Table( name = "Categories")
public class Category {
	
	// Fields
	// -----------------------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "idCategory")
	private Integer idCategory;
	
	@Column(name = "category")
	private String categoryName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idImage", nullable=true)
	private Img imageCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idParentCategory", nullable=true)
	private Category parentCategory;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCategory")
	private Set<Category> subcategories = new HashSet<Category>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adCategory")
	private Set<Ad> adsCategory = new HashSet<Ad>();

	// Constructors
	// -----------------------------------------------------------------------------------------

	public Category(){
			
	}

	public Category(String categoryName, Img imageCategory, Category parentCategory) {
		super();
		this.categoryName = categoryName;
		this.imageCategory = imageCategory;
		this.parentCategory = parentCategory;
	}

	// Getters
	// -----------------------------------------------------------------------------------------
	
	public Integer getIdCategory() {
		return idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Img getImageCategory() {
		return imageCategory;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public Set<Category> getSubcategories() {
		return subcategories;
	}

	public Set<Ad> getAdsCategory() {
		return adsCategory;
	}
	
	// Setters
	// -----------------------------------------------------------------------------------------

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setImageCategory(Img imageCategory) {
		this.imageCategory = imageCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public void setSubcategories(Set<Category> subcategories) {
		this.subcategories = subcategories;
	}

	public void setAdsCategory(Set<Ad> adsCategory) {
		this.adsCategory = adsCategory;
	}
}
