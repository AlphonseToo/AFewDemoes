package com.spring.in.action.chapter04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Alphonse
 * @date 2019/12/31 09:11
 * @since 1.0
 **/
@Configuration
@EnableAspectJAutoProxy
public class TrackCountConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The beatles");
        List<String> tracks = new ArrayList<>();
        tracks.add("Act 1");
        tracks.add("Act 2");
        tracks.add("Act 3");
        tracks.add("Act 4");
        tracks.add("Act 5");
        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
