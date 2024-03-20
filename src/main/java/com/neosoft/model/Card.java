package com.neosoft.model;



import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Card {
    @Id
    private Long card_no;
    private String card_name;
    private String card_type;
    private int cvv;
    
    
	public Card() {
		super();
	}
	public Card(Long card_no, String card_name, String card_type, int cvv) {
		super();
		this.card_no = card_no;
		this.card_name = card_name;
		this.card_type = card_type;
		this.cvv = cvv;
	}
	public Long getCard_no() {
		return card_no;
	}
	public void setCard_no(Long card_no) {
		this.card_no = card_no;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
    
    
}
