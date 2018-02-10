import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Runner extends Application{

    private final static StringHolder stringHolder = new StringHolder();

    public static void main(String[] args) {
        new StringHolderProcessor(stringHolder, 1).start();
        new StringHolderProcessor(stringHolder, 2).start();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Button btn = new Button("Clear");
        btn.setMinWidth(200);
        btn.setMinHeight(100);
        btn.setOnAction(event -> stringHolder.clear());
        btn.setLayoutX(200);
        btn.setLayoutY(200);

        Text text = new Text(10, 20,stringHolder.getString());
        text.setWrappingWidth(580);

        final Pane pane = new Pane(text, btn);

        Scene scene = new Scene(pane, 600, 400);

        primaryStage.setTitle("TT Development Test Task");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            while(true) {
                text.setText(stringHolder.getString());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
