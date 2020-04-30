/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.constants;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Bruno Farache
 * @author Gabriel Albuquerque
 */
public class AppBuilderAppConstants {

	public static final int SITE_ID_ALL = -1;

	public static final int STATUS_DEPLOYED = 0;

	public static final int STATUS_UNDEPLOYED = 1;

	public enum Status {

		DEPLOYED(STATUS_DEPLOYED, "deployed"),
		UNDEPLOYED(STATUS_UNDEPLOYED, "undeployed");

		public static Status parse(int value) {
			for (Status status : values()) {
				if (status.getValue() == value) {
					return status;
				}
			}

			return null;
		}

		public static Status parse(String label) {
			for (Status status : values()) {
				if (StringUtil.equalsIgnoreCase(label, status.getLabel())) {
					return status;
				}
			}

			return null;
		}

		public String getLabel() {
			return _label;
		}

		public int getValue() {
			return _value;
		}

		private Status(int value, String label) {
			_value = value;
			_label = label;
		}

		private final String _label;
		private final int _value;

	}

}