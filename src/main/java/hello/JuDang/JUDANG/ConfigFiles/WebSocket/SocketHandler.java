package hello.JuDang.JUDANG.ConfigFiles.WebSocket;

import hello.JuDang.JUDANG.Domain.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

@Component
public class SocketHandler extends TextWebSocketHandler {


    private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>()); // 처음 웹소켓 요청시 생성됨

    // 예약되면 호출되는 함수
    public void shopReservationFind(List<Reservation> reservation) throws Exception{
        Iterator<WebSocketSession> iterator = sessions.iterator();

        while(iterator.hasNext()){
            WebSocketSession session = iterator.next();
            try {
                for(int i = 0; i<reservation.size(); i++){
                    TextMessage message = new TextMessage((CharSequence) reservation.get(i));
                    session.sendMessage(message);
                }
            }catch (IOException e){
                iterator.remove();
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 웹소켓이 종료되면 동작
        sessions.remove(session);
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }
}
