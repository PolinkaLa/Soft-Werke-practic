package exception;

public class ValidationException extends Exception {
	private static final long serialVersionUID = 1L;
	public ValidationException(){
		super();
	}
	public ValidationException(String textError) {
		super(textError);
	}
	public void showError() {
		System.out.println("You enter incorrect information!");
	}
	
}

