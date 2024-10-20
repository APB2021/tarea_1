package tarea_1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Alumno {

	// Constante para indicar el número de alumnos
	private static final int NUMERO_DE_ALUMNOS = 5;

	// Scanner declarado como static para no tener que cerrarlo:
	private static Scanner sc = new Scanner(System.in);

	// Utilizamos el genérico List para acceder a sus métodos:
	static List<Alumno> alumnos = new ArrayList<Alumno>();

	// Enumerado para elegir el criterio de ordenación:
	private enum Criterio {
		NIA, NOMBRE, APELLIDOS, GENERO, FECHA_NACIMIENTO, CICLO, CURSO, GRUPO
	};

	// Atributos privados de la clase Alumno
	private int nia = 0;
	private String nombre;
	private String apellidos;
	private char genero = 'S';
	private Date fechaNacimiento;
	private String ciclo;
	private String curso;
	private String grupo;

	// Constructores de la clase Alumno
	public Alumno() {
	}

	public Alumno(int nia, String nombre, String apellidos, char genero, Date fechaNacimiento, String ciclo,
			String curso, String grupo) {

		this.nia = nia;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.ciclo = ciclo;
		this.curso = curso;
		this.grupo = grupo;
	}

	// Getters & Setters:
	public int getNia() {
		return nia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "NIA: " + nia + " --> " + nombre + ", " + apellidos + " - Género: " + genero + " - Fecha de Nacimiento: "
				+ fechaNacimiento + " - Ciclo: " + ciclo + " - Curso: " + curso + " Grupo: " + grupo;
	}

	// Método para leer 1 alumno:
	public void leerAlumno() {

		// Limpiar el buffer:
		sc.nextLine();

		System.out.print("Introduzca el NOMBRE del alumno: ");
		nombre = sc.nextLine().toUpperCase();
		System.out.print("Introduzca los APELLIDOS del alumno: ");
		apellidos = sc.nextLine().toUpperCase();

		// Convertimos el char en String para poder manejarlo:
		String generoString = Character.toString(genero);

		while (!generoString.equalsIgnoreCase("H") && !generoString.equalsIgnoreCase("M")) {
			System.out.print("Introduzca el GÉNERO del alumno(H/M): ");
			genero = sc.nextLine().toUpperCase().charAt(0);
			generoString = Character.toString(genero);
		}

		/////////////// FECHA DE NACIMIENTO//////////////////////////////
		System.out.print("Introduzca la FECHA DE NACIMIENTO del alumno en formato (dd/MM/yyyy): ");
		String fechaNacimientoString = sc.nextLine();

		// Definir formato de fecha según el String:
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try {
			// Convertir el String en Date
			fechaNacimiento = formato.parse(fechaNacimientoString);
			// System.out.println("Fecha convertida: " + fecha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/////////////// FECHA DE NACIMIENTO//////////////////////////////
		System.out.print("Introduzca el CICLO del alumno: ");
		ciclo = sc.nextLine().toUpperCase();
		System.out.print("Introduzca el CURSO del alumno: ");
		curso = sc.nextLine().toUpperCase();
		System.out.print("Introduzca el GRUPO del alumno: ");
		grupo = sc.nextLine().toUpperCase();

		// Vamos añadiendo el nia secuencialmente incrementándolo en 1 unidad:
		nia = nia + 1;

		// Añadimos el alumno al ArrayList de alumnos:
		alumnos.add(new Alumno(nia, nombre, apellidos, genero, fechaNacimiento, ciclo, curso, grupo));

		System.out.println("------------------------------------------------------------");
		System.out.println("Se han leído los datos del alumno. ");
	}

	// Método para leer NUMERO_DE_ALUMNOS:
	public void leerAlumnos() {

		// Limpiar el buffer:
		sc.nextLine();

		for (int i = 0; i < NUMERO_DE_ALUMNOS; i++) {
			System.out.print("Introduzca el NOMBRE del alumno " + (i + 1) + ": ");
			nombre = sc.nextLine().toUpperCase();
			System.out.print("Introduzca los APELLIDOS del alumno: ");
			apellidos = sc.nextLine().toUpperCase();

			// Convertimos el char en String para poder manejarlo:
			String generoString = Character.toString(genero);

			while (!generoString.equalsIgnoreCase("H") && !generoString.equalsIgnoreCase("M")) {
				System.out.print("Introduzca el GÉNERO del alumno(H/M): ");
				genero = sc.nextLine().toUpperCase().charAt(0);
				generoString = Character.toString(genero);
			}

			/////////////// FECHA DE NACIMIENTO//////////////////////////////
			System.out.print("Introduzca la FECHA DE NACIMIENTO del alumno en formato (dd/MM/yyyy): ");
			String fechaNacimientoString = sc.nextLine();

			// Definir formato de fecha según el String:
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			try {
				// Convertir el String en Date
				fechaNacimiento = formato.parse(fechaNacimientoString);
				// System.out.println("Fecha convertida: " + fecha);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/////////////// FIN FECHA DE NACIMIENTO//////////////////////////////
			System.out.print("Introduzca el CICLO del alumno: ");
			ciclo = sc.nextLine().toUpperCase();
			System.out.print("Introduzca el CURSO del alumno: ");
			curso = sc.nextLine();
			System.out.print("Introduzca el GRUPO del alumno: ");
			grupo = sc.nextLine().toUpperCase();

			// Vamos añadiendo el nia secuencialmente incrementándolo en 1 unidad:
			nia = nia + 1;

			// Añadimos el alumno al ArrayList de alumnos:
			alumnos.add(new Alumno(nia, nombre, apellidos, genero, fechaNacimiento, ciclo, curso, grupo));
		}
		System.out.println("------------------------------------------------------------");
		System.out.println("Se han leído los datos de " + NUMERO_DE_ALUMNOS + " alumnos.");

		// Tras introducir los 5 alumnos, volvemos a mostar el menú al usuario
		mostrarMenu();
	}

	// Método para mostrar los alumnos ordenados en base a algún criterio:
	public void mostrarAlumnos(Criterio criterio) {

		System.out.println("-------------------");
		System.out.println("Listado de alumnos:");
		System.out.println("-------------------");

		switch (criterio) {
		case NIA -> {
			// Ordenar por NIA usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getNia() - a2.getNia());

			System.out.println("Listado de alumnos por NIA:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		case NOMBRE -> {
			// Ordenar por NOMBRE usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));

			System.out.println("Listado de alumnos por NOMBRE:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		case APELLIDOS -> {
			// Ordenar por APELLIDOS usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getApellidos().compareTo(a2.getApellidos()));

			System.out.println("Listado de alumnos por APELLIDOS:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		case GENERO -> {
			// Ordenar por GÉNERO usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getGenero() - (a2.getGenero()));

			System.out.println("Listado de alumnos por GENERO:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		case FECHA_NACIMIENTO -> {

			// Ordenar por FECHA_NACIMIENTO usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento()));

			System.out.println("Listado de alumnos por FECHA DE NACIMIENTO:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		case CICLO -> {
			// Ordenar por CICLO usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getCiclo().compareTo(a2.getCiclo()));

			System.out.println("Listado de alumnos por CICLO:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		case CURSO -> {
			// Ordenar por CURSO usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getCurso().compareTo(a2.getCurso()));

			System.out.println("Listado de alumnos por CURSO:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		case GRUPO -> {
			// Ordenar por GRUPO usando lambda
			Collections.sort(alumnos, (a1, a2) -> a1.getGrupo().compareTo(a2.getGrupo()));

			System.out.println("Listado de alumnos por GRUPO:");
			System.out.println("---------------------------");
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
		}

		default -> throw new IllegalArgumentException("Unexpected value: " + criterio);
		}

	}

	// Método para mostrar lso alumnos ordenados por su NIA:
	public void mostrarAlumnosNia() {

		// Ordenar por NIA usando lambda
		Collections.sort(alumnos, (a1, a2) -> a1.getNia() - a2.getNia());

		System.out.println("Listado de alumnos ordenados por su NIA:");
		System.out.println("----------------------------------------");
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
	}

	// Método para mostrar el menú de Alumnos:
	public void mostrarMenu() {

		int opcion = -1;
		String texto = "";

		do {

			texto = """
					==============================================
					           MENU DE ALUMNOS:
					==============================================
					1.- Leer alumnos (5).
					2.- Añadir alumno.
					3.- Mostrar alumnos ordenados por NIA.
					4.- Elegir criterio de ordenación de alumnos.
					0.- SALIR.
					==============================================
					""";

			System.out.print(texto);
			System.out.print("OPCIÓN DESEADA: ");

			opcion = sc.nextInt();

			switch (opcion) {
			case 0 -> System.out.println("Ha solicitado 0 para SALIR.");
			case 1 -> {
				for (int i = 1; i < NUMERO_DE_ALUMNOS; i++) {
					leerAlumnos();
				}
				mostrarMenu();
			}
			case 2 -> leerAlumno();
			case 3 -> mostrarAlumnosNia();
			case 4 -> {
				System.out.println("Ha solicitado Elegir criterio de ordenación: ");
				mostrarMenuCriterio();
			}
			default -> throw new IllegalArgumentException("La opción: " + opcion + " no es correcta");
			}

		} while (opcion != 0);
	}

	// Método para seleccionar el criterio de ordenación:
	public void mostrarMenuCriterio() {
		int opcion = -1;
		String texto = "";

		do {

			texto = """
					==============================================
					    MENU CRITERIO DE ORDENACIÓN DE ALUMNOS:
					==============================================
					1.- Nia.
					2.- Nombre.
					3.- Apellidos.
					4.- Género.
					5.- Fecha de Nacimiento.
					6.- Ciclo.
					7.- Curso.
					8.- Grupo.
					0.- REGRESAR al menú de ALUMNOS.
					==============================================
					""";

			System.out.print(texto);
			System.out.print("OPCIÓN DESEADA: ");

			opcion = sc.nextInt();

			switch (opcion) {
			case 0 -> System.out.println("Ha solicitado 0 para REGRESAR al menú de ALUMNOS. ");
			case 1 -> mostrarAlumnosNia();
			case 2 -> mostrarAlumnos(Criterio.NOMBRE);
			case 3 -> mostrarAlumnos(Criterio.APELLIDOS);
			case 4 -> mostrarAlumnos(Criterio.GENERO);
			case 5 -> mostrarAlumnos(Criterio.FECHA_NACIMIENTO);
			case 6 -> mostrarAlumnos(Criterio.CICLO);
			case 7 -> mostrarAlumnos(Criterio.CURSO);
			case 8 -> mostrarAlumnos(Criterio.GRUPO);
			default -> throw new IllegalArgumentException("La opción: " + opcion + " no es correcta");
			}
		} while (opcion != 0);
	}
}