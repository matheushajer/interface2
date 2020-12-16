package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date: ");
		Date date = sdf.parse(sc.next());		
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int installment = sc.nextInt();
		
		Contract contract = new Contract(number, date, value);
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract, installment);
		
		System.out.println();
		System.out.println("Installments:");
		
		for(Installments x : contract.getInstallment() ) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
