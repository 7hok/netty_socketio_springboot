package developer.security.configuration;

import javax.annotation.PreDestroy;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;

import org.springframework.context.annotation.Bean;


/**
 * SocketIoServerConfiguration
 * SocketIoServer
 * 
 */
@org.springframework.context.annotation.Configuration
public class SocketIoServerConfiguration {

    SocketIOServer server;

    @Bean
    public SocketIOServer socketIOServer(){
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(5657);

        /**
         * not to reopen application
         */
        SocketConfig socketConfig = config.getSocketConfig();
        socketConfig.setReuseAddress(true);

        server = new SocketIOServer(config);
        server.start();
        return server;

 
    }


    

    @PreDestroy
    public void closeConnection(){
        System.out.println("server stop");
        this.server.stop();
    }
    

    public static SocketIOServer socketServer(int port){
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(port);

        /**
         * not to reopen application
         */
        SocketConfig socketConfig = config.getSocketConfig();
        socketConfig.setReuseAddress(true);

        SocketIOServer server = new SocketIOServer(config);
        server.start();
        return server;

 
    }
}