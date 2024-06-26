package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class OrdineDTO {
	
	private  int id_Ordine;
	private final int id_utente;
	private final Timestamp data;
	private final ArrayList<ProdottoOrdineDTO> prodotti;
	
	
	
	public OrdineDTO(int id_Ordine, int idUt, Timestamp data_ordine,  ArrayList<ProdottoOrdineDTO> prods) {
		super();
		this.id_Ordine = id_Ordine;
		this.id_utente = idUt;
		this.data = data_ordine;
		this.prodotti=prods;
	}

public void setId_Ordine(int x) {
	this.id_Ordine=x;
	
}
	
	public int getId_Ordine() {
		return id_Ordine;
	}



	public int getIdUtente() {
		return id_utente;
	}



	public Timestamp getData() {
		return data;
	}





	public ArrayList<ProdottoOrdineDTO> getProdotti(){
		return this.prodotti;
	}
	
	public double getTotalPrice() {
		double tot=0;
		for(ProdottoOrdineDTO x: this.prodotti) {
			if(x.getGiorni()>0)
				tot+=x.getPrezzoXdays()*x.getQuantity()*x.getGiorni();
			else 
				tot+=x.getPrezzo()*x.getQuantity();
		}
		return tot;
	}
}
