package controller;

import view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CadastrarController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField enderecoField;

    @FXML
    private TextField senhaField;

    @FXML
    private TextField confirmaSenhaField;

    @FXML
    private RadioButton autorRadioButton;

    @FXML
    private RadioButton avaliadorRadioButton;

    @FXML
    private ToggleGroup radiocadastro;

    @FXML
    private Label mensagemLabel;

    @FXML
    public void cadastrar(ActionEvent event) {
        String username = usernameField.getText();
        String email = emailField.getText();
        String cpf = cpfField.getText();
        String endereco = enderecoField.getText();
        String senha = senhaField.getText();
        String confirmaSenha = confirmaSenhaField.getText();

        RadioButton selectedRadioButton = (RadioButton) radiocadastro.getSelectedToggle();
        String tipoUsuario = (selectedRadioButton != null) ? selectedRadioButton.getText() : "";

        if (username.isEmpty() || email.isEmpty() || cpf.isEmpty() || endereco.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()) {
            mensagemLabel.setText("Por favor, preencha todos os campos.");
            mensagemLabel.setVisible(true);

        } else if (!senha.equals(confirmaSenha)) {
            mensagemLabel.setText("As senhas não coincidem.");
            mensagemLabel.setVisible(true);
            
        } else {
        	
            if (tipoUsuario.isEmpty()) {
            	mensagemLabel.setText("Você deve selecionar o tipo de usuário.");
            	mensagemLabel.setVisible(true);
            	return;
            }
        	System.out.println("Cadastro realizado com sucesso.");
            //cadastrar usuário
        	try {
				Telas.telaLogin();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    }
    
    @FXML
    public void voltar(ActionEvent event) {
    	try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
