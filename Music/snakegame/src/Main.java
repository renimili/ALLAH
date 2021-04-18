

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        World world = new World(25);

        BorderPane root = new BorderPane();
        SnakeGame game = new SnakeGame(world);
        Pane ui = SnakeGame.createUserInterface(world);

        game.setStyle("-fx-background-color: #D4ABD8;");
        ui.setPadding(new Insets(10));

        root.setLeft(game);
        root.setRight(ui);

        Scene scene = new Scene(root);

        InputHandler inputHandler = new InputHandler(world);

        scene.setOnKeyPressed(inputHandler.getKeyHandler());
        scene.setOnMouseClicked(inputHandler.getMouseHandler());

        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
