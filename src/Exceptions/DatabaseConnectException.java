package Exceptions;

public class DatabaseConnectException extends RuntimeException{
        
        public DatabaseConnectException(String msg){
            super(msg);
        }
    
        public DatabaseConnectException(){
            super("Erro ao conectar ao banco de dados.");
        }
    
}
