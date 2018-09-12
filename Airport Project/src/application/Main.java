package application;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene options;
    
    insertData insertDB;
    deleteData deleteDB;
    selectData selectDB;
    updateData updateDB;
    
    String name;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Kerry Airport Admin");

       insertDB = new insertData(this);
       deleteDB = new deleteData(this);
       selectDB = new selectData(this);
       updateDB = new updateData(this);
       
        
       VBox v1 = new VBox(20);
       HBox h1 = new HBox(10);
       HBox h2 = new HBox(10);
       HBox h3 = new HBox(10);
       
       Label nameLabel = new Label("Username:");
       Label passLabel = new Label("Password:");
       
       TextField nameInput = new TextField();
       TextField passInput = new TextField();
      
       nameInput.setPromptText("Username");
       passInput.setPromptText("Password");

      name = nameInput.getText();
       
       Button loginButton = new Button("Log In");
       loginButton.setOnAction(e -> {goToOptions(nameInput.getText()); window.setScene(options);});
      
       h1.getChildren().addAll(nameLabel, nameInput);
       h2.getChildren().addAll(passLabel, passInput);
       h3.getChildren().add(loginButton);
       
       h1.setAlignment(Pos.CENTER);
       h2.setAlignment(Pos.CENTER);
       h3.setAlignment(Pos.CENTER);
       
       v1.getChildren().addAll(h1,h2,h3);
       v1.setAlignment(Pos.CENTER);
       
        Scene scene = new Scene(v1, 300, 200);
        window.setScene(scene);
        window.show();
        
       
        
    }

	public void goToOptions(String text) {
		// TODO Auto-generated method stub
	
		 VBox v1 = new VBox(20);
	     HBox h1 = new HBox(10);
	     HBox h2 = new HBox(10);
	     HBox h3 = new HBox(10);
	     HBox h4 = new HBox(10);
	     HBox h5 = new HBox(10);
	     HBox h6 = new HBox(10);
	     HBox h7 = new HBox(10);
	     
	
	     Button insert = new Button("Insert Records");
	     Button update = new Button("Update Records");
	     Button select = new Button("View Records");
	     Button delete = new Button("Delete Records");
	     Button logout = new Button("Log Out");
	     
		
		 Label l1 = new Label("Welcome " + text);
		 Label l2 = new Label("Select Option");
		
		 insert.setOnAction(e -> insertDB.goToInsert());
		 update.setOnAction(e -> updateDB.gotToUpdate());
		 select.setOnAction(e -> selectDB.goToSelect());
		 delete.setOnAction(e -> deleteDB.goToDelete());
		 logout.setOnAction(e -> System.exit(0));
		 
		
		 h1.getChildren().add(l1);
		 h2.getChildren().add(l2);
		 h3.getChildren().add(insert);
		 h4.getChildren().add(update);
		 h5.getChildren().add(select);
		 h6.getChildren().add(delete);
		 h7.getChildren().add(logout);
		 
		 h1.setAlignment(Pos.TOP_LEFT);
		 h2.setAlignment(Pos.TOP_CENTER);
		 h3.setAlignment(Pos.CENTER);
		 h4.setAlignment(Pos.CENTER);
		 h5.setAlignment(Pos.CENTER);
		 h6.setAlignment(Pos.CENTER);
		 h7.setAlignment(Pos.TOP_RIGHT);
		 
		 v1.getChildren().addAll(h1,h7,h2,h3,h4,h5,h6);
		 
		options = new Scene(v1, 400, 400);
		setScene(options);
		
	}


	public void setScene(Scene s) {
		// TODO Auto-generated method stub
		
		window.setScene(s);
		window.show();
		
	}

	
	public String getName() {
		
		return this.name;
	}

}