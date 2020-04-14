package application;
	

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;



public class MovingCircle extends Application {
	
	private DrawCircle newCircle = new DrawCircle();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//declare moving buttons
		Button left = new Button("Left");
		Button right = new Button("Right");
		Button up = new Button("Up");
		Button down = new Button("Down");
		
		//set buttons in horizonal row
		HBox box = new HBox(5);
		box.setAlignment(Pos.BOTTOM_CENTER);
		box.getChildren().add(up);
		box.getChildren().add(down);
		box.getChildren().add(left);
		box.getChildren().add(right);
		
		//create the handlers
		left.setOnAction(new LeftHandler());
	    right.setOnAction(new RightHandler());
	    up.setOnAction(new UpHandler());
	    down.setOnAction(new DownHandler());
		
		//manage children
		BorderPane pane = new BorderPane();
		pane.setCenter(newCircle);
		pane.setBottom(box);
		BorderPane.setAlignment(box, Pos.CENTER);
		
		//create the scene and place it in the stage
		Scene display = new Scene(pane, 350, 350);
		primaryStage.setScene(display);
		primaryStage.setTitle("Moving Circle");
		primaryStage.show();
		
	}
	
	class LeftHandler implements EventHandler<javafx.event.ActionEvent> {
		@Override
		public void handle(javafx.event.ActionEvent event) {
			newCircle.LeftButton();
		}
	}
	
	class RightHandler implements EventHandler<javafx.event.ActionEvent> {
		@Override
		public void handle(javafx.event.ActionEvent event) {
			newCircle.RightButton();
		}
	}
	
	class UpHandler implements EventHandler<javafx.event.ActionEvent> {
		@Override
		public void handle(javafx.event.ActionEvent event) {
			newCircle.UpButton();
		}
	}
	
	class DownHandler implements EventHandler<javafx.event.ActionEvent> {
		@Override
		public void handle(javafx.event.ActionEvent event) {
			newCircle.DownButton();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	class DrawCircle extends StackPane {
		
		private Circle movingCircle = new Circle(50.0);
	
		
		public DrawCircle() {
			getChildren().add(movingCircle);
			movingCircle.setStroke(Color.BLACK);
			movingCircle.setFill(Color.WHITE);
		}
		
		public void UpButton() {
			if(movingCircle.getCenterY() < getBoundsInLocal().getMinY() + 50 ) {
			movingCircle.setTranslateY(movingCircle.getTranslateY() - 20);
			}
		}
		
		public void DownButton() {
			if(movingCircle.getCenterY() > getBoundsInLocal().getMaxY() - 400) {
				movingCircle.setTranslateY(movingCircle.getTranslateY() + 20);	
			}
		}
		
		public void LeftButton() {
			if(movingCircle.getCenterX() < getBoundsInLocal().getMinX() + 50)
			movingCircle.setTranslateX(movingCircle.getTranslateX() - 20);
		}
		
		public void RightButton() {
			if(movingCircle.getCenterX() > getBoundsInLocal().getMaxX() - 400)
			movingCircle.setTranslateX(movingCircle.getTranslateX() + 20);
		}
	}
	
}
