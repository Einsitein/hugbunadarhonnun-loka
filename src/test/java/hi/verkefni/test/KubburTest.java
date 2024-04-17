package hi.verkefni.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hi.verkefni.vinnsla.Kubbur;

class KubburTest {

    private Kubbur kubbur;

    @BeforeEach
    public void setUp() {
        kubbur = new Kubbur(3, 3);
    }

    @Test
    void testGetAndSetStig() {
        int beforeStig = kubbur.getStig();
        int deltaStig = 10;
        kubbur.changeStig(deltaStig);
        int afterStig = kubbur.getStig();
        Assertions.assertEquals(beforeStig + deltaStig, afterStig);
    }

    @Test
    void testGetBordStykki() {
        ArrayList<Integer> bordStykkiList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bordStykkiList.add(kubbur.getBordStykki(i, j).getTala());
            }
        }
        bordStykkiList.sort(null);
        ArrayList<Integer> expectedList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assertions.assertEquals(expectedList, bordStykkiList);
    }

}