package app.cliente;

import app.modelo.Autor;
import app.modelo.Direccion;
import app.modelo.Editorial;
import app.modelo.Libro;
import app.negocio.GestionLibreria;
import app.negocio.ItfzGestionLibreria;

public class Main_Crear {

	public static void main(String[] args) {

		ItfzGestionLibreria miGestion = new GestionLibreria();
		
		/*  --- CREAMOS LAS DIRECCIONES ---  */
		Direccion direccion1 = new Direccion("Travessera de Grácia", 47, "BARCELONA", 8021, "BARCELONA");
		Direccion direccion3 = new Direccion("av. Diagonal", 662, "BARCELONA", 8034, "BARCELONA");
		Direccion direccion4 = new Direccion("Avd. Catalunya", 662, "BARCELONA", 8034, "BARCELONA");
		Direccion direccion5 = new Direccion("CALLE SORIA", 662, "SEVILLA", 8034, "SEVILLA");
		
		/*  --- CREAMOS LAS EDITORIALES ---  */
		Editorial editorial1 = new Editorial();
		editorial1.setDireccion(direccion1);
		editorial1.setNif("11111111A");
		editorial1.setNombre("DEBOLSILLO");

		Editorial editorial3 = new Editorial();
		editorial3.setDireccion(direccion1);
		editorial3.setNif("B61441127");
		editorial3.setNombre("PLANETA");
		editorial3.setDireccion(direccion3);
		
		Editorial editorial4 = new Editorial();
		editorial4.setDireccion(direccion1);
		editorial4.setNif("A08011223");
		editorial4.setNombre("SEIX BARRAL");
		editorial4.setDireccion(direccion4);
		
		Editorial editorial5 = new Editorial();
		editorial5.setDireccion(direccion5);
		editorial5.setNif("A54362918");
		editorial5.setNombre("OBELISCO");
		editorial5.setDireccion(direccion5);
		
		
		/* --- CREAMOS LOS LIBROS --- */
		Libro libro1 = new Libro();
		libro1.setDescripcion("Una novela preciosa, tremendamente humana y emocionante, "
							+ "que describe las peripecias de una niña alemana de nueve años desde que es dada en adopción"
							+ " por su madre hasta el final de la guerra.");
		libro1.setIsbn("9788499088075");
		libro1.setPrecio(9.45);
		libro1.setPublicacion(1);
		libro1.setTitulo("LA LADRONA DE LIBROS");
		
		Libro libro2 = new Libro();
		libro2.setDescripcion("Ed Kennedy es un chico cualquiera en un barrio cualquiera de una gran ciudad."
							+ " Vive en un maltrecho apartamento, se gana la vida conduciendo un taxi, "
							+ "está absolutamente enamorado de su mejor amiga y adora a su perro cafeinómano, Doorman");
		libro2.setIsbn("9788499899640");
		libro2.setPrecio(9.45);
		libro2.setPublicacion(2);
		libro2.setTitulo("CARTAS CRUZADAS");
		
		Libro libro3 = new Libro();
		libro3.setDescripcion("Pídeme lo que quieras, o déjame es una intensa y atrevida historia de amor, "
							+ "plagada de morbo y erotismo, en la que los protagonistas luchan por preservar su relación,"
							+ " a pesar de que el precio que tendrán que pagar por ello puede ser demasiado caro.");
		libro3.setIsbn("9788408127437");
		libro3.setPrecio(6.60);
		libro3.setPublicacion(3);
		libro3.setTitulo("PIDEME LO QUE QUIERAS O DEJAME");
		
		Libro libro4 = new Libro();
		libro4.setDescripcion("Ha vuelto, de Timur Vermes, es una escandalosa e"
							+ " irreverente comedia protagonizada y narrada en primera persona por Hitler. ");
		libro4.setIsbn("9788432220364");
		libro4.setPrecio(19.33);
		libro4.setPublicacion(4);
		libro4.setTitulo("HA VUELTO");
		
		Libro libro5 = new Libro();
		libro5.setDescripcion("Esta sátira de la Revolución rusa y el triunfo del estalinismo, escrita en 1945, se ha convertido "
							+ "por derecho propio en un hito de la cultura contemporánea y en uno de los libros "
							+ "más mordaces de todos los tiempos.");
		libro5.setIsbn("9788499890951");
		libro5.setPrecio(7.80);
		libro5.setPublicacion(5);
		libro5.setTitulo("REBELION EN LA GRANJA ");
		
		
		/* ---  CREAMOS LOS AUTORES  --- */
		
		Autor autor1 = new Autor();
		autor1.setComentarios("Markus Zusak, nacido en 1975 en Sídney, es un escritor australiano conocido internacionalmente");
		autor1.setNacionalidad("AUSTRALIA");
		autor1.setNombre("MARKUS ZUSAK");
		
		Autor autor3 = new Autor();
		autor3.setComentarios("Megan Maxwell, es el seudónimo de una escritora española de novela romántica actualmente afincada en Madrid.");
		autor3.setNacionalidad("ESPAÑOL");
		autor3.setNombre("MEGAN MAXWELL");
		
		Autor autor4 = new Autor();
		autor4.setComentarios("Timur Vermes (born 1967) is a German writer.");
		autor4.setNacionalidad("ALEMAN");
		autor4.setNombre("TIMUR VERMES");
		
		Autor autor5 = new Autor();
		autor5.setComentarios("George Orwell, fue un escritor y periodista británico, cuya obra lleva la marca de las "
							+ "experiencias personales vividas por el autor en tres etapas de su vida: ");
		autor5.setNacionalidad("REINO UNIDO");
		autor5.setNombre("GEORGE ORWELL");


		/* ------------------------------------------- */
		
		
		/* CREAMOS EL PRIMER Y SEGUNDO LIBRO QUE PERTENECE A LA MISMA EDITORIAL Y AUTOR. */
		libro1.addAutores(autor1);
		libro2.addAutores(autor1);
		
		autor1.addLibros(libro1);
		autor1.addLibros(libro2);
		
		editorial1.addLibros(libro1);
		editorial1.addLibros(libro2);

		System.out.println("Alta libro 1 Y 2: ");
		miGestion.altaLibro(libro1);
		
		/* CREAMOS EL TERCER LIBRO ASOCIADA A LA TERCERA EDITORIAL Y TERCER AUTOR */
		libro3.addAutores(autor3);
		autor3.addLibros(libro3);
		editorial3.addLibros(libro3);
		
		System.out.println("Alta libro3: ");
		miGestion.altaLibro(libro3);
		
		/* CREAMOS EL CUARTO LIBRO ASOCIADO A LA CUARTA EDITORIAL Y CUARTO AUTOR */
		libro4.addAutores(autor4);
		autor4.addLibros(libro4);
		editorial4.addLibros(libro4);
		
		System.out.println("Alta libro 4: ");
		miGestion.altaLibro(libro4);
		
		/* CREAMOS EL QUINTO LIBRO ASOCIADO A LA QUINTA EDITORIAL Y QUINTO AUTOR */
		libro5.addAutores(autor5);
		autor5.addLibros(libro5);
		editorial5.addLibros(libro5);
		
		System.out.println("Alta libro 5: ");
		miGestion.altaLibro(libro5);
				
	}
}
