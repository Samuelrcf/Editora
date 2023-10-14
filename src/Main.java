import view.Telas;

import java.time.LocalDate;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import model.BO.ObraBO;
import model.BO.UsuarioBO;
import model.DAO.AutorDAO;
import model.DAO.ObraDAO;
import model.VO.AutorVO;
import model.VO.ObraVO;
import model.VO.UsuarioVO;
import util.LerPDF;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        launch();

    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Telas.setPrimaryStage(primaryStage);
        Telas.telaLogin();
    }
    
    /*public static void testeAdicionarUsuario() {
        //é só mudar o tipo para testar
        UsuarioVO usuarioVO = new UsuarioVO("Jorge", "Rua Manoel Jorge", "12345678910", "jorge.local@gmail.com",
                "Ajf2#dsafd", "Avaliador");
        UsuarioBO<UsuarioVO> usuarioBO = new UsuarioBO<>();
        try {
            usuarioBO.cadastrar(usuarioVO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
    
    /*public static void testeAdicionarObra() {
        ObraVO obraVO = new ObraVO("Joãozinho na terra dos sonhos", "Aventura", LocalDate.of(2000, 1, 1), autor);
        ObraBO obraBO = new ObraBO();
        try {
            obraBO.cadastrar(obraVO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testeObraMaisAutor() {
        UsuarioVO usuarioVO = new UsuarioVO("Jorge", "Rua Manoel Jorge", "12345678910", "jorge.local@gmail.com",
                "Ajf2#dsafd", "Autor");
        UsuarioBO<UsuarioVO> usuarioBO = new UsuarioBO<>();
        try {
            usuarioBO.cadastrar(usuarioVO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        AutorDAO autorDAO = new AutorDAO();
        ArrayList<AutorVO> autores = autorDAO.listar();
        AutorVO autor = new AutorVO();
        for (AutorVO autorVO : autores) { \\\\haverá só 1
            autor = autorVO;
        }
        
        ObraVO obraVO = new ObraVO("Joãozinho na terra dos sonhos", "Aventura", LocalDate.of(2000, 1, 1), autor);
        ObraBO obraBO = new ObraBO();
        try {
            obraBO.cadastrar(obraVO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/

}