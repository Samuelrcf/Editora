package model.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.DAO.AutorDAO;
import model.DAO.ObraDAO;
import model.VO.AutorVO;
import model.VO.ObraVO;
import model.VO.UsuarioVO;
import util.LerPDF;

public class AutorBO {

    private AutorDAO autorDAO = new AutorDAO();
	
	public void adicionarObra(String obraSelecionada, String titulo, String genero, LocalDate ano, AutorVO autorVO) throws IOException {
	    if (obraSelecionada.isEmpty() || titulo.isEmpty() || genero.isEmpty()) {
	        throw new IllegalArgumentException("Por favor, preencha todos os campos.");
	    }

	    if (ano == null) {
	        throw new IllegalArgumentException("O campo de data não pode estar vazio.");
	    }

	    byte[] pdfObraBytes = LerPDF.lerConteudoPDF(obraSelecionada);

	    if (pdfObraBytes == null) {
	        throw new IOException("Erro ao ler o arquivo PDF.");
	    }

	    ObraVO novaObra = new ObraVO();
	    novaObra.setTitulo(titulo);
	    novaObra.setGenero(genero);
	    novaObra.setAno(ano);
	    novaObra.setPdfObra(pdfObraBytes);
        novaObra.setAutor(autorVO);
        novaObra.setStatus("Avaliador Pendente");

        ObraDAO obraDAO = new ObraDAO();
	    obraDAO.inserir(novaObra);
	}

	public void editarObra(String obraChoiceBox, String titulo, String genero, LocalDate ano, AutorVO autorVO, String obraSelecionada) throws IOException {
	    if (obraSelecionada.isEmpty() || titulo.isEmpty() || genero.isEmpty()) {
	        throw new IllegalArgumentException("Por favor, preencha todos os campos.");
	    }

	    if (ano == null) {
	        throw new IllegalArgumentException("O campo de data não pode estar vazio.");
	    }

	    byte[] pdfObraBytes = LerPDF.lerConteudoPDF(obraSelecionada);

	    if (pdfObraBytes == null) {
	        System.out.println("Erro ao ler o arquivo PDF.");
	        throw new IOException("Erro ao ler o arquivo PDF.");
	    }

	    ObraDAO obraDAO = new ObraDAO();
	    ObraVO obraVO = new ObraVO();
	    System.out.println(obraChoiceBox);
	    obraVO.setTitulo(obraChoiceBox);

	    List<ObraVO> obras = null;
		try {
			obras = obraDAO.buscarPorTitulo(obraVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    if (!obras.isEmpty()) {
	        ObraVO novaObra = obras.get(0);
	        novaObra.setIDObra(obras.get(0).getIDObra());
	        novaObra.setTitulo(titulo);
	        novaObra.setGenero(genero);
	        novaObra.setAno(ano);
	        novaObra.setPdfObra(pdfObraBytes);
	        novaObra.setAutor(autorVO);
	        novaObra.setStatus("Avaliador Pendente");

	        obraDAO.atualizar(novaObra);
	    } else {
	        // Trate o caso em que a lista está vazia, por exemplo, lançando uma exceção.
	        throw new RuntimeException("Obra não encontrada para edição.");
	    }
	}


    public List<AutorVO> listar() {
        List<AutorVO> autores = autorDAO.listar();
        return autores;
    }
    
    public List<ObraVO> listarObrasProprias (AutorVO autorVO) {
        ObraDAO obraDAO = new ObraDAO();
        List<ObraVO> obras = obraDAO.buscarPorAutor(autorVO);
        return obras;
    }
    
    public AutorVO convertToAutorVO(UsuarioVO usuarioVO) {
        AutorVO autorVO = new AutorVO();
        autorVO.setEmail(usuarioVO.getEmail());

        ArrayList<AutorVO> autores = autorDAO.buscarPorEmail(autorVO); // só retornará 1 autor
        for (AutorVO autor : autores) {
            autorVO = autor;
        }

        return autorVO;
    }
    
    public void excluir(AutorVO autorVO) {
    	autorDAO.excluir(autorVO);
    }
    
    public void atualizar(AutorVO autorVO) {
    	autorDAO.atualizar(autorVO);
    }
    
    public List<AutorVO> buscarPorEmail (AutorVO autorVO) {
    	ArrayList<AutorVO> autores = autorDAO.buscarPorEmail(autorVO);
        return autores;
    }   
}
