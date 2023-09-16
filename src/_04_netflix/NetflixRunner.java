package _04_netflix;

import java.util.Random;

public class NetflixRunner {
public static void main(String[] args) {
	Random ran = new Random();
	Movie Princess_Bride = new Movie("The Princess Bride",5);
	Movie Fat_Albert = new Movie("Fat Albert: Fun for the whole family!",4);
	Movie Star_wars_7 = new Movie("Star Wars: The Force Awakens",3);
	Movie Morbius_2 = new Movie("Morbius 2: No Time to Morb",2);
	Movie Terminator_3 = new Movie("Terminator 3",1);
	Movie m1984 = new Movie("Literally 1984",1984);
	System.out.println(Princess_Bride.getTicketPrice());
	NetflixQueue couchsurf = new NetflixQueue();
	couchsurf.addMovie(Terminator_3);
	
	for(int i = 100; i>0;i--) {
		if(ran.nextInt(100)>90) {
			couchsurf.addMovie(Morbius_2);
		}
		else if(ran.nextInt(100)<15){
		couchsurf.addMovie(m1984);
		}
		else {
			couchsurf.addMovie(Fat_Albert);
		}
	}
	
	couchsurf.addMovie(Fat_Albert);
	couchsurf.addMovie(Princess_Bride);
	couchsurf.addMovie(Morbius_2);
	couchsurf.addMovie(Star_wars_7);
	couchsurf.printMovies();
	couchsurf.sortMoviesByRating();
	System.out.println("The best movie is " + couchsurf.getMovie(0).getTitle());
	System.out.println("The second-best movie is " + couchsurf.getMovie(1).getTitle());
}}
