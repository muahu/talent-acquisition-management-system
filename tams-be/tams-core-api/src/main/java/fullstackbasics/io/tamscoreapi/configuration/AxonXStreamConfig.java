package fullstackbasics.io.tamscoreapi.configuration;

import com.thoughtworks.xstream.XStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonXStreamConfig {
    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();


        xStream.allowTypesByWildcard(new String[] {
                "io.fullstackbasics.**",
                "fullstackbasics.io.**"
        });

        return xStream;
    }
}
