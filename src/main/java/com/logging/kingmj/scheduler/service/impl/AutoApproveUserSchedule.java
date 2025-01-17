package com.logging.kingmj.scheduler.service.impl;

import com.logging.kingmj.scheduler.service.BaseSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("autoApproveUserSchedule")
public class AutoApproveUserSchedule implements BaseSchedule {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String TEST_SELECT_SQL = """
            SELECT user_id, user_name
              FROM user_account
             WHERE status = 0
               AND update_date = DATE_SUB(CURDATE(), INTERVAL 7 DAY);
            """;
    private static final String TEST_DELETE_SQL = """
            DELETE FROM user_account
             WHERE user_id = #{userId}
            """;

    @Override
    public void execute() {
        // 탈퇴 후, 7일 지난 고객사 조회
        logger.info("[MySQL]\n{}", TEST_SELECT_SQL);
        logger.info("[MySQL]\n{}", TEST_DELETE_SQL);
    }
}
