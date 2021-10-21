package example.batch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.StopWatch;

import java.util.ArrayList;

@SpringBootTest
class PayRepositoryTest {

    @Autowired
    private PayRepository payRepository;
//    @BeforeEach
//    void setUp() {
//        System.out.println("t@adasdasdasdasdasd");
//    }

    @Test
    public void save() throws Exception {
        // given
        StopWatch stopWatch = new StopWatch("changJun");

        // when
        stopWatch.start("save 100개");
        for (int i = 0; i < 100; i++) {
            payRepository.save(new Pay(i));
        }
        stopWatch.stop();
        // then
        System.out.println("stopWatch,shortSummary() = " + stopWatch.shortSummary());
        System.out.println("stopWatch.getTotalTimeMillis() = " + stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch.prettyPrint() = " + stopWatch.prettyPrint());

    }

    @Test
    public void saveAll() throws Exception{
        // given
        StopWatch stopWatch = new StopWatch("changJun");
        // when
        stopWatch.start("saveAll 100개");
        ArrayList<Pay> pays = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            pays.add(new Pay(i));
        }
        payRepository.saveAll(pays);
        stopWatch.stop();
        // then
        System.out.println("stopWatch,shortSummary() = " + stopWatch.shortSummary());
        System.out.println("stopWatch.getTotalTimeMillis() = " + stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch.prettyPrint() = " + stopWatch.prettyPrint());
    }

}