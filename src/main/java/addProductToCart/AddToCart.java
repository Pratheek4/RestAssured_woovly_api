package addProductToCart;

public class AddToCart {

		  private String product_id;
		  private int quantity;
		  private String variant_id;

		 // Getter Methods 

		  public String getProduct_id() {
		    return product_id;
		  }

		  public int getQuantity() {
		    return quantity;
		  }

		  public String getVariant_id() {
		    return variant_id;
		  }

		 // Setter Methods 

		  public void setProduct( String product_id ) {
		    this.product_id = product_id;
		  }

		  public void setQuantity( int quantity ) {
		    this.quantity = quantity;
		  }

		  public void setVariant_id( String variant_id ) {
		    this.variant_id = variant_id;
		  }
		
}
