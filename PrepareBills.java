package com.kdev.preparebills;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class PrepareBills extends Application {

	Orders orders = new Orders();
	int orderIndex = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
        File xmlFile = new File("orders1.xml");
        
        boolean xmlEmpty = !xmlFile.exists() || xmlFile.length() == 0;
        
        if(!xmlEmpty) {
        
        	JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            orders = (Orders) unmarshaller.unmarshal(xmlFile);
            
            orderIndex = orders.getOrders().size() - 1;
            
        }
        
        if(!xmlFile.exists()) {
        	
        	xmlFile.createNewFile();
        	new FileOutputStream(xmlFile, true).close();
        }
        

        		
		
        Label custmrNameLabel = new Label("Customer Name: ");
        custmrNameLabel.setFont(new Font(14.0));
        TextField custmrNameText = new TextField("");
        custmrNameText.setFont(new Font(14.0));
        
        Label productIdLabel = new Label("Product ID: ");
        productIdLabel.setFont(new Font(14.0));
        TextField productIdText = new TextField("");
        productIdText.setFont(new Font(14.0));
        
        Label salesmanLabel = new Label("Salesman: ");
        salesmanLabel.setFont(new Font(14.0));
        TextField salesmanText = new TextField("");
        salesmanText.setFont(new Font(14.0));
        
        Label phoneNumLabel = new Label("Phone Number: ");
        phoneNumLabel.setFont(new Font(14.0));
        TextField phoneNumText = new TextField("");
        phoneNumText.setFont(new Font(14.0));
        
        Label transactionIdLabel = new Label("Transaction ID: ");
        transactionIdLabel.setFont(new Font(14.0));
        TextField transactionIdText = new TextField("");
        transactionIdText.setFont(new Font(14.0));
        
        Label address1Label = new Label("Address Line 1: ");
        address1Label.setFont(new Font(14.0));
        TextField address1Text = new TextField("");
        address1Text.setFont(new Font(14.0));
        
        Label address2Label = new Label("Address Line 2: ");
        address2Label.setFont(new Font(14.0));
        TextField address2Text = new TextField("");
        address2Text.setFont(new Font(14.0));
        
        Label cityLabel = new Label("City: ");
        cityLabel.setFont(new Font(14.0));
        TextField cityText = new TextField("");
        cityText.setFont(new Font(14.0));
        
        Label pinCodeLabel = new Label("Pin Code: ");
        pinCodeLabel.setFont(new Font(14.0));
        TextField pinCodeText = new TextField("");
        pinCodeText.setFont(new Font(14.0));
        
        Label countryLabel = new Label("Country: ");
        countryLabel.setFont(new Font(14.0));
        TextField countryText = new TextField("");
        countryText.setFont(new Font(14.0));
        
        Button submitButton = new Button("Submit details");
        submitButton.setFont(new Font(18.0));
        
        Button detailsUpdateButton = new Button("Update details");
        detailsUpdateButton.setFont(new Font(18.0));
        
        Button saveButton = new Button("Save orders to XML");
        saveButton.setFont(new Font(18.0));
        
        Button addOrderButton = new Button("Add new order");
        addOrderButton.setFont(new Font(18.0));
        
        Button prevOrderButton = new Button(" < ");
        prevOrderButton.setFont(new Font(28.0));
        
        Button nextOrderButton = new Button(" > ");
        nextOrderButton.setFont(new Font(28.0));

        
        if(!xmlEmpty) {
        	
        	//Order tempOrder = orders.getOrders().get(0);
        	Order tempOrder = orders.getOrders().get(orderIndex);
        	custmrNameText.setText(tempOrder.getCustomerName());
        	productIdText.setText(tempOrder.getProductId());
        	salesmanText.setText(tempOrder.getSalesman());
        	phoneNumText.setText(String.valueOf(tempOrder.getPhoneNum()));
        	transactionIdText.setText(tempOrder.getTransactionId());
        	address1Text.setText(tempOrder.getAddress1());
        	address2Text.setText(tempOrder.getAddress2());
        	cityText.setText(tempOrder.getCity());
        	pinCodeText.setText(tempOrder.getPinCode());
        	countryText.setText(tempOrder.getCountry());
        }
        
        
        EventHandler<ActionEvent> prevOrderButtonHandler = new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	
    	 	
    	    	if(orderIndex > 0) {
    	    		
    	    		orderIndex--;
    	    		Order tempOrder = orders.getOrders().get(orderIndex);
    	        	custmrNameText.setText(tempOrder.getCustomerName());
    	        	productIdText.setText(tempOrder.getProductId());
    	        	salesmanText.setText(tempOrder.getSalesman());
    	        	phoneNumText.setText(String.valueOf(tempOrder.getPhoneNum()));
    	        	transactionIdText.setText(tempOrder.getTransactionId());
    	        	address1Text.setText(tempOrder.getAddress1());
    	        	address2Text.setText(tempOrder.getAddress2());
    	        	cityText.setText(tempOrder.getCity());
    	        	pinCodeText.setText(tempOrder.getPinCode());
    	        	countryText.setText(tempOrder.getCountry());
    	    	}
    	    	
    	    	event.consume();
    	    }
        };
        
        EventHandler<ActionEvent> nextOrderButtonHandler = new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	
    	 	
    	    	if(orderIndex < orders.getOrders().size() - 1) {
    	    		
    	    		orderIndex++;
    	    		Order tempOrder = orders.getOrders().get(orderIndex);
    	        	custmrNameText.setText(tempOrder.getCustomerName());
    	        	productIdText.setText(tempOrder.getProductId());
    	        	salesmanText.setText(tempOrder.getSalesman());
    	        	phoneNumText.setText(String.valueOf(tempOrder.getPhoneNum()));
    	        	transactionIdText.setText(tempOrder.getTransactionId());
    	        	address1Text.setText(tempOrder.getAddress1());
    	        	address2Text.setText(tempOrder.getAddress2());
    	        	cityText.setText(tempOrder.getCity());
    	        	pinCodeText.setText(tempOrder.getPinCode());
    	        	countryText.setText(tempOrder.getCountry());
    	    	}
    	    	
    	    	event.consume();
    	    }
        };
        
        EventHandler<ActionEvent> submitButtonHandler = new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	
    	 	
    	    	Order newOrder = new Order(custmrNameText.getText(),
    	    			productIdText.getText(), salesmanText.getText(),
    	    			Long.valueOf(phoneNumText.getText()),
    	    			transactionIdText.getText(), address1Text.getText(),
    	    			address2Text.getText(), cityText.getText(),
    	    			pinCodeText.getText(), countryText.getText());
    	    	
    	    	orders.add(newOrder);
    	    	
    	    	Alert newOrderAlert = new Alert(AlertType.INFORMATION);
    	    	newOrderAlert.setTitle("Success");
    	    	
    	    	orderIndex++;
	     
	            // Header Text: null
    	    	newOrderAlert.setHeaderText(null);
    	    	newOrderAlert.setContentText("The order by "+newOrder.getCustomerName()+" has been added to storage.");
	     
    	    	newOrderAlert.showAndWait();
    	    	
    	    	custmrNameText.setText("");
	        	productIdText.setText("");
	        	salesmanText.setText("");
	        	phoneNumText.setText("");
	        	transactionIdText.setText("");
	        	address1Text.setText("");
	        	address2Text.setText("");
	        	cityText.setText("");
	        	pinCodeText.setText("");
	        	countryText.setText("");
    	    	
    	    	//System.out.println(newOrder.toString());
    	    	//System.out.println(orders.getOrders().get(0).toString());
    	    	
    	    	
    	    	event.consume();
    	    }
        };
        
        EventHandler<ActionEvent> detailsUpdateButtonHandler = new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	
    	 	
    	    	Order newOrder = new Order(custmrNameText.getText(),
    	    			productIdText.getText(), salesmanText.getText(),
    	    			Long.valueOf(phoneNumText.getText()),
    	    			transactionIdText.getText(), address1Text.getText(),
    	    			address2Text.getText(), cityText.getText(),
    	    			pinCodeText.getText(), countryText.getText());
    	    	
    	    	//orders.add(newOrder);
    	    	orders.updateOrder(newOrder, orderIndex);
    	    	
    	    	Alert newOrderAlert = new Alert(AlertType.INFORMATION);
    	    	newOrderAlert.setTitle("Success");
    	    	
    	    	//orderIndex++;
	     
	            // Header Text: null
    	    	newOrderAlert.setHeaderText(null);
    	    	newOrderAlert.setContentText("The details of the order by "+newOrder.getCustomerName()+" have been updated.");
	     
    	    	newOrderAlert.showAndWait();
    	    	
    	    	//System.out.println(newOrder.toString());
    	    	//System.out.println(orders.getOrders().get(0).toString());
    	    	
    	    	
    	    	event.consume();
    	    }
        };
        
        EventHandler<ActionEvent> addOrderButtonHandler = new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	 	
    	    	custmrNameText.setText("");
	        	productIdText.setText("");
	        	salesmanText.setText("");
	        	phoneNumText.setText("");
	        	transactionIdText.setText("");
	        	address1Text.setText("");
	        	address2Text.setText("");
	        	cityText.setText("");
	        	pinCodeText.setText("");
	        	countryText.setText("");
    	    	
    	    	event.consume();
    	    }
        };
        
        
        EventHandler<ActionEvent> saveButtonHandler = new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	
    			JAXBContext jaxbContext1;
				try {
					jaxbContext1 = JAXBContext.newInstance(Orders.class);
					
					Marshaller marshaller1 = jaxbContext1.createMarshaller();

	    	        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

	    	        //System.out.println(orders.getOrders().size());
	    	        
	    	        marshaller1.marshal(orders, new File("orders1.xml")); 

				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    	    	event.consume();
    	    }
        };



        submitButton.setOnAction(submitButtonHandler);
        saveButton.setOnAction(saveButtonHandler);
        detailsUpdateButton.setOnAction(detailsUpdateButtonHandler);
        addOrderButton.setOnAction(addOrderButtonHandler);
        prevOrderButton.setOnAction(prevOrderButtonHandler);
        nextOrderButton.setOnAction(nextOrderButtonHandler);
        GridPane gridPane = new GridPane();   
        
        /*ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(65);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(15);
        gridPane.getColumnConstraints().addAll(col1,col2,col3);*/
        
        final int j = 1;
        gridPane.add(custmrNameLabel, 0, 0);
        gridPane.add(custmrNameText, 1, 0);
        gridPane.add(productIdLabel, 0, 1);
        gridPane.add(productIdText, 1, 1);
        gridPane.add(salesmanLabel, 0, 2);
        gridPane.add(salesmanText, 1, 2);
        gridPane.add(phoneNumLabel, 0, 3);
        gridPane.add(phoneNumText, 1, 3);
        gridPane.add(transactionIdLabel, 0, 4);
        gridPane.add(transactionIdText, 1, 4);
        gridPane.add(address1Label, 0, 5);
        gridPane.add(address1Text, 1, 5);
        gridPane.add(address2Label, 0, 6);
        gridPane.add(address2Text, 1, 6);
        gridPane.add(cityLabel, 0, 7);
        gridPane.add(cityText, 1, 7);
        gridPane.add(pinCodeLabel, 2, 7);
        gridPane.add(pinCodeText, 3, 7);
        gridPane.add(countryLabel, 0, 8);
        gridPane.add(countryText, 1, 8);
        Separator separator1 = new Separator();
        gridPane.add(separator1, 0, 9);
        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(15, 12, 15, 12));
        hBox1.setSpacing(20);
        gridPane.add(hBox1, 0, 10);
        gridPane.add(detailsUpdateButton, 0, 11);
        gridPane.add(saveButton, 1, 11);
        gridPane.add(submitButton, 2, 11);
        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(15, 12, 15, 12));
        hBox2.setSpacing(20);
        gridPane.add(hBox2, 0, 13);
        gridPane.add(addOrderButton, 0, 14);
        gridPane.add(prevOrderButton, 1, 14);
        gridPane.add(nextOrderButton, 2, 14);
        
        
        GridPane topGPane = new GridPane();
        GridPane rightGPane = new GridPane();
        
        HBox topBox = new HBox();
        topBox.setPadding(new Insets(15, 12, 15, 12));
        topBox.setSpacing(20);
        topBox.setStyle("-fx-background-color: #337699;");
        
        VBox leftBox = new VBox();
        leftBox.setPadding(new Insets(12, 15, 12, 15));
        leftBox.setSpacing(20);
        leftBox.setStyle("-fx-background-color: #336699;");
        
        Label emptyLabel = new Label("AAAAA");
        leftBox.setMargin(emptyLabel, new Insets(20, 20, 20, 20));
        
        
        rightGPane.add(leftBox, 0, 0);
        rightGPane.add(gridPane, 1, 0);
        topGPane.add(topBox, 0, 0);
        topGPane.add(rightGPane, 0, 1);
        
        //topGPane.add(gridPane, 1, 1);
        
        //Scene scene = new Scene(gridPane);
        Scene scene = new Scene(topGPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(1000);
        primaryStage.show();
        
        //Setting title to the Stage 
        primaryStage.setTitle("Prepare Bills   Coder:Sasank");  

		
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
