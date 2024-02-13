package pharmacy_project;

import java.util.ArrayList;
import java.util.List;

import enums.TransactionStatus;

public class Main {

	public static void main(String[] args) {
		Medicine antibiotik = new Medicine(1, "Antibiotik", 39, 1);
		Medicine suprastin1 = new Medicine(2, "Suprastin", 5, 10);
		Medicine griphot1 = new Medicine(3, "Griphot", 1, 5);
		Medicine suprastin2 = new Medicine(3, "Suprastin", 26, 15);
		Medicine griphot2 = new Medicine(3, "Griphot", 1, 10);
		Medicine antibiotik2 = new Medicine(5, "Antibiotik", 39, 5);
		
		Pharmacy pharmacy = new Pharmacy();
		User user = new User(1, "James");
		User user2 = new User(2, "John");
		
		pharmacy.getMedicineInventory();
		pharmacy.addMedicine(antibiotik);
		pharmacy.addMedicine(suprastin1);
		pharmacy.addMedicine(griphot1);
		pharmacy.addMedicine(suprastin2);
		pharmacy.addMedicine(griphot2);
		
		pharmacy.getMedicineInventory();
		System.out.println(pharmacy.searchMedicine("Antibiotik"));
		
		pharmacy.sellMedicine("Antibiotik", user.getId());
		pharmacy.sellMedicine("Suprastin", user.getId());
		pharmacy.sellMedicine("Suprastin", user.getId());
		pharmacy.sellMedicine("Antibiotik", user.getId());
		pharmacy.sellMedicine("Antibiotik", user2.getId());
		pharmacy.addMedicine(antibiotik2);
//		pharmacy.removeMedicine("Antibiotik");

		pharmacy.sellMedicine("Suprastin", user.getId());
		pharmacy.sellMedicine("Suprastin", user.getId());
		pharmacy.sellMedicine("Griphot", user.getId());
		pharmacy.sellMedicine("Griphot", user.getId());
//		pharmacy.sellMedicine("Suprastn", user.getId());
		pharmacy.reverseTransaction(1);

		List<Transaction> userTransactions = pharmacy.getTransactionsByUserId(2);

		System.out.println("------------listOfSaledMedicines----------");
		for (Medicine med : pharmacy.listOfSaledMedicines) {
			System.out.println("Saled medicines: " + med.getName() + " -- Count: " + med.getCount()
					+ " -- Total price: " + pharmacy.sumOfSaledMedicinesPrice(med.getName()));
		}
		
		System.out.println("----------listOfMedicines---------");
		for (Medicine med : pharmacy.listOfMedicines) {
			System.out.println("Medicine name: " + med.getName() + " -- Count: " + med.getCount());
		}
		
		System.out.println("----------listOfTransactions----------");
		for (Transaction tr : pharmacy.listOfTransactions) {
			System.out.println("TR_id: " + tr.getId() + " -- Medicine name: " + tr.getMedicineName() + " -- Amount: "
					+ tr.getAmount() + " -- Tansaction status: " + tr.getStatus());
		}

		System.out.println(pharmacy.totalSaledMedicinesPrice());

		System.out.println("------------USER ID----------");
		for (Transaction tr : userTransactions) {
			System.out.println(tr);
		}

		System.out.println("--------FilteredByPrice-----------");

		System.out.println(pharmacy.filteredByPrice(3, 40));
		pharmacy.getMedicineInventory();
	}

}
