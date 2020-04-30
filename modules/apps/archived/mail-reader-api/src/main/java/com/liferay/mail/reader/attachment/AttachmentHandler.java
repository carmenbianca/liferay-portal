/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.attachment;

import java.io.InputStream;

/**
 * @author Ryan Park
 */
public interface AttachmentHandler {

	public void cleanUp();

	public InputStream getInputStream();

}