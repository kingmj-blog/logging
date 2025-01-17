package com.logging.kingmj.scheduler;

import com.logging.kingmj.scheduler.service.BaseSchedule;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAccountScheduler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final BaseSchedule deleteUserSchedule;
    private final BaseSchedule autoApproveUserSchedule;

    @Scheduled(cron = "0 0 15 * * ?")
    public void executeDeleteUserAfter7Days() {
        logger.info("----------------- start Batch executeDeleteUserAfter7Days schedule -------------------");
        try {
            deleteUserSchedule.execute();
        } catch (Exception e) {
            logger.error("계정 삭제 처리중 오류", e);
        }
        logger.info("----------------- end Batch executeDeleteUserAfter7Days schedule -------------------");
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void executeAutoApproveAfter3Days() {
        logger.info("----------------- start Batch executeAutoApproveAfter3Days schedule -------------------");
        try {
            autoApproveUserSchedule.execute();
        } catch (Exception e) {
            logger.error("회원가입 자동 승인 처리중 오류", e);
        }
        logger.info("----------------- end Batch executeAutoApproveAfter3Days schedule -------------------");
    }
}
