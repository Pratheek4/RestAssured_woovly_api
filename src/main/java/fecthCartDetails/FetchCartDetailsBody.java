package fecthCartDetails;

public class FetchCartDetailsBody {

		  private String coupon_id;
		  private String coupon_title;
		  private boolean is_coins_apply;
		  private String payment_mode;


		 // Getter Methods 

		  public String getCoupon_id() {
		    return coupon_id;
		  }

		  public String getCoupon_title() {
		    return coupon_title;
		  }

		  public boolean getIs_coins_apply() {
		    return is_coins_apply;
		  }

		  public String getPayment_mode() {
		    return payment_mode;
		  }

		 // Setter Methods 

		  public void setCoupon_id( String coupon_id ) {
		    this.coupon_id = coupon_id;
		  }

		  public void setCoupon_title( String coupon_title ) {
		    this.coupon_title = coupon_title;
		  }

		  public void setIs_coins_apply( boolean is_coins_apply ) {
		    this.is_coins_apply = is_coins_apply;
		  }

		  public void setPayment_mode( String payment_mode ) {
		    this.payment_mode = payment_mode;
		  }
		
}
