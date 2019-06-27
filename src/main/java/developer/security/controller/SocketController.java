package developer.security.controller;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SocketController
 */
@Component
public class SocketController {

    SocketIOServer socketIOServer;

    @Autowired
    SocketController(SocketIOServer socketIOServer) {

        this.socketIOServer = socketIOServer;

        this.socketIOServer.addConnectListener(new ConnectListener() {

            @Override
            public void onConnect(SocketIOClient client) {
                System.out.println("user connected aiii" + client.getSessionId());
            }

        });

        this.socketIOServer.addDisconnectListener(new DisconnectListener() {

            @Override
            public void onDisconnect(SocketIOClient client) {
                System.out.println("close aiii");
            }

        });
        /**
         * 1p . emit event from socket 2p . data come with emit 3p.
         */
        this.socketIOServer.addEventListener("new post", String.class, new DataListener<String>() {

            @Override
            public void onData(SocketIOClient client, String data, AckRequest askSender) throws Exception {
                System.out.println("");
            }
            
        });
    }
}