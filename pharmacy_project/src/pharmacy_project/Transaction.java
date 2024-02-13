package pharmacy_project;

import enums.TransactionStatus;

public class Transaction {
	private int id;
	private int amount;
	private TransactionStatus status;
	private String medicineName;
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", status=" + status + ", medicineName=" + medicineName
				+ ", userId=" + userId + "]\n";
	}

}
