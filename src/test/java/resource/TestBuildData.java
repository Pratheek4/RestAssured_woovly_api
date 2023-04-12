package resource;

import addAllTypeUser.PayloadAddAllTypeUser;
import addAllTypeUser.PayloadAddAllTypeUser2;
import addProductToCart.AddToCart;
import addProductToCart.Parameter;
import checkIfUserExists.EmailPayload;
import checkIfUserExists.MobilePayload;
import fecthCartDetails.FetchCartDetailsBody;

public class TestBuildData {

	public EmailPayload checkIfUserExistsPayloadEmail(String newEmail) { // (String name, String address) -> If more are in the body param
	
		EmailPayload email = new EmailPayload();
		email.setEmail(newEmail);
		return email;
	}
	
	public MobilePayload checkIfUserExistsPayloadMobile(String mobile) { // (String name, String address) -> If more are in the body param
		
		MobilePayload mob = new MobilePayload();
		mob.setMobile(mobile);
		return mob;
	}
	
	public PayloadAddAllTypeUser addAllTypeUserPayload(String data, String token) { // (String name, String address) -> If more are in the body param
		
		PayloadAddAllTypeUser pay = new PayloadAddAllTypeUser();
		pay.setMobile(data);
		pay.setIdToken(token);
		return pay;
	}
	
	public PayloadAddAllTypeUser2 addAllTypeUserPayload2(String email, String password) { // (String name, String address) -> If more are in the body param
		
		PayloadAddAllTypeUser2 pay2 = new PayloadAddAllTypeUser2();
		pay2.setEmail(email);
		pay2.setPassword(password);
		return pay2;
	}
	
	public AddToCart addToCart(String product_id, int qty, String varient_is) {
		
		AddToCart atc = new AddToCart();
		atc.setProduct(product_id);
		atc.setQuantity(qty);
		atc.setVariant_id(varient_is);
		return atc;
	}
	
	public Parameter getAuthDetails(String user_Id, String token_Id) {
		
		Parameter p = new Parameter();
		p.setUserId(user_Id);
		p.setTokenId(token_Id);
		return p;
	}
	
	public FetchCartDetailsBody fetchCartDetails(String coupon_id, String coupon_title, boolean is_coins_apply, String payment_mode) {
		FetchCartDetailsBody fcd = new FetchCartDetailsBody();
			
			if(coupon_title.equalsIgnoreCase("null")) {
				fcd.setCoupon_title("");
			}
			else{
				fcd.setCoupon_title(coupon_title);
			}
			if(coupon_id.equalsIgnoreCase("null")) {
				fcd.setCoupon_id("");
			}
			else {
				fcd.setCoupon_id(coupon_id);
			}
			if(payment_mode.equalsIgnoreCase("null")) {
				fcd.setPayment_mode("");
			}
			else {
				fcd.setPayment_mode(payment_mode);
			}
			fcd.setIs_coins_apply(is_coins_apply);
			return fcd;
		
		}
}
