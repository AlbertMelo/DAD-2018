/*
 *EJB - SingletonBean
 */
package ejb;

import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 *
 * @author Albert Lima de Melo
 */

@Singleton //Garante que haverá apenas uma instância
@Startup  //Inicia o serviço automaticamente quando o servidor subir...no caso o JBOSS
public class AgendadorService{
    
    /*
    Timer service cria uma lista de temporizadores;
    Precisamos inserir um timer nessa lista de temporizadores
    */
    @Resource
    private TimerService service;
    /*
    CDI
    */
    
    @PostConstruct //executado depois do construtor
    public void iniciar(){
        //1
        //voce vai executa rum temporizador a cada 5 seg
        //Exercutar uma tarefa
       // service.createTimer(tempo em millisegundos , Mensagem); //long em millisegundos
        service.createTimer(2000L , "envio de email"); //long em millisegundos
        
               
    
    }
    
    //quando bater o tempo ele executa o metodo anotado com timeout
    @Timeout
    public void executar(Timer timer){
        
        System.out.println("Enviando email..." + timer.getInfo());
        
    }
    
    
  
}
