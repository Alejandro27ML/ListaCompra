package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Conectamos con el FMXL para mostrar la interfaz
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lista-view.fxml"));
        Scene scene = new Scene(loader.load());

        // Enlazamos el CSS para cargar los estilos
        scene.getStylesheets().add(getClass().getResource("/syles.css").toExternalForm());

        stage.setTitle("Lista de la Compra");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //El metodo launch lanza la aplicación.
        launch();
    }
}

