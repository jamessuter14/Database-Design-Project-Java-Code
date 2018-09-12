package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class insertData {
	
	Main home;
	
	Statement s;
	Connection con;

	public insertData(Main main) {
		// TODO Auto-generated constructor stub
		
		this.home = main;
		
		 try {
		         con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/p2?user=root&password=password");
		        System.out.println ("Database connection established");
		        s = con.createStatement ();
		        }
		        catch (Exception ex) {
		            System.out.println("SQLException: " + ex.getMessage());
		            
		        }   
		
		
	}

	public void  goToInsert() {
		// TODO Auto-generated method stub
		
		Scene insertData;
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h3 = new HBox(10);
	     HBox h4 = new HBox(10);
	     HBox h5 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h7 = new HBox(10);
	     
	
	     Button passengers = new Button("Passenger's");
	     Button plane = new Button("Plane's");
	     Button flight = new Button("Flight");
	     Button Boardingpass = new Button("Boarding Pass'");
	     Button Board = new Button("Board");
	     Button back = new Button("Back <--");
	     
	     
	     passengers.setOnAction(e -> passenger());
	     plane.setOnAction(e -> plane());
	     flight.setOnAction(e -> flight());
	     Boardingpass.setOnAction(e -> boardingPass());
	     Board.setOnAction(e -> board());
	     back.setOnAction(e -> back());
	     
	    
		 Label l2 = new Label("Select Option To Insert");
	     
		 h1.getChildren().add(l2);
		 h2.getChildren().add(passengers);
		 h3.getChildren().add(plane);
		 h4.getChildren().add(flight);
		 h5.getChildren().add(Boardingpass);
		 h6.getChildren().add(Board);
		 h7.getChildren().add(back);
		 
		 h1.setAlignment(Pos.TOP_CENTER);
		 h2.setAlignment(Pos.CENTER);
		 h3.setAlignment(Pos.CENTER);
		 h4.setAlignment(Pos.CENTER);
		 h5.setAlignment(Pos.CENTER);
		 h6.setAlignment(Pos.CENTER);
		 h7.setAlignment(Pos.CENTER);
		 
		 v1.getChildren().addAll(h1,h2,h3,h4,h5,h6,h7);
	    
		
		insertData = new Scene(v1, 400, 400);
		this.home.setScene(insertData);
		
		
	}

	private void back() {
		// TODO Auto-generated method stub
		String a = home.getName();
		
		home.goToOptions(a);
		
		
	}

	private void board() {
		// TODO Auto-generated method stub
		
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h3 = new HBox(10);
	    
	     Label l1 = new Label("flNum (4 Characters)");
	     Label l2 = new Label("boardTime (HH:MM:SS)");
	     
	     TextField fl = new TextField();
	     TextField time = new TextField();
	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToInsert());
	     enter.setOnAction( e -> {try {
	    	 
		    	String insert = "insert into board values ('" + fl.getText() + "', '" + time.getText() +"')";
		    	 
			     int res = s.executeUpdate(insert);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     h1.getChildren().addAll(l1, fl);
	     h2.getChildren().addAll(l2, time);
	     h3.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h1,h2,h3);
	     
	  
	     
		Scene board = new Scene(v1, 400, 400);
		this.home.setScene(board);
	
	}

	private void boardingPass() {
		// TODO Auto-generated method stub
	
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h3 = new HBox(10);
	     HBox h4 = new HBox(10);
	     HBox h5 = new HBox(10);
	     HBox h6 = new HBox(10);
	    
	     Label l1 = new Label("passID (4 Chars)");
	     Label l2 = new Label("flNum (4 Chars)");
	     Label l3 = new Label("priority (T/F)");
	     Label l4 = new Label("refNum (4 Chars)");
	     Label l5 = new Label("passSeat");
	     
	     
	     TextField passID = new TextField();
	     TextField flNum = new TextField();
	     TextField priority = new TextField();
	     TextField refNum = new TextField();
	     TextField passSeat = new TextField();
	    
	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToInsert());
	     enter.setOnAction( e -> {try {
	    	 
	    	 int ps = Integer.parseInt(passSeat.getText());
	    	 
		    	String insert = "insert into boardingpass values ('" + passID.getText() + "', '" + flNum.getText() + "', '" + priority.getText() + "', '" + refNum.getText() + "', " + ps + ")";
		    	 
			     int res = s.executeUpdate(insert);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     h1.getChildren().addAll(l1, passID);
	     h2.getChildren().addAll(l2, flNum);
	     h3.getChildren().addAll(l3, priority);
	     h4.getChildren().addAll(l4, refNum);
	     h5.getChildren().addAll(l5, passSeat);
	     h6.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h1,h2,h3,h4,h5,h6);

		Scene boardpass = new Scene(v1, 400, 400);
		this.home.setScene(boardpass);
		
	}

	private void flight() {
		// TODO Auto-generated method stub
		
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h3 = new HBox(10);
	     HBox h4 = new HBox(10);
	     HBox h5 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h7 = new HBox(10);
	     HBox h8 = new HBox(10);
	    
	     Label l1 = new Label("flNum (4 Chars)");
	     Label l2 = new Label("departFrom");
	     Label l3 = new Label("arriveIn");
	     Label l4 = new Label("departTime (HH:MM:SS)");
	     Label l5 = new Label("arriveTime");
	     Label l6 = new Label("date (YYYY:DD:MM)");
	     Label l7 = new Label("planeID (4 Chars)");
	     
	     
	     TextField flNum = new TextField();
	     TextField departFrom = new TextField();
	     TextField arriveIn = new TextField();
	     TextField departTime = new TextField();
	     TextField arriveTime = new TextField();
	     TextField date = new TextField();
	     TextField planeID = new TextField();
	    
	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToInsert());
	     enter.setOnAction( e -> {try {
	    	 
	    	String insert = "insert into flight values ('" + flNum.getText() + "', '" + departFrom.getText() + "', '" + arriveIn.getText() + "', '" + departTime.getText() + "', '" + arriveTime.getText() + "', '" + date.getText() + "', '" + planeID.getText() + "')";
	    	 
		     int res = s.executeUpdate(insert);
	         System.out.println("The Number or records inserted is " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     h1.getChildren().addAll(l1, flNum);
	     h2.getChildren().addAll(l2, departFrom);
	     h3.getChildren().addAll(l3, arriveIn);
	     h4.getChildren().addAll(l4, departTime);
	     h5.getChildren().addAll(l5, arriveTime);
	     h6.getChildren().addAll(l6, date);
	     h7.getChildren().addAll(l7, planeID);
	     h8.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     h7.setAlignment(Pos.CENTER);
	     h8.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h1,h2,h3,h4,h5,h6,h7,h8);

		Scene flight = new Scene(v1, 400, 400);
		this.home.setScene(flight);
	
	}

	private void plane() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h3 = new HBox(10);
	     HBox h4 = new HBox(10);
	     HBox h5 = new HBox(10);
	     HBox h6 = new HBox(10);
	    
	     Label l1 = new Label("planeID (4 Chars)");
	     Label l2 = new Label("company");
	     Label l3 = new Label("yearMade");
	     Label l4 = new Label("make");
	     Label l5 = new Label("numSeats");
	     
	     
	     TextField planeID = new TextField();
	     TextField company = new TextField();
	     TextField yearMade = new TextField();
	     TextField make = new TextField();
	     TextField numSeats = new TextField();
	    
	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToInsert());
	     enter.setOnAction( e -> {try {
		     
	    	 int ym = Integer.parseInt(yearMade.getText());
	    	 int ns = Integer.parseInt(numSeats.getText());
	    	 
	    	String insert = "insert into plane values ('" + planeID.getText() + "', '" + company.getText() + "', " + ym + ", '" + make.getText() + "', " + ns + ")";
	    	 
		     int res = s.executeUpdate(insert);
	         System.out.println("The Number or records inserted is      " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     
	     
	     h1.getChildren().addAll(l1, planeID);
	     h2.getChildren().addAll(l2, company);
	     h3.getChildren().addAll(l3, yearMade);
	     h4.getChildren().addAll(l4, make);
	     h5.getChildren().addAll(l5, numSeats);
	     h6.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h1,h2,h3,h4,h5,h6);

		Scene plane = new Scene(v1, 400, 400);
		this.home.setScene(plane);
		
	}

	private void passenger() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h3 = new HBox(10);
	     HBox h4 = new HBox(10);
	     HBox h5 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h7 = new HBox(10);
	    
	     Label l1 = new Label("passID (4 Chars)");
	     Label l2 = new Label("fName");
	     Label l3 = new Label("sName");
	     Label l4 = new Label("city");
	     Label l5 = new Label("age");
	     Label l6 = new Label("nationality");
	     
	     
	     TextField passID = new TextField();
	     TextField fName = new TextField();
	     TextField sName = new TextField();
	     TextField city = new TextField();
	     TextField age = new TextField();
	     TextField nationality = new TextField();
	    
	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToInsert());
	     enter.setOnAction( e -> {try {
		     
	    	 int a = Integer.parseInt(age.getText());
	    	 
	    	String insert = "insert into passengers values ('" + passID.getText() + "', '" + fName.getText() + "', '" + sName.getText() + "', '" + city.getText() + "', " + a + ", '" + nationality.getText() + "')";
	    	 
		     int res = s.executeUpdate(insert);
	         System.out.println("The Number or records inserted is " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     h1.getChildren().addAll(l1, passID);
	     h2.getChildren().addAll(l2, fName);
	     h3.getChildren().addAll(l3, sName);
	     h4.getChildren().addAll(l4, city);
	     h5.getChildren().addAll(l5, age);
	     h6.getChildren().addAll(l6, nationality);
	     h7.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     h7.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h1,h2,h3,h4,h5,h6,h7);

		Scene passengers = new Scene(v1, 400, 400);
		this.home.setScene(passengers);
		
	}

}
