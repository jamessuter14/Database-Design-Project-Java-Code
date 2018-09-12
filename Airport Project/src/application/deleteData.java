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

public class deleteData {

	Main home;
	Statement s;
	Connection con;
	
	public deleteData(Main main) {
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

	public void goToDelete() {
		// TODO Auto-generated method stub
		
		Scene deleteData;
		
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
	     
	    
		 Label l2 = new Label("Select Option To Delete");
	     
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
	    
		
		 deleteData = new Scene(v1, 400, 400);
		this.home.setScene(deleteData);
		
		
	}

	private void board() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h6 = new HBox(10);
	    
	     Label l1 = new Label("flNum (4 Chars)");
	     Label l2 = new Label("Enter flNum of record to delete");

	     TextField flNum = new TextField();

	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToDelete());
	     enter.setOnAction( e -> {try {
	    	 
	    	String delete = "delete from board where flNum = '" + flNum.getText() +"'";
	    	 
		     int res = s.executeUpdate(delete);
	         System.out.println("The Number or records deleted is      " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     
	     
	     h1.getChildren().addAll(l1, flNum);
	     h2.getChildren().add(l2);
	     h6.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene board = new Scene(v1, 400, 400);
		this.home.setScene(board);
	
	}

	private void boardingPass() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h3 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h6 = new HBox(10);
	    
	     Label l1 = new Label("passID (4 Chars)");
	     Label l3 = new Label("flNum (4 Chars)");
	     Label l2 = new Label("Enter passID and flNum of record to delete");

	     TextField passID = new TextField();
	     TextField flNum = new TextField();

	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToDelete());
	     enter.setOnAction( e -> {try {
	    	 
	    	String delete = "delete from boardingpass where passID = '" + passID.getText() + "' and flNum = '" + flNum.getText() +"'";
	    	 
		     int res = s.executeUpdate(delete);
	         System.out.println("The Number or records deleted is      " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     
	     
	     h1.getChildren().addAll(l1, passID);
	     h3.getChildren().addAll(l3, flNum);
	     h2.getChildren().add(l2);
	     h6.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h3,h1,h6);

		Scene boardingPass = new Scene(v1, 400, 400);
		this.home.setScene(boardingPass);
		

	}

	private void flight() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h6 = new HBox(10);
	    
	     Label l1 = new Label("flNum (4 Chars)");
	     Label l2 = new Label("Enter flNum of record to delete");

	     TextField flNum = new TextField();

	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToDelete());
	     enter.setOnAction( e -> {try {
	    	 
	    	String delete = "delete from flight where flNum = '" + flNum.getText() +"'";
	    	 
		     int res = s.executeUpdate(delete);
	         System.out.println("The Number or records deleted is      " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     
	     
	     h1.getChildren().addAll(l1, flNum);
	     h2.getChildren().add(l2);
	     h6.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene flight = new Scene(v1, 400, 400);
		this.home.setScene(flight);
		

	}

	private void plane() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h6 = new HBox(10);
	    
	     Label l1 = new Label("planeID (4 Chars)");
	     Label l2 = new Label("Enter planeID of record to delete");

	     TextField planeID = new TextField();

	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToDelete());
	     enter.setOnAction( e -> {try {
	    	 
	    	String delete = "delete from plane where planeID = '" + planeID.getText() +"'";
	    	 
		     int res = s.executeUpdate(delete);
	         System.out.println("The Number or records deleted is      " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     
	     
	     h1.getChildren().addAll(l1, planeID);
	     h2.getChildren().add(l2);
	     h6.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene plane = new Scene(v1, 400, 400);
		this.home.setScene(plane);
		
	}

	private void passenger() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h6 = new HBox(10);
	    
	     Label l1 = new Label("passID (4 Chars)");
	     Label l2 = new Label("Enter passID of record to delete");

	     TextField passID = new TextField();

	     
	     Button enter = new Button("Enter");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToDelete());
	     enter.setOnAction( e -> {try {
	    	 
	    	String delete = "delete from passengers where passID = '" + passID.getText() +"'";
	    	 
		     int res = s.executeUpdate(delete);
	         System.out.println("The Number or records deleted is      " +res);
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }});
	     
	     
	     
	     h1.getChildren().addAll(l1, passID);
	     h2.getChildren().add(l2);
	     h6.getChildren().addAll(back, enter);
	     
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene passenger = new Scene(v1, 400, 400);
		this.home.setScene(passenger);
		
	
	}

	private void back() {
		// TODO Auto-generated method stub
		String a = home.getName();
		
		home.goToOptions(a);
		
		
	}
}
