package com.dianping.puma.alarm.render;

import com.dianping.puma.alarm.exception.PumaAlarmRenderException;
import com.dianping.puma.alarm.exception.PumaAlarmRenderUnsupportedException;
import com.dianping.puma.alarm.model.AlarmMessage;
import com.dianping.puma.alarm.model.benchmark.AlarmBenchmark;
import com.dianping.puma.alarm.model.benchmark.PullTimeDelayAlarmBenchmark;
import com.dianping.puma.alarm.model.data.AlarmData;
import com.dianping.puma.alarm.model.data.PullTimeDelayAlarmData;

/**
 * Created by xiaotian.li on 16/3/25.
 * Email: lixiaotian07@gmail.com
 */
public class PullTimeDelayAlarmRenderer extends AbstractPumaAlarmRenderer {

    protected final String propertiesFilePath = "template/alarm-pulltimedelay.properties";

    @Override
    public AlarmMessage render(String clientName, AlarmData data, AlarmBenchmark benchmark)
            throws PumaAlarmRenderException {

        if (!(data instanceof PullTimeDelayAlarmData)) {
            throw new PumaAlarmRenderUnsupportedException("unsupported data[%s]", data);
        }

        if (!(benchmark instanceof PullTimeDelayAlarmBenchmark)) {
            throw new PumaAlarmRenderUnsupportedException("unsupported benchmark[%s]", data);
        }

        if (template == null) {
            template = generateAlarmTemplate(propertiesFilePath);
        }

        AlarmMessage message = new AlarmMessage();

        PullTimeDelayAlarmData pullTimeDelayAlarmData = (PullTimeDelayAlarmData) data;
        PullTimeDelayAlarmBenchmark pullTimeDelayAlarmBenchmark = (PullTimeDelayAlarmBenchmark) benchmark;

        String title = String.format(template.getTitleTemplate(), clientName);
        String content = String.format(template.getContentTemplate(),
                pullTimeDelayAlarmData.getPullTimeDelayInSecond(),
                pullTimeDelayAlarmBenchmark.getMinPullTimeDelayInSecond(),
                pullTimeDelayAlarmBenchmark.getMaxPullTimeDelayInSecond());
        message.setTitle(title);
        message.setContent(content);

        return message;
    }
}