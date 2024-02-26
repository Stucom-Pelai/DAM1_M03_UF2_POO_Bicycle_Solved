package main;

import java.util.Scanner;

import model.Bicycle;

public class TestBicycle {
	Bicycle [] bicycles = new Bicycle[10];
	int numberBicycles=0;
	
	
	public static void main(String[] args) {
		TestBicycle test = new TestBicycle();
		
		// show main menu
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		boolean exit = false;

		do {
			System.out.println("\n");
			System.out.println("===========================");
			System.out.println("Menu principal myBike.com");
			System.out.println("===========================");
			System.out.println("1) Crear bicicleta");
			System.out.println("2) Mostrar bicicleta");
			System.out.println("3) Modificar datos bicicleta");
			System.out.println("4) Modificar modelo bicicleta");
			System.out.println("5) Salir programa");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				test.createBicycle();
				break;

			case 2:
				test.showBicycle();
				break;

			case 3:
				test.updateBicycleData();
				break;

			case 4:
				test.updateBicyclePersonalData();
				break;
			
			case 5:
				exit = true;
				break;
			}

		} while (!exit);
	}

	/**
	 * create a new bicycle
	 */
	private void createBicycle() {
		// TODO Auto-generated method stub
		System.out.println("===========================");
		System.out.println("1) Crear bicicleta con todos los datos");
		System.out.println("2) Crear bicicleta con datos personales");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Seleccione una opcion: ");
		int option = Integer.valueOf(scanner.next());
		
		
		switch (option) {
		case 1:
			addCompleteBicycle();
			break;
			
		case 2:
			addBasicBicycle();			
			break;

		default:
			break;
		}
	}

	/**
	 * add a bicycle with all data
	 */
	private void addCompleteBicycle() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduzca codigo: ");
		String code = scanner.next();
		
		System.out.print("Introduzca fecha en año(AAAA): ");
		int date = Integer.valueOf(scanner.next());
		
		System.out.print("Introduzca electrica (S), (N): ");
		String isElectric = scanner.next();
		boolean electric=false;
		if(isElectric.equalsIgnoreCase("S")) {
			electric=true;
		}else {
			electric=false;
		}
		
		int i=0;
		double []distances =  new double[4];
		do {
			System.out.print("Introduzca distancia parkings: ");
			System.out.print("0.0 para finalizar.");
			
			double distance = Double.valueOf(scanner.next());
			
			if (distance==0.0) {
				break;
			}
			distances[i]=distance;
			
		} while (i<4);
							
		bicycles[numberBicycles]=new Bicycle(code, date, distances, electric);
		numberBicycles++;
	}

	/**
	 * add a bicycle with pesonal data
	 */
	private void addBasicBicycle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca codigo: ");
		String code = scanner.next();
		
		System.out.print("Introduzca fecha en año(AAAA): ");
		int date = Integer.valueOf(scanner.next());
		
		bicycles[numberBicycles]=new Bicycle(code, date);
		numberBicycles++;
	}

	/**
	 * show all bicycle data
	 */
	private void showBicycle() {
		// TODO Auto-generated method stub
		String isElectric="";
		double distance=0.0;
		double []distances=new double[4];
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca codigo bicicleta: ");
		String code = scanner.next();
		
		Bicycle bicycle = findBicycle(code);
		
		if (bicycle != null) {
			bicycle.showData();

		} else {
			System.out.println("No se ha encontrado la bicleta con codigo " + code);
		}
	}


	/**
	 * update any bicycle data
	 */
	private void updateBicycleData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca codigo bicicleta: ");
		String code = scanner.next();
		
		Bicycle bicycle = findBicycle(code);
		
		if (bicycle != null) {
			bicycle.showData();
			int option=0;
			do {
				System.out.print("Introduzca dato a modificar: ");
				System.out.print("1) Fecha fabricacion: ");
				System.out.print("2) Modelo electrico o normal: ");
				System.out.print("3) Distancia entre parkings: ");
				System.out.print("0 para finalizar.");
				
				option = Integer.valueOf(scanner.next());
				
				switch (option) {
				case 1:
					System.out.print("Introduzca nuevo valor: ");
					bicycle.setCode(scanner.next());
					break;
					
				case 2:
					System.out.print("Introduzca nuevo valor: ");
					bicycle.setDate(Integer.valueOf(scanner.next()));
					break;

				case 3:
					System.out.print("Introduzca numero parking: ");
					int number = Integer.valueOf(scanner.next());
					System.out.print("Introduzca nuevo valor: ");
					bicycle.setParking(number, Double.valueOf(scanner.next()));
					break;

				default:
					break;
				}
				
				
			} while (option==0);

		} else {
			System.out.println("No se ha encontrado la bicleta con codigo " + code);
		}		
	}

	/**
	 * update only personal data
	 */
	private void updateBicyclePersonalData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduzca codigo bicicleta: ");
		String code = scanner.next();
		
		Bicycle bicycle = findBicycle(code);
		
		if (bicycle != null) {
			bicycle.showData();
			int option=0;
			do {
				System.out.print("Introduzca dato a modificar: ");
				System.out.print("1) Fecha fabricacion: ");
				System.out.print("2) Modelo electrico o normal: ");
				System.out.print("0 para finalizar.");
				
				option = Integer.valueOf(scanner.next());
				
				switch (option) {
				case 1:
					System.out.print("Introduzca nuevo valor: ");
					bicycle.setCode(scanner.next());
					break;
					
				case 2:
					System.out.print("Introduzca nuevo valor: ");
					bicycle.setDate(Integer.valueOf(scanner.next()));
					break;

				default:
					break;
				}
				
				
			} while (option==0);

		} else {
			System.out.println("No se ha encontrado la bicleta con codigo " + code);
		}
		
	}
	
	/**
	 * @param code of bicycle to find
	 * @return bicycle object if found
	 */
	private Bicycle findBicycle(String code) {
		// TODO Auto-generated method stub
		for (int i = 0; i < bicycles.length; i++) {
			if (bicycles[i] != null && bicycles[i].getCode().equalsIgnoreCase(code)) {
				return bicycles[i];
			}
		}
		return null;
	}
}
