import java.math.BigDecimal;
import java.time.Year;

public class Movie {
	private String movieName; 
	private String studio;
	private BigDecimal earnings;
	private int year; 
	
	
	public Movie(String aMovieName, String aStudio, String anEarnings, String aYear) {
		setMovieName(aMovieName);
		setStudio(aStudio);
		setEarnings(anEarnings);
		setYear(aYear);
		
		//System.out.println("added movie" + this.getYear().toString() + " woo");
	}
	
	Movie(Movie m){
		setMovieName(m.getMovieName());
		setStudio(m.getStudio());
		setEarnings(m.getEarnings());
		setYear(m.getYear());
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public BigDecimal getEarnings() {
		return earnings;
	}
	public void setEarnings(BigDecimal earnings) {
		this.earnings = earnings;
	}
	
	public void setEarnings(String  stringEarnings){
		this.earnings = new BigDecimal(stringEarnings);
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setYear(String stringYear){
		this.year = Integer.parseInt(stringYear);
	}
	
	
}
