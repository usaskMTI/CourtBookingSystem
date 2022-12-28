package com.example.cbs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class BookingTableUI extends AnchorPane implements ModelListener {
    private TableView<BookingObject> mainTable;
    private ObservableList<BookingObject> timeValues;
    private Label courtNumberLabel;
    private ArrayList<String> result;
    private BookingModel model;
    private Button clickedButton;
    private AppController appController;

    private final String[] timeperiod = new String[]{"9 AM - 10 AM","10 AM - 11 AM","11 AM - 12 PM","12 PM - 1 PM","1 PM - 2 PM",
            "2 PM - 3 PM","3 PM - 4 PM","4 PM - 5 PM","5 PM - 6 PM","6 PM - 7 PM","7 PM - 8 PM","8 PM - 9 PM"};

    public BookingTableUI(String courtNumber)
    {

        this.courtNumberLabel = new Label(courtNumber);
        mainTable = new TableView<>();
        timeValues = FXCollections.observableArrayList();

        AnchorPane.setTopAnchor(mainTable,30.0);
        AnchorPane.setLeftAnchor(mainTable,10.0);
        AnchorPane.setRightAnchor(mainTable,30.0);
        AnchorPane.setBottomAnchor(mainTable,10.0);

        mainTable.setMinSize(500,200);
        mainTable.setPrefSize(1200,625);
        mainTable.setMaxSize(1300,700);

        AnchorPane.setLeftAnchor(courtNumberLabel, 500.0);
        AnchorPane.setTopAnchor(courtNumberLabel,10.0);
        AnchorPane.setRightAnchor(courtNumberLabel, 10.0);



        for (String time: timeperiod)
        {
            timeValues.add(new BookingObject(time));
        }

        // some fake booking
        timeValues.get(0).fakeBooked("Monday");
        timeValues.get(5).fakeBooked("Thursday");

        TableColumn<BookingObject, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

        TableColumn<BookingObject, CellView> monday = new TableColumn<>("Monday");
        monday.setCellValueFactory(new PropertyValueFactory<>("monday"));

        TableColumn<BookingObject, CellView> tuesday = new TableColumn<>("Tuesday");
        tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));

        TableColumn<BookingObject, CellView> wednesday = new TableColumn<>("Wednesday");
        wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));

        TableColumn<BookingObject, CellView> thursday = new TableColumn<>("Thursday");
        thursday.setCellValueFactory(new PropertyValueFactory<>("thursday"));

        TableColumn<BookingObject, CellView> friday = new TableColumn<>("Friday");
        friday.setCellValueFactory(new PropertyValueFactory<>("friday"));

        TableColumn<BookingObject, CellView> saturday = new TableColumn<>("Saturday");
        saturday.setCellValueFactory(new PropertyValueFactory<>("saturday"));

        TableColumn<BookingObject, CellView> sunday = new TableColumn<>("Sunday");
        sunday.setCellValueFactory(new PropertyValueFactory<>("sunday"));


        mainTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        mainTable.getSelectionModel().setCellSelectionEnabled(true);

        mainTable.setItems(timeValues);
        mainTable.getColumns().addAll(timeColumn,monday,tuesday,wednesday,thursday,friday,saturday,sunday);

        mainTable.setOnMouseClicked(this::handleClick);

        mainTable.setFixedCellSize(50);
        this.getChildren().addAll(this.courtNumberLabel, mainTable);


    }

    public void handleClick(MouseEvent event) {
        if (model.getTotalBooking() <= 6)
        {
            if (mainTable.getSelectionModel().getSelectedItem() != null)
            mainTable.getSelectionModel().getSelectedItem().setOnAction(this::retrieveData);
        }

    }

    public void retrieveData(ActionEvent actionEvent) {

        result = new ArrayList<>();
        String time = mainTable.getSelectionModel().getSelectedItem().getTime();
        String columnName = mainTable.getSelectionModel().getSelectedCells().get(0).getTableColumn().getText();
        clickedButton = ((Button) actionEvent.getSource());

        result.add(time);
        result.add(columnName);
        result.add(courtNumberLabel.getText());


        if (clickedButton.getText().equals("Book"))
        {
            appController.handleBookingClick(result, clickedButton);
        }
        else if (clickedButton.getText().equals("Unbook"))
        {
            appController.handleUnbookingClick(result);
        }

    }
    public ArrayList<String> getData(){
        return result;
    }


    @Override
    public void modelChanged() {
        //System.out.println("Model change for TableUI");
        clickedButton = model.getTargetButton();
        //System.out.println(clickedButton.getText());
        if (clickedButton.getText().equals("Book")) {
            clickedButton.setText("Unbook");
        } else if (clickedButton.getText().equals("Unbook")) {
//            System.out.println("deletion confirmed");
            clickedButton.setText("Book");
        }
    }

    public void setController(AppController controller) {
        this.appController = controller;

    }
    public void setSelectionCell(Button targetButton)
    {
        clickedButton = targetButton;
    }

    public void setModel(BookingModel model) {
        this.model = model;

    }
}
