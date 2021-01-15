package com.spring.in.action.chapter05.test;

import com.spring.in.action.chapter05.Spittle;
import com.spring.in.action.chapter05.SpittleRepository;
import com.spring.in.action.chapter05.web.HomeController;
import com.spring.in.action.chapter05.web.SpittleController;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ****
 *
 * @author Alphonse
 * @date 2020/1/7 15:33
 * @since 1.0
 **/
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        assert "home".equals(controller.home());
    }

    @Test
    public void shouldShowRencentSpittles() throws Exception {
        List<Spittle> spittleList = createSpittleList(20);
        SpittleRepository mockRep = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRep.findSpittles(Long.MAX_VALUE, 20)).thenReturn(spittleList);

        SpittleController controller = new SpittleController(mockRep);
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
