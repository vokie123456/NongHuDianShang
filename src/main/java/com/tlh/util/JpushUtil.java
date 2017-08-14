package com.tlh.util;

import com.tlh.entity.JpushInfoEntity;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.utils.StringUtils;

public class JpushUtil {
	private final int maxRetryTimes = 259200;
	private final String appKey = "cccee2e40241cb01536a7e29";
	private final String masterSecret = "54db191a754ed5e7ebbdd609 ";

	public void excutePush(JpushInfoEntity message) throws Exception {
		JPushClient jPushClient = new JPushClient(appKey, masterSecret, maxRetryTimes);
		PushPayload pushPayload = buidPushPayload(message);
		PushResult result = jPushClient.sendPush(pushPayload);
		LoggerUtil.d(result.toString());
	}

	private PushPayload buidPushPayload(JpushInfoEntity message) {
		PushPayload.Builder builder = PushPayload.newBuilder();

		builder.setPlatform(Platform.all());

		if (message.getType().equals("alais")) {
			builder.setAudience(Audience.alias(new String[] { message.getAlias() }));
		}
		if (message.getType().equals("tags")) {
			builder.setAudience(Audience.tag(message.getTags()));
		}
		if (message.getType().equals("all")) {
			builder.setAudience(Audience.all());
		}

		if (StringUtils.isNotEmpty(message.getMessage())) {
			Notification.Builder nb = new Notification.Builder();
			nb.addPlatformNotification(
					AndroidNotification.newBuilder().setAlert(message.getMessage()).setTitle("提示").build());
			builder.setNotification(nb.build());
		}
		return builder.build();
	}
}