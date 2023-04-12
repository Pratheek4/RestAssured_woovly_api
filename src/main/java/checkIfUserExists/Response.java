package checkIfUserExists;

public class Response {
	
		  Error ErrorObject;
		  private boolean isExisting;


		 // Getter Methods 

		  public Error getError() {
		    return ErrorObject;
		  }

		  public boolean getIsExisting() {
		    return isExisting;
		  }

		 // Setter Methods 

		  public void setError( Error errorObject ) {
		    this.ErrorObject = errorObject;
		  }

		  public void setIsExisting( boolean isExisting ) {
		    this.isExisting = isExisting;
		  }
	}


