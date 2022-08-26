package com.dm.push.scheduler;

import com.dm.push.scheduler.service.EmailService;
import com.dm.push.scheduler.service.WxService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 调度器
 *
 * @author dm
 * @date 2022/08/26
 */
@Component
@RequiredArgsConstructor
public class PushScheduler {

    private final WxService wxService;
    private final EmailService emailService;

    @Scheduled(cron = "0 0 8 * * ?")
    public void wxPush() {
        //wxService.push();
        emailService.push();
    }
}
