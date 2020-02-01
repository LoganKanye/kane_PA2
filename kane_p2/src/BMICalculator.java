import java.util.Scanner;

public class BMICalculator {

	//shared scanner so only one is used
	private static Scanner in = new Scanner(System.in);
	
	//instance variables
	private double Bmi;
	private String BmiCategory;
	private double Height;
	private double Weight;
	private String UnitType;
	
	//Private method readUnitType to read the unit type input and update the variable if input is valid
	private void readUnitType() {
		
		int input;
		int inputcheck = 0;
		
		while (inputcheck == 0) {
			
			System.out.print("To Calculate Your BMI Please Enter 1 for Imperial Units or 2 for Metric Units: ");
			input = in.nextInt();
			
			if (input == 1)
			{
				this.UnitType = "Imperial";
				inputcheck++;
			}
			else if (input == 2)
			{
				this.UnitType = "Metric";
				inputcheck++;
			}
			
			System.out.println();
			
		}
		
	}
	
	//Public method readUserData to read the user input that uses private readUnitType and readMeasurementData 
	public void readUserData() {
		
		readUnitType();
		readMeasurementData();
		
	}
	
	//Private method readMeasurementData that calls readMetricData or readImperialData depending on unit type
	private void readMeasurementData( ) {
		
		if (this.UnitType.contains("Imperial")) {
			readImperialData();
		}
		else {
			readMetricData();
		}
		
	}
	
	
	//Private method readMetricData asking for input in metric
	private void readMetricData() {
		
		System.out.print("Please Enter Your Height in Meters: ");
		this.setHeight(in.nextDouble());
		System.out.println();
		
		System.out.print("Please Enter Your Weight in Kilograms: ");
		this.setWeight(in.nextDouble());
		System.out.println();
		
		in.close();
		
	}
	
	
	//Private method readImperialData asking for input in imperial
	private void readImperialData( ) {
		
		System.out.print("Please Enter Your Height in Inches: ");
		this.setHeight(in.nextDouble());
		System.out.println();
		
		System.out.print("Please Enter Your Weight in Pounds: ");
		this.setWeight(in.nextDouble());
		System.out.println();
		
		in.close();
		
	}
	
	
	
	//Public method calculateBmi that calculates user's BMI based on unit type
	public void calculateBmi() {
		
		if (this.UnitType.contains("Imperial")) {
			this.Bmi = 703 * this.Weight / (this.Height * this.Height);
		}
		else {
			this.Bmi = this.Weight / (this.Height * this.Height);
		}
		
		calculateBmiCategory();
		
	}
	
	//Private method calculateBmiCategory that determines user's BMI category based on BMI value
	private void calculateBmiCategory() {
		
		if (this.Bmi >= 30) {
			this.BmiCategory = "Obesity";
		}
		else if(this.Bmi >= 25) {
			this.BmiCategory = "Overweight";
		}
		else if(this.Bmi >= 18.5) {
			this.BmiCategory = "Normal Weight";
		}
		else {
			this.BmiCategory = "Underweight";
		}
		
	}
	
	//Public method displayBmi that prints BMI value and category 
	public void displayBmi() {
		
		System.out.printf("Your BMI was Calculated as %.1f%n", this.getBmi());
		System.out.printf("You are Classfied as " + this.getBmiCategory() + "%n");
		
	}
	
	//Public method getWeight
	public double getWeight() {
		return this.Weight;
	}
	
	//Private method setWeight that validates and updates weight
	private void setWeight(double Weight) {
		if (Weight < 0) {
			System.exit(0);
		}
		this.Weight = Weight;
	}
	
	//Public method getHeight
	public double getHeight() {
		return this.Height;
	}
	
	//Private method setHeight that validates and updates height
	private void setHeight(double Height) {
		if (Height < 0) {
			System.exit(0);
		}
		this.Height = Height;
	}
	
	//Public method getBmi
	public double getBmi() {
		return this.Bmi;
	}
	
	//Public method getBmiCategory
	public String getBmiCategory() {
		return this.BmiCategory;
	}
	
	//Main 
	public static void main(String[] args) {
		
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();

	}

}
