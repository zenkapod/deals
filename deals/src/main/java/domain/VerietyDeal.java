package domain;

public class VerietyDeal {
	
	// Идентификатор должности
	private Long id;
	// Наименование должности
	private String nameveriety;
	public VerietyDeal() {
	}
	public VerietyDeal(String nameveriety) {
	this.nameveriety = nameveriety;
	}
	public VerietyDeal(Long id, String nameveriety) {
	this.id = id;
	this.nameveriety = nameveriety;
	}
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
	this.id = id;
	}
	public String getNameveriety() {
	return nameveriety;
	}
	public void setNameveriety(String nameveriety) {
	this.nameveriety = nameveriety;
	}
	@Override
	public String toString() {
	return "VerietyDeal {" + "Id = " + id + ", NameVeriety = " + nameveriety
	+ "}";
	}
}


