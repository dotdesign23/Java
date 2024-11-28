import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    Scene mainScene;
    BorderPane mainLayout;
    GridPane inputLayout;
    Label productNameLabel, productPriceLabel;
    TextField productNameInput, productPriceInput;
    Button addButton;
    TableView<Product> productTable;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeComponents();
        addComponentsToLayouts();
        arrangeLayouts();
        configureTable();
        configureEventHandlers();
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Insert Product App");
    }

    private void initializeComponents() {
        mainLayout = new BorderPane();
        inputLayout = new GridPane();
        productNameLabel = new Label("Product Name: ");
        productPriceLabel = new Label("Product Price: ");
        productNameInput = new TextField();
        productPriceInput = new TextField();
        addButton = new Button("Insert");
        productTable = new TableView<>();
        mainScene = new Scene(mainLayout, 500, 600);
    }

    private void arrangeLayouts() {
        inputLayout.setAlignment(Pos.CENTER);
        mainLayout.setTop(inputLayout);
        mainLayout.setBottom(productTable);
        mainLayout.setCenter(addButton);
        mainLayout.setPadding(new Insets(30));
        BorderPane.setMargin(addButton, new Insets(30));
    }

    private void addComponentsToLayouts() {
        inputLayout.setVgap(5);
        inputLayout.setHgap(5);
        inputLayout.add(productNameLabel, 0, 0);
        inputLayout.add(productNameInput, 1, 0);
        inputLayout.add(productPriceLabel, 0, 1);
        inputLayout.add(productPriceInput, 1, 1);
        inputLayout.add(addButton, 1, 2);
    }

    private void configureTable() {
        TableColumn<Product, String> nameColumn = new TableColumn<>("Product Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        nameColumn.setMinWidth(mainLayout.getWidth() / 2);

        TableColumn<Product, String> priceColumn = new TableColumn<>("Product Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));
        priceColumn.setMinWidth(mainLayout.getWidth() / 2);

        productTable.getColumns().addAll(nameColumn, priceColumn);

        ObservableList<Product> productList = FXCollections.observableArrayList(
            new Product("Kecambah Kacang Almond", "12.500"),
            new Product("Sup Iga Triceratops", "85.000"),
            new Product("Ikan Hiu Sambal Matah", "65.000")
        );
        for (Product product : productList) {
            productTable.getItems().add(product);
        }
    }

    private void configureEventHandlers() {
        addButton.setOnAction(event -> {
            productTable.getItems().add(new Product(
                productNameInput.getText(),
                productPriceInput.getText()
            ));
        });
    }
}
