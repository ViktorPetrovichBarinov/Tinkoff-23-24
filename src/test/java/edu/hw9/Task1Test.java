package edu.hw9;

import edu.hw9.Task1.Metric;
import edu.hw9.Task1.StatsCollector;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    private static final double EPSILON = 0.0001;
    @Test
    void test1() throws InterruptedException {
        StatsCollector collector = new StatsCollector(4);

        collector.push("metric1", new double[]{0.1, 0.1, 1.4, 5.1, 0.3});
        List<Metric> metricStatsList = collector.stats();

        assertThat(Math.abs(metricStatsList.get(0).summary() - 7) < EPSILON).isTrue();
        assertThat(Math.abs(metricStatsList.get(0).average() - 1.4) < EPSILON).isTrue();
        assertThat(Math.abs(metricStatsList.get(0).minimum() - 0.1) < EPSILON).isTrue();
        assertThat(Math.abs(metricStatsList.get(0).maximum() - 5.1) < EPSILON).isTrue();
    }
}
