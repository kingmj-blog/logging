package com.logging.kingmj.scheduler.service.impl;

import com.logging.kingmj.scheduler.service.BaseSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("deleteUserSchedule")
public class DeleteUserSchedule implements BaseSchedule {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String TEST_SELECT_SQL = """
            SELECT user_id, user_name
              FROM user_account
             WHERE status = 1
               AND create_date = DATE_SUB(CURDATE(), INTERVAL 3 DAY);
            """;
    private static final String TEST_UPDATE_SQL = """
            UPDATE user_account
               SET status = 2
             WHERE user_id = #{userId}
            """;

    @Override
    public void execute() {
        // 가입 후, 3일 지난 고객 자동 승인
        logger.info("[MySQL]\n{}", TEST_SELECT_SQL);
        logger.info("[MySQL]\n{}", TEST_UPDATE_SQL);
    }
}
