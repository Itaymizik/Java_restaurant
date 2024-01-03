package q2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuApplication extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("MenuApplication.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("Menu");
		stage.show();
	}
}
