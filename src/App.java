import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyStore.Entry;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
	import java.util.HashMap;
	import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.soap.Node;

public class App {
	//C:\Users\ZWolf\Documents\EclipseWorkspace\FunctionalProgramming
	private static String filename = "C:\\Users\\ZWolf\\Documents\\EclipseWorkspace\\FunctionalProgramming\\Movie-Data.txt";
	private static List<Movie> movieList = new ArrayList<Movie>();
	
	public static void main(String[] args) {
		try {
			readFile(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double tsum = 0d; 
		
		for(Movie m : movieList){
			//System.out.println(m.getMovieName());
			if(m.getYear() >= 1970 && m.getYear() < 1980)
				tsum += m.getEarnings().doubleValue();
		}
		
		//System.out.println("70s - " + tsum);

		Float maxE = 0f;
		
		//final Comparator<Movie> MovieEarningsComp = (m1, m2) -> Float.compare(m1.getEarnings(), m2.getEarnings());
		
		
		//showMaxEarningMovie();
		
		
		//showMoviesGrossingOver500();
		
		/*
		Float theSum; 
		BigDecimal sum70s = movieList.stream()
			.filter(m -> m.getYear() >= 1970 && m.getYear() < 1980)
			.map(m -> m.getEarnings())
			//.forEach(m -> theSum += m.getEarnings());
			.reduce(BigDecimal.ZERO, BigDecimal::add)
			;
		
		*/
		//System.out.println("The 70's made -> " + getEarningsInTimePeriod(1970, 1980).toString());
		//System.out.println("The 80's made -> " + getEarningsInTimePeriod(1980, 1990).toString());
		/*System.out.println("The 70's made " + 
		        + if(getEarningsInTimePeriod(1970, 1980).doubleValue() > getEarningsInTimePeriod(1980, 1990).doubleValue())
		        	return "more"
				+ "than the 80's");
		*/
		
		
		//Map<String, BigDecimal>
		 movieList.stream()
			.filter(m-> m.getYear() >= 1960 && m.getYear() < 1970 )
			.collect(Collectors.toMap(Movie::getStudio, Movie::getEarnings, BigDecimal::add))
			.entrySet()
			.stream()
			
			//.max(C)
			//.toString()
			//.max(Comparator.comparing((k,v) -> k > v))
			
			;
		
		//System.out.println(s.toString());
		
		 System.out.println("Question 1: ");
		 showMaxEarningMovie();
		 System.out.println("\n\nQuestion 2: ");
		 
		 System.out.println("The 70's made: $" + getEarningsInTimePeriod(1970, 1980));
		 System.out.println("The 80's made: $" + getEarningsInTimePeriod(1980, 1990));
		 if(getEarningsInTimePeriod(1970, 1980).doubleValue() > getEarningsInTimePeriod(1980, 1990).doubleValue()){
			 System.out.println("Therefore, the 70's made more money.");
		 }
		 else if( getEarningsInTimePeriod(1970, 1980).doubleValue() < getEarningsInTimePeriod(1980, 1990).doubleValue()){
			 System.out.println("Therefore, the 80's made more money.");
		 }
		 else{
			 System.out.println("Therefore, they made the same amount of money. ");
		 }
		 System.out.println("\n\nQuestion 3: ");
		 showMoviesGrossingOver500();
		
	}
	
	private static BigDecimal getEarningsInTimePeriod(int onOrAfterYear , int beforeYear){
		return movieList.stream()
				.filter(m -> m.getYear() >= onOrAfterYear && m.getYear() < beforeYear)
				.map(m -> m.getEarnings())
				//.forEach(m -> theSum += m.getEarnings());
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				;
	}

	private static void showMoviesGrossingOver500() {
		ArrayList<Movie> newArrList = movieList.stream()
			.filter(m -> m.getEarnings().doubleValue() > new BigDecimal(500).doubleValue())
			//.filter(m -> m.getEarnings() > 500f)
			.map(Movie::new)
			.collect(Collectors.toCollection(ArrayList::new));

		System.out.println("----!!!! over 500 earnings !!!! ----");
		for(Movie m : newArrList){
			System.out.println(m.getMovieName() + " made -> " + m.getEarnings().toString());
		}
	}

	private static void showMaxEarningMovie() {
		Movie maxEarningMovie = movieList.stream()
			.max(Comparator.comparing(movie -> movie.getEarnings()))
			.get();
		
		
		
		System.out.println("The Highest Grossing Movie is " + maxEarningMovie.getMovieName() + " making " + maxEarningMovie.getEarnings());
	}

	private static void readFile(String fName) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader(fName));
		Scanner sc = new Scanner(new File(fName)).useDelimiter("\\||\\n");
		
		String movieName, studio, earnings, year;
		while(sc.hasNext()){
			movieName = sc.next();
			//System.out.println("movie is " + movieName);
			studio = sc.next();
			//System.out.println(studio);
			earnings = sc.next();
			//System.out.println(earnings);
			year = sc.next();
			//System.out.println("year is " + year + " !!!");
			//System.out.println("------------------------------");
			movieList.add(new Movie(movieName, studio, earnings, year.substring(0, 4)));
			
		}
		sc.close();
		
		
	}

}
