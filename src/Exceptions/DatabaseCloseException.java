package Exceptions;

public class DatabaseCloseException extends RuntimeException{
            
            public DatabaseCloseException(String msg){
                super(msg);
            }
        
            public DatabaseCloseException(){
                super("Erro ao fechar a conexão com o banco de dados.");
            }
    
}
