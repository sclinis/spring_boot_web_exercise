package com.navent.exercise.configuration;

import com.google.common.collect.Lists;
import com.navent.exercise.model.Player;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Data
public class ExampleConfiguration {

    @Bean
    public List<Player> initPlayerList() {
        /*List<Player> players = Lists.newArrayList();
        players.add(new Player(1L, "Lionel", "Messi", LocalDate.of(1987, 6, 24)));
        players.add(new Player(2L, "Cristiano", "Ronaldo", LocalDate.of(1985, 2, 5)));
        players.add(new Player(3L, "Juan Roman", "Riquelme", LocalDate.of(1978, 6, 24)));
        players.add(new Player(4L, "Lisandro", "Martinez", LocalDate.of(1998, 1, 18)));
        players.add(new Player(5L, "Javier", "Mascherano", LocalDate.of(1984, 6, 8)));
        players.add(new Player(6L, "Sergio", "Aguero", LocalDate.of(1988, 6, 2)));
        players.add(new Player(7L, "Carlitos", "Tevez", LocalDate.of(1984, 2, 5)));
        players.add(new Player(8L, "Franco", "Armani", LocalDate.of(1986, 10, 16)));*/

        List<Player> players = Lists.newArrayList();
        players.add(new Player(1L, "Lionel", "Messi", LocalDate.of(1987, 6, 24), 560, true));
        players.add(new Player(2L, "Cristiano", "Ronaldo", LocalDate.of(1985, 2, 5), 559, true));
        players.add(new Player(3L, "Juan Roman", "Riquelme", LocalDate.of(1978, 6, 24), 120, false));
        players.add(new Player(4L, "Lisandro", "Martinez", LocalDate.of(1998, 1, 18), 7, true));
        players.add(new Player(5L, "Javier", "Mascherano", LocalDate.of(1984, 6, 8), 20, false));
        players.add(new Player(6L, "Sergio", "Aguero", LocalDate.of(1988, 6, 2), 323, false));
        players.add(new Player(7L, "Carlitos", "Tevez", LocalDate.of(1984, 2, 5), 371, false));
        players.add(new Player(8L, "Franco", "Armani", LocalDate.of(1986, 10, 16), 1, true));

        return players;

    }
}
