package com.example.demo.interfaces.worker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClearCacheWorker {

    @Scheduled(cron = "0/30 * 8-14 * * *") // code to be executed every 30 seconds between 8:30 AM and 10:15 AM
    @Caching(evict = {
            @CacheEvict(cacheNames = "ScreenerService",  allEntries = true),
            @CacheEvict(cacheNames = "CompanyServiceRefresh", allEntries = true),
            @CacheEvict(cacheNames = "AggregateAnalysisRepositoryRefresh", allEntries = true)
    })
    public void clearCache() {
        log.info("code to be executed every 30 seconds between 08 AM and 15 PM");
    }

}
