package br.edu.ufersa.EditorialdoPaulao.exceptions;

public class ErroLoginException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public ErroLoginException() {
        super("Login inválido.");
    }
}
