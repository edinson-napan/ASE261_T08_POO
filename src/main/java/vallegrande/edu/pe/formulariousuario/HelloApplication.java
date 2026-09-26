package vallegrande.edu.pe.formulariousuario;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Creación de componentes gráficos
        Label lblNombre = new Label("Nombre de usuario:");
        TextField txtNombre = new TextField();
        CheckBox chkAceptar = new CheckBox("Acepto los términos y condiciones");
        Button btnEnviar = new Button("Registrar");

        // 2. Lógica del evento del botón (validaciones y alertas)
        btnEnviar.setOnAction(e -> {
            String nombre = txtNombre.getText().trim();
            boolean acepto = chkAceptar.isSelected();

            if (nombre.isEmpty()) {
                mostrarAlerta(Alert.AlertType.WARNING, "Campo vacío", "Por favor, ingrese un nombre.");
            } else if (!acepto) {
                mostrarAlerta(Alert.AlertType.ERROR, "Términos no aceptados", "Debe aceptar los términos para continuar.");
            } else {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Registro Exitoso", "¡Usuario " + nombre + " registrado con éxito!");
            }
        });

        // 3. Contenedor (VBox alineará los elementos uno debajo de otro)
        VBox panelPrincipal = new VBox(12); // Separación vertical de 12px
        panelPrincipal.setPadding(new Insets(20)); // Margen alrededor del panel
        panelPrincipal.setAlignment(Pos.CENTER_LEFT);
        panelPrincipal.getChildren().addAll(lblNombre, txtNombre, chkAceptar, btnEnviar);

        // 4. Configuración del escenario y ventana principal
        Scene escena = new Scene(panelPrincipal, 350, 220);
        primaryStage.setTitle("Formulario de Registro");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    // Método auxiliar para lanzar pop-ups (Alerts)
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}