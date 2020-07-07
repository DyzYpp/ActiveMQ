package Spring;

import com.sun.xml.internal.ws.api.model.MEP;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @ClassName MyMessageListener
 * @Author
 * @Date 2020/7/6
 * @description
 */
@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (null != message && message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String textMessageText = textMessage.getText();
                System.out.println(textMessageText);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
