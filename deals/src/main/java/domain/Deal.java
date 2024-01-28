package domain;

/**
* Класс для данных клиента
*/
public class Deal {
// Идентификатор 
 private Long id;

 private String ticker;
 
 private String ordertype;

 private String currency;


 // Внешний ключ 
 private Long idVeriety;

 // Навигационное свойства - ссылка на должность
 private VerietyDeal veriety;
 public Deal() {
}

 public Deal(String ticker, String ordertype,
 String currency, VerietyDeal veriety) {
 this.ticker = ticker;
 this.ordertype = ordertype;
 this.currency = currency;
 this.veriety = veriety;
 }

 public Deal(String ticker, String ordertype, 
 String currency, Long idVeriety, VerietyDeal veriety) {
 this.ticker = ticker;
 this.ordertype = ordertype;
 this.currency = currency;
 this.veriety = veriety;
 this.idVeriety = idVeriety;
 }

 public Deal(Long id, String ticker, String ordertype, String currency, Long idVeriety, VerietyDeal veriety) {
 this.id = id;
 this.ticker = ticker;
 this.ordertype = ordertype;
 this.currency = currency;
 this.veriety = veriety;
 this.idVeriety = idVeriety;
 }


public String getTicker() {
return ticker;
}
public void setTicker(String ticker) {
this.ticker = ticker;
}

public String getType() {
return ordertype;
}
public void setType(String ordertype) {
this.ordertype = ordertype;
}

public VerietyDeal veriety () {
return veriety;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getCurrency() {
return currency;
}
public void setCurrency(String currency) {
this.currency = currency;
}

public String getVeriety() {
return veriety.getNameveriety();
}
public void setVeriety(VerietyDeal veriety) {
this.veriety = veriety;
}
public Long getIdVeriety() {
return idVeriety;
}
public void setIdVeriety(Long idVeriety) {
this.idVeriety = idVeriety;
}
@Override
public String toString() {
return "VerietyDeal {" + "Id = " + id +
", ticker = " + ticker +
", ordertype = " + ordertype +
", currency = " + currency +
", nameveriety = " + getVeriety() +
"}";
}
}

