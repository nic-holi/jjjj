package game.main;

import game.UI.Game;
import game.UI.TanksUI;
import game.scene.StartScene;
import javafx.animation.KeyFrame;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.Stage;


public class Main extends Application {
    private static final int SIZE = 500;
    private static final int FPS = 60;


    private Game tanks;
    private Stage stage;
    private KeyFrame frame;


    private TanksUI uiManager;

    class GameStart implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            gameStart();
        }
    }
    private void gameStart() {
        // create your own game here
        tanks = new Game();
        stage.setTitle(tanks.getTitle());
        uiManager.refreshGame();

        // attach game to the stage and display it
        Scene gameScene = tanks.init(SIZE, SIZE);
        stage.setScene(gameScene);

    }


    private void configureStage(Scene startScene) {
        stage.setTitle("Tank Battle");
        stage.setScene(startScene);
        stage.setResizable(false);
    }

    @Override
    public void start(Stage s) throws Exception {
        this.stage = s;
        uiManager = new TanksUI(new GameStart());
        Scene startScene = new StartScene(uiManager, SIZE).initScene();
        configureStage(startScene);
        stage.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}