package org.myorg.quickstart.sources;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import java.util.Random;

public class RandomNumberSource extends RichParallelSourceFunction<Tuple2<String, Integer>> {
    private volatile boolean isRunning = true;

    @Override
    public void run(SourceContext<Tuple2<String, Integer>> sourceContext) throws Exception {
        Random random = new Random();
        int ctr = 0;
        while (isRunning) {
            if(ctr == 10000) {
                Thread.sleep(10);
                ctr = 0;
            }

            String key = "key" + (char) ('A' + random.nextInt(3));
            int value = random.nextInt(10) + 1;
            //System.out.println(String.format("Emits\t(%s, %d)", key, value));
            sourceContext.collectWithTimestamp(new Tuple2<>(key, value), System.currentTimeMillis());


            ctr++;
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }
}
