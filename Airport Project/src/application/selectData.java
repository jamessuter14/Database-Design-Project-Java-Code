package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class selectData {
	
	Main home;
	Statement s;
	Connection con;
	

	public selectData(Main main) {
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

	public void goToSelect() {
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
	     
	    
		 Label l2 = new Label("Select Option To View");
	     
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
	     HBox h6 = new HBox(10);
	     HBox h2 = new HBox(10);
	  
	     Label l = new Label("\t\t\t bPos  flNum  status  boardTime");

	     ListView<String> lv = new ListView<String>();
	     lv.getItems().clear();
	   
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToSelect());
	    
	     try {
	    	
	    	 String select = "select * from board";
	    	 
		     ResultSet res = s.executeQuery(select);
	        while(res.next()) {
	        	
	        	lv.getItems().add(res.getString("bPos")+ " " + res.getString("flNum") + " " + res.getString("status") + " " + res.getString("boardTime") + "\n");
	        	
	        	
	        }
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }
	     
	     
	     
	     
	    h2.getChildren().add(l);
	     h6.getChildren().add(back);
	     h1.getChildren().add(lv);
	    
	     h6.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	   
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene board = new Scene(v1, 400, 400);
		this.home.setScene(board);
	
	}

	private void boardingPass() {
		// TODO Auto-generated method stub
		
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h2 = new HBox(10);
		  
	     Label l = new Label("\t\t\t passID  flNum  priority  refNum  passSeat");
	  


	     ListView<String> lv = new ListView<String>();
	     lv.getItems().clear();
	   
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToSelect());
	    
	     try {
	    	
	    	 String select = "select * from boardingpass";
	    	 
		     ResultSet res = s.executeQuery(select);
	        while(res.next()) {
	        	 
	        	lv.getItems().add(res.getString("passID")+ "   " + res.getString("flNum") + "   " + res.getString("priority") + "       " + res.getString("refNum") + "        " + res.getInt("passSeat") + "\n");
	        	
	        	
	        }
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }
	     
	     
	     
	     
	    
	     h6.getChildren().add(back);
	     h1.getChildren().add(lv);
	     h2.getChildren().add(l);
	    
	     h6.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene boardingPass = new Scene(v1, 400, 400);
		this.home.setScene(boardingPass);
		

	}

	private void flight() {
		// TODO Auto-generated method stub
		
		VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h2 = new HBox(10);
		  
	     Label l = new Label("\t\t flNum  departFrom  arriveIn  departTime  arriveTime    date          planeID");
	  


	     ListView<String> lv = new ListView<String>();
	     lv.getItems().clear();
	     lv.setMinWidth(500);
	   
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToSelect());
	    
	     try {
	    	
	    	 String select = "select * from flight";
	    	 
		     ResultSet res = s.executeQuery(select);
	        while(res.next()) {
	        	 
	        	lv.getItems().add(res.getString("flNum")+ "   " + res.getString("departFrom") + "          " + res.getString("arriveIn") + "     " + res.getString("departTime") + "      " + res.getString("arriveTime") + "   " + res.getString("date") + "      " + res.getString("planeID") + "\n");
	        	
	        	
	        }
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }
	     
	     
	     
	     
	    
	     h6.getChildren().add(back);
	     h1.getChildren().add(lv);
	     h2.getChildren().add(l);
	    
	     h6.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene flight = new Scene(v1, 600, 400);
		this.home.setScene(flight);
		

	}

	private void plane() {
		// TODO Auto-generated method stub
		
		VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h2 = new HBox(10);
		  
	     Label l = new Label("planeID  company  yearMade  make       numSeats");
	  


	     ListView<String> lv = new ListView<String>();
	     lv.getItems().clear();
	     lv.setMinWidth(450);
	   
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToSelect());
	    
	     try {
	    	
	    	 String select = "select * from plane";
	    	 
		     ResultSet res = s.executeQuery(select);
	        while(res.next()) {
	        	 
	        	lv.getItems().add(res.getString("planeID")+ "   " + res.getString("company") + "     " + res.getInt("yearMade") + "       " + res.getString("make") + "        " + res.getInt("numSeats") + "\n");
	        	
	        	
	        }
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }
	     
	     
	     
	     
	    
	     h6.getChildren().add(back);
	     h1.getChildren().add(lv);
	     h2.getChildren().add(l);
	    
	     h6.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene plane = new Scene(v1, 400, 400);
		this.home.setScene(plane);
		
	}

	private void passenger() {
		// TODO Auto-generated method stub
		
		VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h2 = new HBox(10);
		  
	     Label l = new Label("passID  fName  sName      city         age         nationality");
	  


	     ListView<String> lv = new ListView<String>();
	     lv.getItems().clear();
	     lv.setMinWidth(500);
	   
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> goToSelect());
	    
	     try {
	    	
	    	 String select = "select * from passengers";
	    	 
		     ResultSet res = s.executeQuery(select);
	        while(res.next()) {
	        	 
	        	lv.getItems().add(res.getString("passID")+ "   " + res.getString("fName") + "   " + res.getString("sName") + "       " + res.getString("city") + "     " + res.getInt("age") + "       " + res.getString("nationality") + "\n");
	        	
	        	
	        }
	         
	         
	    }catch (Exception io) {
	             System.out.println("Invalid Query"+io);
	    }
	     
	     
	     
	     
	    
	     h6.getChildren().add(back);
	     h1.getChildren().add(lv);
	     h2.getChildren().add(l);
	    
	     h6.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h2,h1,h6);

		Scene passengers = new Scene(v1, 400, 400);
		this.home.setScene(passengers);
		
	
	}

	private void back() {
		// TODO Auto-generated method stub
		String a = home.getName();
		
		home.goToOptions(a);
		
		
	}
}
