package br.edu.ufersa.EditorialdoPaulao.controller;

import br.edu.ufersa.EditorialdoPaulao.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditarObraAutorController {

	ObservableList<String> obras = FXCollections.observableArrayList("As Crônicas de Nárnia", "O Senhor dos Anéis", "Harry Potter e a Pedra Filosofal");
	
	@FXML
	private ChoiceBox<String> obra; //titulos
	
	@FXML
	private TextField titulo;
	
	@FXML
	private TextField genero;
	
	@FXML
	private TextField ano;
	
	@FXML
	private Label mensagemLabel;
	
	@FXML
	private Button btncancelar;
	
	@FXML
	private void initialize() {
		obra.setItems(obras);
	}
	
	public void concluir(ActionEvent event) {
		
        String selecao = (String) obra.getValue(); 
        if (selecao != null) {
            // editar obra 
        } else {
        	mensagemLabel.setText("Você deve selecionar uma obra.");
        	mensagemLabel.setVisible(true);
            return;
        }
        
	    String tituloText = titulo.getText();
	    String generoText = genero.getText();
	    String anoText = ano.getText();
	    if (tituloText.isEmpty() || generoText.isEmpty() || anoText.isEmpty()) {
	        mensagemLabel.setText("Por favor, preencha todos os campos.");
	        mensagemLabel.setVisible(true);
	        return;
	    } else {
	        System.out.println("Edição bem-sucedida.");
	        mensagemLabel.setText("Edição bem-sucedida.");
	        mensagemLabel.setVisible(true);
	        btncancelar.setText("Fechar");
	    }
	}
	
	public void cancelar(ActionEvent event) {
		try {
			Telas.telaPrincipal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
