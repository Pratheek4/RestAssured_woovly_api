package resource;

public enum ApiResource {
	// Login
	LoginChekIfUserExistes("checkIfUserExists"),
	LoginaddAllTypeUser("addAllTypeUser"),
	
	// Cart Flow
	AddToCart("order/addtocart"),
	FecthCartDetails("fetchCartDetails");
	
	
	private String resource;
	
	ApiResource(String resource) {
		this.resource = resource;
	}
	
	public String getApi() {
		return resource;
	}
}
