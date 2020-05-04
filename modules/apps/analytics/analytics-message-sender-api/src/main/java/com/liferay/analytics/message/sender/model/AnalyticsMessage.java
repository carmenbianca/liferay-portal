/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.model;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;

import java.io.Serializable;

/**
 * @author Rachael Koestartyo
 */
public final class AnalyticsMessage implements Serializable {

	public static AnalyticsMessage.Builder builder(
		AnalyticsMessage analyticsMessage) {

		return new AnalyticsMessage.Builder(analyticsMessage);
	}

	public static AnalyticsMessage.Builder builder(String type) {
		return new AnalyticsMessage.Builder(type);
	}

	public String getAction() {
		return _action;
	}

	public JSONObject getObjectJSONObject() {
		return _objectJSONObject;
	}

	public String getType() {
		return _type;
	}

	public static final class Builder {

		public Builder action(String action) {
			_analyticsMessage._action = action;

			return this;
		}

		public String buildJSONString() {
			JSONObject jsonObject = JSONUtil.put(
				"action", _analyticsMessage.getAction()
			).put(
				"objectJSONObject", _analyticsMessage.getObjectJSONObject()
			).put(
				"type", _analyticsMessage.getType()
			);

			return jsonObject.toJSONString();
		}

		public Builder object(JSONObject objectJSONObject) {
			_analyticsMessage._objectJSONObject = objectJSONObject;

			return this;
		}

		protected Builder(AnalyticsMessage analyticsMessage) {
			_analyticsMessage._action = analyticsMessage.getAction();
			_analyticsMessage._objectJSONObject =
				analyticsMessage.getObjectJSONObject();
			_analyticsMessage._type = analyticsMessage.getType();
		}

		protected Builder(String type) {
			_analyticsMessage._type = type;
		}

		private final AnalyticsMessage _analyticsMessage =
			new AnalyticsMessage();

	}

	private AnalyticsMessage() {
	}

	private String _action;
	private JSONObject _objectJSONObject;
	private String _type;

}