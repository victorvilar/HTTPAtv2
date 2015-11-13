package br.ufrn.imd.psi;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/*
 * Buscador de filmes e séries
 * Fonte: OMDbAPI (http://omdbapi.com/)
 * Retorno: json
 * Permitir busca por palavras-chave
 * Mostrar as seguintes informações:
 * Título, ano, gênero, diretor, autor
 * Permitir ao usuário retornar principais atores, nota no IMDB, sinopse, poster e demais atributos
 */
public class Main {

	public static void main(String[] args) {

		String read, link, p1, p2;
		Scanner inKboard = new Scanner(System.in);
		int option;
		// System.out.println("Search
		// for:\n1-Title\n2-Year\n3-Rated\n4-Released\n5-Runtime\n6-Genre\n7-Director\n8-Writer\n9-Actors\n10-Plot\n11-Language12-Country\n13-Awards\n14-Poster\n15-Metascore\n16-imdbRating\n17-imdbVotes18-imdbID\n19-Type\n20-Response\n");
		p1 = "http://www.omdbapi.com/?t=";
		System.out.println("Search for keywords:");
		read = inKboard.nextLine();
		read = read.replaceAll(" ", "+");
		link = p1 + read;
		
		try {
			URL u = new URL(link);

			InputStream in = u.openStream();
			int c;
			while ((c = in.read()) != -1) {
				if ((char) c == '"' || c == '{' || c == '}') {
					c = in.read();
					if ((char) c == ',') {
						System.out.print("\n");
					} else {
						System.out.print((char) c);
					}
				} else
					System.out.print((char) c);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
