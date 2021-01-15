package com.spring.in.action.chapter04;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ****
 *
 * @author Alphonse
 * @date 2019/12/31 09:16
 * @since 1.0
 **/
@Setter
@Getter
public class BlankDisc extends CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;
}
