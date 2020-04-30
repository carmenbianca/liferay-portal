/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mail.reader.internal.attachment;

import com.liferay.mail.reader.attachment.AttachmentHandler;

import java.io.InputStream;

import javax.mail.Folder;

/**
 * @author Scott Lee
 */
public class DefaultAttachmentHandler implements AttachmentHandler {

	public DefaultAttachmentHandler(InputStream inputStream, Folder folder) {
		_inputStream = inputStream;
		_folder = folder;
	}

	@Override
	public void cleanUp() {
	}

	public Folder getFolder() {
		return _folder;
	}

	@Override
	public InputStream getInputStream() {
		return _inputStream;
	}

	private final Folder _folder;
	private final InputStream _inputStream;

}