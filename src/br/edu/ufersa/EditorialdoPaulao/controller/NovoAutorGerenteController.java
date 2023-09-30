package br.edu.ufersa.EditorialdoPaulao.controller;

import br.edu.ufersa.EditorialdoPaulao.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NovoAutorGerenteController {

	@FXML
	private TextField cpf;
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField endereco;
	
	@FXML
	private Label mensagemLabel;
	
	@FXML
	private Button btncancelar;
	
	public void adicionar(ActionEvent event) {
	    String cpfText = cpf.getText();
	    String nomeText = nome.getText();
	    String enderecoText = endereco.getText();
	    if (cpfText.isEmpty() || nomeText.isEmpty() || enderecoText.isEmpty()) {
	        mensagemLabel.setText("Por favor, preencha todos os campos.");
	        mensagemLabel.setVisible(true);
	    } else {
	        System.out.println("Autor adicionado com sucesso");
	        mensagemLabel.setText("Autor adicionado com sucesso");
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
