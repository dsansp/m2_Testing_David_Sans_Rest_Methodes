package com.example.m2_Testing_David_Sans_Rest_Methodes;

import com.example.m2_Testing_David_Sans_Rest_Methodes.entities.Perro;
import com.example.m2_Testing_David_Sans_Rest_Methodes.repositories.PerroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;



@SpringBootApplication
public class M2TestingDavidSansRestMethodesApplication implements CommandLineRunner {
	@Autowired
	PerroRepository repository;

	public static void main(String[] args) {


		SpringApplication.run(M2TestingDavidSansRestMethodesApplication.class, args);
	}

	public void menuShow() {
		System.out.println("Bienvenidos a la APP del centro de Adopción: ");
		System.out.println("0- Salir: ");
		System.out.println("1- Crear nuevo registro: ");
		System.out.println("2- Modificar por Id: ");
		System.out.println("3- Buscar: ");
		System.out.println("4- Borrar por Id: ");
		System.out.println("5- Borrar todos los registros: ");
	}

	public void subMenu() {
		System.out.println("0- Salir: ");
		System.out.println("1- Buscar todos: ");
		System.out.println("2- Buscar por Id: ");
		System.out.println("3- Buscar por Código de Chip: ");
		System.out.println("4- Buscar por Nombre: ");
		System.out.println("5- Buscar por Raza: ");
		System.out.println("6- Buscar por Sexo: ");
		System.out.println("7- Buscar por Peso: ");
		System.out.println("8- Buscar por si necesita licencia de perro peligroso: ");
		System.out.println("9- Buscar por numero de veces que ha sido adoptado: ");
		System.out.println("10- Consultar el numero de registros: ");
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			menuShow();
			try {
				int opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion == 0) {
					System.out.println("Hasta la próxima");
					break;
				} else if (opcion == 1) {
					crear();
				} else if (opcion == 2) {
					update();


				} else if (opcion == 3) {
					System.out.println("ha elegido la opción buscar: ");

					while (true) {
						subMenu();
						scanner = new Scanner(System.in);
						int subOpcion = scanner.nextInt();
						scanner.nextLine();
						if (subOpcion == 0) {
							System.out.println("volver al menu principal");
							break;
						} else if (subOpcion == 1) {
							mostrarTodos();


						} else if (subOpcion == 2) {
							buscarId();
						} else if (subOpcion == 3) {
							buscarChip();
						} else if (subOpcion == 4) {
							buscarNombre();
						} else if (subOpcion == 5) {
							buscarRaza();
						} else if (subOpcion == 6) {
							buscarSexo();

						} else if (subOpcion == 7) {
							pesoMax();

						} else if (subOpcion == 8) {
							buscarLicencia();

						} else if (subOpcion == 9) {
							buscarAdop();

						} else if (subOpcion == 10) {
							Long numero = repository.count();
							System.out.println("Ha escogido la opción consultar el numero de registros " + numero);
						} else {
							System.out.println("Opción no disponible");
						}
					}
				} else if (opcion == 4) {
					borrarPerro();
				} else if (opcion == 5) {
					System.out.println("Esto borrará todos los registros de los Perros, ¿está seguro? (true o false)");
					boolean confirm = scanner.nextBoolean();

					if (!confirm) continue;

					repository.deleteAll();
					System.out.println("Registros borrados correctamente");


				} else {
					System.out.println("Opción no disponible");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private void borrarPerro() {
		System.out.println("Introduzca el id del perro que desea borrar");
		Scanner scanner = new Scanner(System.in);
		Long id = scanner.nextLong();
		boolean exists = repository.existsById(id);
		if (exists) {
			repository.deleteById(id);
			System.out.println("Registro del perro borrado");
		} else {
			System.out.println("No existe el animal solicitado");
	}

}

	private void buscarAdop() {
		System.out.println("Introduce el numero maximo de adopciones a buscar: ");
		Scanner scanner = new Scanner(System.in);
		Integer adopciones = scanner.nextInt();
		scanner.nextLine();
		for (Perro animal : repository.findByAdopcionesLessThan(adopciones))
			System.out.println(animal);
	}

	private void buscarLicencia() {
		System.out.println("Introduce si desea buscar si es necesaria licencia de perro peligroso: ");
		Scanner scanner = new Scanner(System.in);
		Boolean licencia = scanner.nextBoolean();
		scanner.nextLine();
		for (Perro animal : repository.findByLicencia(licencia))
			System.out.println(animal);
	}

	private void pesoMax() {
		System.out.println("Introduce el peso maximo a buscar: ");
		Scanner scanner = new Scanner(System.in);
		Double peso = scanner.nextDouble();
		scanner.nextLine();
		for (Perro animal : repository.findByPesoLessThan(peso))
			System.out.println(animal);
	}

	private void buscarSexo() {
		System.out.println("Introduce el sexo a buscar: ");
		Scanner scanner = new Scanner(System.in);
		String sexo = scanner.nextLine();
		for (Perro animal : repository.findBySexoIgnoreCase(sexo))
			System.out.println(animal);
	}

	private void buscarRaza() {
		System.out.println("Introduce una raza a buscar: ");
		Scanner scanner = new Scanner(System.in);
		String raza = scanner.nextLine();
		for (Perro animal : repository.findByRazaIgnoreCase(raza))
			System.out.println(animal);
	}

	private void buscarNombre() {
		System.out.println("Introduce un nombre a buscar: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		for (Perro animal : repository.findByNameIgnoreCase(name))
			System.out.println(animal);
	}

	private void buscarChip() {
		System.out.println("Introduce un código de chip a buscar: ");
		Scanner scanner = new Scanner(System.in);
		String chip = scanner.nextLine();
		for (Perro animal : repository.findByChipIgnoreCase(chip))
			System.out.println(animal);
	}

	private void buscarId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca la Id a buscar: ");
		Long id = scanner.nextLong();
		scanner.nextLine();
		Optional<Perro> perroOptional = repository.findById(id);
		if (perroOptional.isPresent()) {
			Perro animal = perroOptional.get();
			System.out.println(animal);
		} else {
			System.out.println("No existe el perro seleccionado");
		}
	}

	private void mostrarTodos() {
		System.out.println("Mostrar todos: ");
		List<Perro> perro = repository.findAll();
		if (perro.isEmpty()) {
			System.out.println("No hay animales disponibles.");
		} else {
			System.out.println(perro);
	}}



	public void crear() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el código del chip");
		String chip = scanner.nextLine();
		System.out.println("Introduce el nombre del animal");
		String name = scanner.nextLine();
		System.out.println("Introduce la raza");
		String raza = scanner.nextLine();
		System.out.println("Introduce el sexo");
		String sexo = scanner.nextLine();
		System.out.println("Introduce el peso");
		Double peso = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Introduce si necesita licencia de perro peligroso");
		Boolean licencia = scanner.nextBoolean();
		scanner.nextLine();
		System.out.println("Introduce el numero de veces que ha sido adoptado");
		Integer adopciones = scanner.nextInt();
		scanner.nextLine();

		Perro animal = new Perro(null, chip, name, raza, sexo, peso, licencia, adopciones);
		repository.save(animal);
		System.out.println("el registro se ha creado correctamente");

	}

	public  void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Por favor, introduzca el id del perro que desea modificar");
		Long id = scanner.nextLong();
		scanner.nextLine();
		Optional<Perro> perroOptional = repository.findById(id);
		if (perroOptional.isEmpty()) {
			System.out.println("No existe el animal solicitado");
		} else {
			Perro perro = perroOptional.get();
			System.out.println("Introduce el código del chip: (Actual  " + perro.getChip() + " )");
			String chip = scanner.nextLine();
			perro.setChip(chip);
			System.out.println("Introduce el nombre: (Actual  " + perro.getName() + " )");
			String name = scanner.nextLine();
			perro.setName(name);
			System.out.println("Introduce la raza: (Actual  " + perro.getRaza() + " )");
			String raza = scanner.nextLine();
			perro.setRaza(raza);
			System.out.println("Introduce el sexo: (Actual  " + perro.getSexo() + " )");
			String sexo = scanner.nextLine();
			perro.setSexo(sexo);
			System.out.println("Introduce el peso: (Actual  " + perro.getPeso() + " )");
			Double peso = scanner.nextDouble();
			scanner.nextLine();
			perro.setPeso(peso);
			System.out.println("Introduce si es necesaria la licencia: (Actual " + perro.getLicencia() + " )");
			Boolean licencia = scanner.nextBoolean();
			scanner.nextLine();
			perro.setLicencia(licencia);
			System.out.println("Introduce el numero de adopciones: (Actual  " + perro.getAdopciones() + " )");
			Integer adopciones = scanner.nextInt();
			scanner.nextLine();
			perro.setAdopciones(adopciones);
			repository.save(perro);
			System.out.println("Registro actualizado correctamente");
		}
	}
}


