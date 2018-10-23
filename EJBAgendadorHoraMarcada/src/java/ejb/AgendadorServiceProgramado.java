/*
 *EJB - SingletonBean
 */
package ejb;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 *
 * @author Albert Lima de Melo
 */

@Singleton //Garante que haverá apenas uma instância
@Startup  //Inicia o serviço automaticamente quando o servidor subir...no caso o JBOSS
public class AgendadorServiceProgramado{
    
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
        
        ScheduleExpression schedule = new ScheduleExpression();
        TimerConfig config = new TimerConfig(); //eh uma forma de configurar as informações da tarefa 
        
        
        Collection<Timer> lista = service.getTimers();
        
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS------" + lista.size());
        for( Timer a :lista){
            System.out.println(a.getInfo());
            
            a.cancel(); /// cancela o timer que ficou persistido
        }
       //2
        //Agendando uma tarefa
        //service.createCalendarTimer(expressao, config)
        
        //Timer de repetição e agendamento da dia
        
        schedule.hour("*"); //a cada hora
        schedule.minute("*"); //a cada minuto
        schedule.second("*/10"); //a cada 15 minuto
        
        config.setInfo("Teste de expressão do tempo a cada 10 segundos");
        config.setPersistent(false); /// O Timer não persiste 
        service.createCalendarTimer(schedule, config);
    }
    
    //quando bater o tempo ele executa o metodo anotado com timeout
    @Timeout
    public void executar(Timer timer){
        
        System.out.println("Enviando mensagem de email..." + timer.getInfo());
        
    }
  
}
