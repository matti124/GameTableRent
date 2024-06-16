package model;

import java.util.ArrayList;

public class CarrelloDTO {
	private final int ID_Carrello;
	private ArrayList <ProdottoCarrelloDTO> Cart;
	
	
	public CarrelloDTO(int iD_Carrello, ArrayList<ProdottoCarrelloDTO> prodottiInCart) {
		super();
		ID_Carrello = iD_Carrello;
		Cart = prodottiInCart;
	}


	public int getID_Carrello() {
		return ID_Carrello;
	}


	public ArrayList<ProdottoCarrelloDTO> getProdottiInCart() {
		return Cart;
	}
	
	
	public ProdottoCarrelloDTO retrieveById(int id_c , int id_p) {	//in caso un elemento già fosse nel carrello lo ritorniamo
		for(ProdottoCarrelloDTO x : Cart) {
			if(x.getId_prodotto()==id_p && x.getId_carrello()==id_c)
				return x;
		}
		return null;
	}
	
	
	public void addProduct(ProdottoCarrelloDTO x) { //se un elemento non è nel carrello lo aggiungo oppure ne aumento la quantità
		if(this.retrieveById(x.getId_prodotto(), x.getId_carrello())==null)
			this.Cart.add(x);
		else x.addQuantity();
	}
	
	
	
	public void decreaseProduct(ProdottoCarrelloDTO x) {
		ProdottoCarrelloDTO prod=this.retrieveById(x.getId_prodotto(), x.getId_carrello());
		if(prod!=null)
			if(prod.getQuantita()==1) 
				this.Cart.remove(x);
			else x.decreaseQuantity();
	}
	

}