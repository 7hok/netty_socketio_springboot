package developer.security.configuration;

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

    @Bean
    public Configuration socketConfiguration(){
        // SocketIOServer server = new SocketIOServer()
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(3000);
        return config;
    }

    @Bean
    public SocketIOServer socketIOServer(){
        SocketIOServer server = new SocketIOServer(socketConfiguration());
        System.out.println("server start aii");
        server.start();
        return server;


    }
    
}