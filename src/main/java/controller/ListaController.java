package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ListaController {

    //Aquí enlazamos las estructuras de la interfaz, los VBox, Botones, Label, etc...
    @FXML
    private VBox contenedorProductos;

    @FXML
    private void onAgregarProducto() {
        agregarFilaProducto();
    }

    @FXML
    private void onVaciarLista() {
        contenedorProductos.getChildren().clear();
        actualizarTotal();
    }

    @FXML
    private void onSalir() {
        System.exit(0);
    }

    @FXML
    private Label lblTotal;

    //A partir de aquí, tenemos los metodos que activarán los elementos con los
    //que podemos interactuar de la interfaz. El primero agrega una fila de producto
    //editable
    private void agregarFilaProducto() {

        HBox fila = new HBox(10);
        fila.setAlignment(Pos.CENTER_LEFT);
        fila.setMaxWidth(Double.MAX_VALUE);
        fila.getStyleClass().add("fila-producto");

        CheckBox chkComprado = new CheckBox();

        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Producto");
        txtNombre.setPrefWidth(150);

        TextField txtCantidad = new TextField();
        txtCantidad.setPromptText("Cant.");
        txtCantidad.setPrefWidth(60);

        TextField txtNotas = new TextField();
        txtNotas.setPromptText("Notas");
        txtNotas.setPrefWidth(280);

        Button btnEliminar = new Button("X");
        btnEliminar.setPrefWidth(30);

        Separator separador = new Separator();

        // aquí está configurado el checkbox añadiendo estilos y un bloqueo para evitar edición:
        chkComprado.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                txtNombre.setStyle("-fx-text-fill: grey; -fx-text-decoration: line-through;");
                fila.getStyleClass().remove("fila-producto");
                fila.getStyleClass().add("fila-producto-comprado");

                txtNombre.setEditable(false);
                txtCantidad.setEditable(false);
                txtNotas.setEditable(false);

            } else {
                txtNombre.setStyle("");
                fila.getStyleClass().remove("fila-producto-comprado");
                fila.getStyleClass().add("fila-producto");

                txtNombre.setEditable(true);
                txtCantidad.setEditable(true);
                txtNotas.setEditable(true);
            }
        });


        //Añadido que el Boton X borre la fila entera:
        btnEliminar.setOnAction(e -> {
            contenedorProductos.getChildren().remove(fila);
            contenedorProductos.getChildren().remove(separador);
            actualizarTotal();
        });

        fila.getChildren().addAll(chkComprado, txtNombre, txtCantidad, txtNotas, btnEliminar);
        contenedorProductos.getChildren().addAll(fila, separador);
        actualizarTotal();
    }

    //Metodo para contar el total de productos añadido a la lista.
    private void actualizarTotal() {
        int total = contenedorProductos.getChildren().size() / 2;
        lblTotal.setText("Productos: " + total);
    }
}


