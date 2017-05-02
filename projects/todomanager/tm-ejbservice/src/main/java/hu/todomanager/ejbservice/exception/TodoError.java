package hu.todomanager.ejbservice.exception;

public enum TodoError {

	IDENTIFIER(10),
	PERSISTENCE(20),
	PRODUCT(30);

	private int code;

	private TodoError(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

}
