package de.sofiworx.gameoflife;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The visible game board / main application window.
 *
 * @author Ulrich Cech
 */
public class GameBoard extends Application {
    private static final int BOARD_SIZE = 600;
    private static final int x = 100;
    private static final int y = 100;
    private static final int FIELD_COUNT = x * y;
    private static final int WIDTH = BOARD_SIZE / x;
    private static final int HEIGHT = BOARD_SIZE / y;
    private static final String TITLE = "Game of Life";

    @Override
    public void start(final Stage primaryStage) {
        final Grid grid = new Grid(x, y);
        grid.prepareGeneration0();
        setTitle(primaryStage, grid);

        final Rectangle[] fields = new Rectangle[FIELD_COUNT];

        int index = 0;
        for (int row = 0; row < grid.getDimensionX(); row++) {
            for (int col = 0; col < grid.getDimensionX(); col++) {
                Cell cell = grid.getCell(col, row);
                Rectangle rect = new Rectangle((col * WIDTH), (row * HEIGHT), WIDTH, HEIGHT);
                rect.setFill(cell.isAlive() ? Color.BLACK : Color.WHITE);
                fields[index] = rect;
                index++;
            }
        }

        BorderPane border = new BorderPane();
        border.setCenter(new Group(fields));
        border.setTop(addHBox());

        Scene scene = new Scene(border, BOARD_SIZE+100, BOARD_SIZE+155);
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame generation = new KeyFrame(Duration.seconds(.25),
                event -> {
                    grid.calculateNextGeneration();
                    setTitle(primaryStage, grid);
                    int index1 = 0;
                    for (int row = 0; row < grid.getDimensionX(); row++) {
                        for (int col = 0; col < grid.getDimensionX(); col++) {
                            Cell cell = grid.getCell(col, row);
                            fields[index1].setFill(cell.isAlive() ? Color.BLACK : Color.WHITE);
                            index1++;
                        }
                    }
                });
        tl.getKeyFrames().add(generation);
        tl.play();
    }

    private void setTitle(final Stage primaryStage, final Grid grid) {
        primaryStage.setTitle(TITLE + " (Generation: " + grid.getCurrentGenerationNumber() + ")");
    }

    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
        hbox.setStyle("-fx-background-color: #336699;");
        Button buttonCurrent = new Button("Current");
        buttonCurrent.setPrefSize(100, 20);
        Button buttonProjected = new Button("Projected");
        buttonProjected.setPrefSize(100, 20);
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);
        return hbox;
    }
}
