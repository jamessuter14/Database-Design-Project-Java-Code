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

public class updateData {

	Main home;
	Statement s;
	Connection con;
	
	public updateData(Main main) {
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

	public void gotToUpdate() {
		// TODO Auto-generated method stub
		
		Scene updateData;
		
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
	     
	    
		 Label l2 = new Label("Select Option To Update");
	     
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
	    
		
		 updateData = new Scene(v1, 400, 400);
		this.home.setScene(updateData);
		
		
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
	     HBox h4 = new HBox(10);
	     HBox h0 = new HBox(10);
	    
	     Label l3 = new Label("Enter record to update according to flNum");
	     Label l1 = new Label("flNum (4 Characters)");
	     Label l0 = new Label("bPos (4 Characters)");
	     Label l2 = new Label("boardTime (HH:MM:SS)");
	     
	     TextField fl = new TextField();
	     TextField time = new TextField();
	     TextField bPos = new TextField();
	     
	     Button up0 = new Button("Update");
	     Button up = new Button("Update");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> gotToUpdate());
	     
	     up0.setOnAction( e -> {try {	 
	    	 
		    	String update = "update board set bPos = '" + bPos.getText() + "' where flNum = '" + fl.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up.setOnAction( e -> {try {
	    	 
		    	String update = "update board set boardTime = '" + time.getText() + "' where flNum = '" + fl.getText() +"'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     
	     h0.getChildren().addAll(l0, bPos, up0);
	     h1.getChildren().addAll(l1, fl);
	     h2.getChildren().addAll(l2, time, up);
	     h3.getChildren().addAll(back);
	     h4.getChildren().add(l3);
	     
	     h0.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h4,h1,h0,h2,h3);
	     
	  
	     
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
	     HBox h = new HBox(10);
	    
	     Label l = new Label("Select Data to Update with reference to passID");
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
	    
	     
	     Button up1 = new Button("Update");
	     Button up2 = new Button("Update");
	     Button up3 = new Button("Update");
	     Button up4 = new Button("Update");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> gotToUpdate());
	     up1.setOnAction( e -> {try {	 
	    	 
		    	String update = "update boardingpass set flNum = '" + flNum.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up2.setOnAction( e -> {try {	 
	    	 
		    	String update = "update boardingpass set priority = '" + priority.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up3.setOnAction( e -> {try {	 
	    	 
		    	String update = "update boardingpass set refNum = '" + refNum.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up4.setOnAction( e -> {try {	 
	    	 
	    	 int ps = Integer.parseInt(passSeat.getText());
	    	 
		    	String update = "update boardingpass set passSeat = " + ps + " where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     h.getChildren().add(l);
	     h1.getChildren().addAll(l1, passID);
	     h2.getChildren().addAll(l2, flNum, up1);
	     h3.getChildren().addAll(l3, priority, up2);
	     h4.getChildren().addAll(l4, refNum, up3);
	     h5.getChildren().addAll(l5, passSeat, up4);
	     h6.getChildren().addAll(back);
	     
	     h.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h,h1,h2,h3,h4,h5,h6);

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
	     HBox h = new HBox(10);
	     HBox h0 = new HBox(10);
	     
		    
	     Label l = new Label("Select Data to Update with reference to flNum");
	     Label l0 = new Label("flNum (4 Chars)");
	     Label l1 = new Label("flNum (4 Chars)");
	     Label l2 = new Label("departFrom");
	     Label l3 = new Label("arriveIn");
	     Label l4 = new Label("departTime (HH:MM:SS)");
	     Label l5 = new Label("arriveTime");
	     Label l6 = new Label("date (YYYY:DD:MM)");
	     Label l7 = new Label("planeID (4 Chars)");
	     
	     
	     TextField flNum = new TextField();
	     TextField flNum1 = new TextField();
	     TextField departFrom = new TextField();
	     TextField arriveIn = new TextField();
	     TextField departTime = new TextField();
	     TextField arriveTime = new TextField();
	     TextField date = new TextField();
	     TextField planeID = new TextField();
	    
	     
	     Button up0 = new Button("Update");
	     Button up1 = new Button("Update");
	     Button up2 = new Button("Update");
	     Button up3 = new Button("Update");
	     Button up4 = new Button("Update");
	     Button up5 = new Button("Update");
	     Button up6 = new Button("Update");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> gotToUpdate());
	     
	     up0.setOnAction( e -> {try {	 
	    	 
		    	String update = "update flight set flNum = '" + flNum1.getText() + "' where flNum = '" + flNum.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up1.setOnAction( e -> {try {	 
	    	 
		    	String update = "update flight set departFrom = '" + departFrom.getText() + "' where flNum = '" + flNum.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up2.setOnAction( e -> {try {	 
	    	 
		    	String update = "update flight set arriveIn = '" + arriveIn.getText() + "' where flNum = '" + flNum.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up3.setOnAction( e -> {try {	 
	    	 
		    	String update = "update flight set departTime = '" + departTime.getText() + "' where flNum = '" + flNum.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up4.setOnAction( e -> {try {	 
	    	 
	    	 
		    	String update = "update flight set arriveTime = '" + arriveTime.getText() + "' where flNum = '" + flNum.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up5.setOnAction( e -> {try {	 
	    	 
	    	 
		    	String update = "update flight set date = '" + date.getText() + "' where flNum = '" + flNum.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up6.setOnAction( e -> {try {	 
	    	 
	    	 
		    	String update = "update flight set planeID = '" + planeID.getText() + "' where flNum = '" + flNum.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     h0.getChildren().addAll(l0,flNum1,up0);
	     h.getChildren().add(l);
	     h1.getChildren().addAll(l1, flNum);
	     h2.getChildren().addAll(l2, departFrom, up1);
	     h3.getChildren().addAll(l3, arriveIn, up2);
	     h4.getChildren().addAll(l4, departTime, up3);
	     h5.getChildren().addAll(l5, arriveTime, up4);
	     h6.getChildren().addAll(l6, date, up5);
	     h7.getChildren().addAll(l7, planeID, up6);
	     h8.getChildren().addAll(back);
	     
	     
	     h0.setAlignment(Pos.CENTER);
	     h.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     h7.setAlignment(Pos.CENTER);
	     h8.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h,h1,h0,h2,h3,h4,h5,h6,h7,h8);

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
	     HBox h0 = new HBox(10);
	     HBox h = new HBox(10);
		    
	     Label l = new Label("Select Data to Update with reference to planeID");
	     Label l1 = new Label("planeID (4 Chars)");
	     Label l0 = new Label("planeID (4 Chars)");
	     Label l2 = new Label("company");
	     Label l3 = new Label("yearMade");
	     Label l4 = new Label("make");
	     Label l5 = new Label("numSeats");
	     
	     
	     TextField planeID = new TextField();
	     TextField planeID1 = new TextField();
	     TextField company = new TextField();
	     TextField yearMade = new TextField();
	     TextField make = new TextField();
	     TextField numSeats = new TextField();
	    
	     
	     Button up1 = new Button("Update");
	     Button up0 = new Button("Update");
	     Button up2 = new Button("Update");
	     Button up3 = new Button("Update");
	     Button up4 = new Button("Update");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> gotToUpdate());
	     
	     up0.setOnAction( e -> {try {	 
	    	 
		    	String update = "update plane set planeID = '" + planeID1.getText() + "' where planeID = '" + planeID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up1.setOnAction( e -> {try {	 
	    	 
		    	String update = "update plane set company = '" + company.getText() + "' where planeID = '" + planeID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up2.setOnAction( e -> {try {	 
	    	 
	    	 int yr = Integer.parseInt(yearMade.getText());
	    	 
		    	String update = "update plane set yearMade = " + yr + " where planeID = '" + planeID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up3.setOnAction( e -> {try {	 
	    	 
		    	String update = "update plane set make = '" + make.getText() + "' where planeID = '" + planeID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up4.setOnAction( e -> {try {	 
	    	 
	    	 int ns = Integer.parseInt(numSeats.getText());
	    	 
		    	String update = "update plane set numSeats = " + ns + " where planeID = '" + planeID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     h.getChildren().add(l);
	     h0.getChildren().addAll(l0, planeID1, up0);
	     h1.getChildren().addAll(l1, planeID);
	     h2.getChildren().addAll(l2, company, up1);
	     h3.getChildren().addAll(l3, yearMade, up2);
	     h4.getChildren().addAll(l4, make, up3);
	     h5.getChildren().addAll(l5, numSeats, up4);
	     h6.getChildren().addAll(back);
	     
	     h.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     h0.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h,h1,h0,h2,h3,h4,h5,h6);

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
	     HBox h0 = new HBox(10);
	     
	    
	     Label l1 = new Label("passID (4 Chars)");
	     Label l0 = new Label("passID (4 Chars)");
	     Label l2 = new Label("fName");
	     Label l3 = new Label("sName");
	     Label l4 = new Label("city");
	     Label l5 = new Label("age");
	     Label l6 = new Label("nationality");
	     
	     
	     TextField passID = new TextField();
	     TextField passID1 = new TextField();
	     TextField fName = new TextField();
	     TextField sName = new TextField();
	     TextField city = new TextField();
	     TextField age = new TextField();
	     TextField nationality = new TextField();
	    
	     
	     Button up0 = new Button("Update");
	     Button up1 = new Button("Update");
	     Button up2 = new Button("Update");
	     Button up3 = new Button("Update");
	     Button up4 = new Button("Update");
	     Button up5 = new Button("Update");
	     Button back = new Button("Back <--");
		
	     back.setOnAction(e -> gotToUpdate());
	     
	     up0.setOnAction( e -> {try {	 
	    	 
		    	String update = "update passengers set passID = '" + passID1.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up1.setOnAction( e -> {try {	 
	    	 
		    	String update = "update passenger set fName = '" + fName.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up2.setOnAction( e -> {try {	 
	    	 
	    	 
		    	String update = "update passenger set sName = '" + sName.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up3.setOnAction( e -> {try {	 
	    	 
		    	String update = "update passenger set city = '" + city.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up4.setOnAction( e -> {try {	 
	    	 
	    	 int a = Integer.parseInt(age.getText());
	    	 
		    	String update = "update passenger set age = " + a + " where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     up5.setOnAction( e -> {try {	 
	    	 
	    	 
		    	String update = "update passenger set nationality = '" + nationality.getText() + "' where passID = '" + passID.getText() + "'";
		    	 
			     int res = s.executeUpdate(update);
		         System.out.println("The Number or records inserted is " +res);
		         
		         
		    }catch (Exception io) {
		             System.out.println("Invalid Query"+io);
		    }});
	     
	     h0.getChildren().addAll(l0, passID1, up0);
	     h1.getChildren().addAll(l1, passID);
	     h2.getChildren().addAll(l2, fName, up1);
	     h3.getChildren().addAll(l3, sName, up2);
	     h4.getChildren().addAll(l4, city, up3);
	     h5.getChildren().addAll(l5, age, up4);
	     h6.getChildren().addAll(l6, nationality, up5);
	     h7.getChildren().addAll(back);
	     
	     h0.setAlignment(Pos.CENTER);
	     h1.setAlignment(Pos.CENTER);
	     h2.setAlignment(Pos.CENTER);
	     h3.setAlignment(Pos.CENTER);
	     h4.setAlignment(Pos.CENTER);
	     h5.setAlignment(Pos.CENTER);
	     h6.setAlignment(Pos.CENTER);
	     h7.setAlignment(Pos.CENTER);
	     
	     v1.getChildren().addAll(h1,h0,h2,h3,h4,h5,h6,h7);

		Scene passengers = new Scene(v1, 400, 400);
		this.home.setScene(passengers);
		
	}

}
