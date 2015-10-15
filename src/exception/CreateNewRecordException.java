package exception;

public class CreateNewRecordException extends Exception {
	private static final long serialVersionUID = 1L;
	public CreateNewRecordException(){
		super();
	}
	public CreateNewRecordException(String textError) {
		super(textError);
	}
	public void showError() {
		System.out.println("Failed to create a new entry, try to enter other data");
	}
}
