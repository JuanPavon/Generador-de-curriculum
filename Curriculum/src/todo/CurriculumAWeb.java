package todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CurriculumAWeb {

	public static void main(String[] args) {
		
		//Lo primero es leer el archivo y definir las variables correspondientes
		String todo = "";
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("EjemploCurriculum.txt"));
			
			String linea = " ";
			
			while(linea != null) {
				linea = br.readLine();
				
				todo += linea + "\n";
				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
			
		} catch (IOException e) {
		      System.out.println("Error al leer");
	    }
		
		//Lo agrupo todo en una variable para separarlo en otras con substrings
		
		String nombre = todo.substring(todo.indexOf(">>>nombre") + 10, todo.indexOf(">>>telefono"));
		String telefono = todo.substring(todo.indexOf(">>>telefono") + 12, todo.indexOf(">>>correo"));
		String correo = todo.substring(todo.indexOf(">>>correo") + 10, todo.indexOf(">>>formacion"));
		String[] formacion = todo.substring(todo.indexOf(">>>formacion") + 13, todo.indexOf(">>>experiencia laboral")).split("\n");
		String[] experienciaLaboral = todo.substring(todo.indexOf(">>>experiencia laboral") + 23, 287).split("\n");
		
		//Ahora toca empezar a escribir el documento
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("curriculum.html"));
			
			bw.write("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"    <title>Curriculum</title>\r\n" + 
					"    <meta charset=\"utf-8\" />\r\n" + 
					"</head>" +
					"<body>\r\n" + 
					"	\r\n" + 
					"	<h1>Curriculum</h1>\r\n" + 
					"	<h3>Datos personales</h3>\r\n" + 
					"	<p>" + nombre + "</p>\r\n" + 
					"	<p>" + telefono + "</p>\r\n" + 
					"	<p>" + correo + "</p>\n" +
					"	<h3>Formacion profesional</h3\n");
			
			for (String forma : formacion) {
				bw.write("<p>" + forma + "</p>\n");
			}
			
			bw.write("<h3>Experiencia Laboral</h3>\n");
			
			for (String exp : experienciaLaboral) {
				bw.write("<p>" + exp + "</p>\n");
			}
			
			bw.close();
			
		} catch(Exception e) {
			System.out.println("Error al escribir");
		}
	}

}
