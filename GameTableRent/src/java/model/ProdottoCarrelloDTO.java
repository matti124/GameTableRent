package model;

public class ProdottoCarrelloDTO {
	private final int id_carrello;
	private  int id_prodotto;
	private  int quantita;
	private  int giorni;
	private double prezzo;
	private double prezzoXdays;
	private byte[] image;
	private final String name;
	
	
	public ProdottoCarrelloDTO(int id_carrello, int id_prodotto, double prezzo,
			double prezzoXdays, int quantita, int giorni, byte[] bs, String nome ) {

		super();
		this.id_carrello = id_carrello;
		this.id_prodotto = id_prodotto;
		this.quantita = quantita;
		this.giorni = giorni;
		this.prezzo = prezzo;
		this.prezzoXdays = prezzoXdays;
		this.setImage(bs);
		this.name=nome;
		
	}


	
	
	@Override
	public String toString() {
		return "ProdottoCarrelloDTO [id_carrello=" + id_carrello + ", id_prodotto=" + id_prodotto + ", quantita="
				+ quantita + ", giorni=" + giorni + ", prezzo=" + prezzo + ", prezzoXdays=" + prezzoXdays + "]";
	}




	public double getPrezzo() {
		return prezzo;
	}




	public double getPrezzoXdays() {
		return prezzoXdays;
	}




	public int getId_carrello() {
		return id_carrello;
	}
	
	public int getId_prodotto() {
		return id_prodotto;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public int getGiorni() {
		return giorni;
	}
	

	public void addQuantity() {
		this.quantita++;
	}
	public void decreaseQuantity() {
		this.quantita--;
	}
	
	public void setQuantity(int x) {
		this.quantita=x;
	}


	@Override
	public boolean equals(Object obj) {
		ProdottoCarrelloDTO x=(ProdottoCarrelloDTO) obj;
		return (this.id_prodotto==x.id_prodotto && this.id_carrello==x.id_carrello&& this.giorni==x.giorni);
	}




	public void setDays(int giorni) {
		this.giorni=giorni;
	}




	public byte[] getImage() {
		return image;
	}




	public void setImage(byte[] image) {
		this.image = image;
	}




	public String getName() {
		return name;
	}
	
	
	
}
