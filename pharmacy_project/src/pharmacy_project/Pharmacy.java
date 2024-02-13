package pharmacy_project;

import java.util.ArrayList;
import java.util.List;
import enums.TransactionStatus;
import exceptions.CanNotReversedException;
import exceptions.CountOutOfBoundException;
import exceptions.EmptyListException;
import exceptions.MedicineNotFoundException;

public class Pharmacy {
	List<Medicine> listOfMedicines;
	List<Medicine> listOfSaledMedicines;
	List<Transaction> listOfTransactions;
	public static int id;
	Validator validator = new Validator();

	public Pharmacy() {
		this.listOfMedicines = new ArrayList<>();
		this.listOfSaledMedicines = new ArrayList<>();
		this.listOfTransactions = new ArrayList<>();
	}

	Medicine med = new Medicine();

	public void getMedicineInventory() {
		if (!listOfMedicines.isEmpty()) {
			for (Medicine allOfMedicines : listOfMedicines) {
				System.out.println("Medicine ID: " + allOfMedicines.getId() + " -- Medicine name: "
						+ allOfMedicines.getName() + " -- Medicine price: " + allOfMedicines.getPrice()
						+ " AZN -- Medicine count: " + allOfMedicines.getCount());
			}
		} else {
			try {
				throw new EmptyListException("There is no medicine in the pharmacy");
			} catch (EmptyListException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public Medicine searchMedicine(String medicineName) {
		for (Medicine medicine : listOfMedicines) {
			if (medicine.getName().equalsIgnoreCase(medicineName)) {
				med = medicine;
				return med;
			}
		}
		return null;
	}

	public void addMedicine(Medicine medicine) {
		if (searchMedicine(medicine.getName()) == null) {
			listOfMedicines.add(medicine);

		} else {
			System.out.println("This medicine ( " + medicine.getName()
					+ " ) is exist.The number of medicine was increased by " + medicine.getCount() + " units");
			med.setCount(med.getCount() + medicine.getCount());
		}
	}

	public void sellMedicine(String medicine, int id) {
		Pharmacy.id++;
		Transaction transaction = new Transaction();
		transaction.setUserId(id);
		Medicine selectedMedicine = searchMedicine(medicine);
		Medicine saledMedicine = findSaledMedicine(medicine);
		try {
			if (selectedMedicine != null) {
				if (selectedMedicine.getCount() > 0) {
					if (saledMedicine == null) {
						saledMedicine = new Medicine(selectedMedicine.getId(), selectedMedicine.getName(),
								selectedMedicine.getPrice(), 1);
						listOfSaledMedicines.add(saledMedicine);
					} else {
						saledMedicine.setCount(saledMedicine.getCount() + 1);
					}
					selectedMedicine.setCount(selectedMedicine.getCount() - 1);
					transaction.setStatus(TransactionStatus.SUCCESS);
				} else {
					try {
						transaction.setStatus(TransactionStatus.FAILED);
						throw new CountOutOfBoundException("The medicine has run out");
					} catch (CountOutOfBoundException e) {
						System.err.println(e.getMessage());
					}
				}
				transaction.setId(Pharmacy.id);
				transaction.setAmount(saledMedicine.getPrice());
				transaction.setMedicineName(saledMedicine.getName());
			} else {
				transaction.setStatus(TransactionStatus.FAILED);
				throw new MedicineNotFoundException("This medicine ( " + medicine + " ) is not exist and cannot saled");
			}
		} catch (MedicineNotFoundException e) {
			System.err.println(e.getMessage());
		}
		listOfTransactions.add(transaction);
	}

	private Medicine findSaledMedicine(String medicine) {
		for (Medicine med : listOfSaledMedicines) {
			if (med.getName().equalsIgnoreCase(medicine)) {
				return med;
			}
		}
		return null;
	}

	public void removeMedicine(String name) {
		if (searchMedicine(name) != null) {
			listOfMedicines.remove(searchMedicine(name));
			System.out.println("The medicine (" + name + " ) was removed from the list");
		} else {
			try {
				throw new MedicineNotFoundException("This medicine ( " + name + " ) is not exist and cannot remove");
			} catch (MedicineNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public int sumOfSaledMedicinesPrice(String medicineName) {
		int totalValue = 0;

		for (Medicine saledMedicine : listOfSaledMedicines) {
			if (saledMedicine.getName().equals(medicineName)) {
				totalValue += saledMedicine.getCount() * saledMedicine.getPrice();
			}
		}

		return totalValue;
	}

	private int sumOfPrice = 0;

	public int totalSaledMedicinesPrice() {
		for (Transaction tr : listOfTransactions) {
			if (tr.getStatus() == TransactionStatus.SUCCESS)
				sumOfPrice += tr.getAmount();
		}
		System.out.print("Sum of all saled medicines price: ");
		return sumOfPrice;
	}

	public List<Transaction> getTransactionsByUserId(int userId) {
		List<Transaction> userTransactions = new ArrayList<>();
		for (Transaction tr : listOfTransactions) {
			if (tr.getUserId() == userId) {
				userTransactions.add(tr);
			}
		}
		return userTransactions;
	}

	public List<Transaction> getTransactionsByStatus(TransactionStatus status) {
		List<Transaction> transactions = new ArrayList<>();
		for (Transaction tr : listOfTransactions) {
			if (tr.getStatus() == status) {
				transactions.add(tr);
			}
		}

		return transactions;
	}

	public void reverseTransaction(int transactionId) {
		for (Transaction tr : listOfTransactions) {
			if (tr.getId() == transactionId && tr.getStatus() == TransactionStatus.SUCCESS) {
				Medicine saledMedicine = findSaledMedicine(tr.getMedicineName());
				Medicine medicine = searchMedicine(tr.getMedicineName());
				tr.setStatus(TransactionStatus.REVERSED);
				if (saledMedicine.getCount() == 1) {
					listOfSaledMedicines.remove(saledMedicine);
				} else {
					saledMedicine.setCount(saledMedicine.getCount() - 1);
				}
				saledMedicine.setCount(saledMedicine.getCount());
				if (medicine != null)
					medicine.setCount(medicine.getCount() + 1);
				break;
			} else if (tr.getId() == transactionId && tr.getStatus() == TransactionStatus.FAILED) {
				try {
					throw new CanNotReversedException("This transaction status is failed and cannot reversed");
				} catch (CanNotReversedException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

	public List<Medicine> filteredByPrice(int minPrice, int maxPrice) {
		validator.priceValidation(minPrice, maxPrice);
		List<Medicine> filteredMedicine = new ArrayList<>();
		for (Medicine medicine : listOfMedicines) {
			if (medicine.getPrice() >= minPrice && medicine.getPrice() <= maxPrice) {
				filteredMedicine.add(medicine);
			}
		}
		return filteredMedicine;
	}
}
