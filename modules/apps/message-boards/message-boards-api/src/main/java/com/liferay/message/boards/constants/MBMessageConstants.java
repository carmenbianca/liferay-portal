/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.constants;

import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author Alexander Chow
 * @author Juan Fernández
 */
public class MBMessageConstants {

	public static final String DEFAULT_FORMAT = PropsUtil.get(
		PropsKeys.MESSAGE_BOARDS_MESSAGE_FORMATS_DEFAULT);

	public static final long DEFAULT_PARENT_MESSAGE_ID = 0;

	public static final String[] FORMATS = PropsUtil.getArray(
		PropsKeys.MESSAGE_BOARDS_MESSAGE_FORMATS);

	public static final int MESSAGE_SUBJECT_MAX_LENGTH = 50;

	public static final String MESSAGE_SUBJECT_PREFIX_RE = "RE: ";

	public static final String TEMP_FOLDER_NAME = "com.liferay.message.boards";

}