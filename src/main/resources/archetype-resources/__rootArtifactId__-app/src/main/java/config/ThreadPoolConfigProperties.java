#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "thread.pool.executor.config", ignoreInvalidFields = true)
public class ThreadPoolConfigProperties {

    /**
     * 核心线程数
     */
    private Integer corePoolSize = 20;
    /**
     * 最大线程数
     */
    private Integer maxPoolSize = 200;
    /**
     * 最大等待时间
     */
    private Long keepAliveTime = 10L;
    /**
     * 最大队列数
     */
    private Integer blockQueueSize = 5000;
    /**
     * 线程池在任务队列已满且无法立即执行新提交的任务时所采取的策略
     */
    private String policy = ThreadPoolPolicy.Abort;

    /**
     * 线程池在任务队列已满且无法立即执行新提交的任务时所采取的策略
     */
    public static class ThreadPoolPolicy {
        /**
         * 丢弃任务并抛出RejectedExecutionException异常(默认策略)
         */
        public static final String Abort = "AbortPolicy";
        /**
         * 直接丢弃任务，但是不会抛出异常
         */
        public static final String Discard = "DiscardPolicy";
        /**
         * 将最早进入队列的任务删除，之后再尝试加入队列的任务被拒绝
         */
        public static final String DiscardOldest = "DiscardOldestPolicy";
        /**
         * 如果任务添加线程池失败，那么主线程自己执行该任务
         */
        public static final String CallerRuns = "CallerRunsPolicy";
    }
}
