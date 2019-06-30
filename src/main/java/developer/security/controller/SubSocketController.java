package developer.security.controller;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.corundumstudio.socketio.listener.ConnectListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import developer.security.configuration.SocketIoServerConfiguration;

/**
 * SubSocketController
 */
@Component
public class SubSocketController {
    
    
    SocketIOServer socketIOServer;

    {
        socketIOServer = SocketIoServerConfiguration.socketServer(1212);


        socketIOServer.addConnectListener(new ConnectListener(){
        
            @Override
            public void onConnect(SocketIOClient client) {
                System.out.println("connected to 1212");
                socketIOServer.getBroadcastOperations().sendEvent("responser",client.getSessionId());
            }
        });

        
    }

    
}