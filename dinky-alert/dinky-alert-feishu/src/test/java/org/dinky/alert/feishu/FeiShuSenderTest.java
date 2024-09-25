/*
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.dinky.alert.feishu;

import org.dinky.alert.AlertBaseConstant;
import org.dinky.alert.AlertConfig;
import org.dinky.alert.AlertResult;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/** @Author: zhumingye */
@Ignore
public class FeiShuSenderTest {

    private static Map<String, Object> feiShuConfig = new HashMap<>();

    @Before
    public void initFeiShuConfig() {
        feiShuConfig.put(FeiShuConstants.WEB_HOOK, "https://webhook.qimai.shop/webhook?token=fb71f0f7075180fde8f8a5ea2c9bab5062fa14ec");
        feiShuConfig.put(FeiShuConstants.KEYWORD, "告警");
        feiShuConfig.put(FeiShuConstants.AT_ALL, "");
        feiShuConfig.put(FeiShuConstants.AT_USERS, "");
    }

    @Ignore
    @Test
    public void testSend() {

        FeiShuAlert feiShuAlert = new FeiShuAlert();
        AlertConfig alertConfig = new AlertConfig();

        alertConfig.setType(FeiShuConstants.TYPE);
        alertConfig.setParam(feiShuConfig);
        feiShuAlert.setConfig(alertConfig);

        String content = "Job Name : test1111\n- Job Status : CANCELED\n- Alert Time : 2024-09-13 19:57:11\n- Start Time : 2024-09-13 19:56:51\n- End Time : 2024-09-13 19:57:09\nGo toTask Web\n";
        AlertResult alertResult =
                feiShuAlert.send(AlertBaseConstant.ALERT_TEMPLATE_TITLE, content);
        Assert.assertEquals(true, alertResult.getSuccess());
    }
}
