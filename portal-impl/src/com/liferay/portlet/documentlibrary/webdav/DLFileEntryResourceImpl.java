/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.documentlibrary.webdav;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.lock.Lock;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.webdav.BaseResourceImpl;
import com.liferay.portal.kernel.webdav.WebDAVException;
import com.liferay.portal.kernel.webdav.WebDAVRequest;

import java.io.InputStream;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileEntryResourceImpl extends BaseResourceImpl {

	public DLFileEntryResourceImpl(
		WebDAVRequest webDAVRequest, FileEntry fileEntry, boolean appendPath) {

		super(
			webDAVRequest.getRootPath() + webDAVRequest.getPath(),
			_getName(fileEntry, appendPath), _getName(fileEntry, true),
			fileEntry.getCreateDate(), fileEntry.getModifiedDate(),
			fileEntry.getSize());

		setModel(fileEntry);
		setClassName(DLFileEntry.class.getName());
		setPrimaryKey(fileEntry.getPrimaryKey());
	}

	@Override
	public InputStream getContentAsStream() throws WebDAVException {
		FileEntry fileEntry = getModel();

		try {
			FileVersion fileVersion = fileEntry.getLatestFileVersion();

			return fileVersion.getContentStream(true);
		}
		catch (Exception exception) {
			throw new WebDAVException(exception);
		}
	}

	@Override
	public String getContentType() {
		FileEntry fileEntry = getModel();

		try {
			FileVersion fileVersion = fileEntry.getLatestFileVersion();

			return fileVersion.getMimeType();
		}
		catch (Exception exception) {
			return fileEntry.getMimeType();
		}
	}

	@Override
	public Lock getLock() {
		FileEntry fileEntry = getModel();

		return fileEntry.getLock();
	}

	@Override
	public FileEntry getModel() {
		return (FileEntry)super.getModel();
	}

	@Override
	public long getSize() {
		FileEntry fileEntry = getModel();

		try {
			FileVersion fileVersion = fileEntry.getLatestFileVersion();

			return fileVersion.getSize();
		}
		catch (Exception exception) {
			return fileEntry.getSize();
		}
	}

	@Override
	public boolean isCollection() {
		return false;
	}

	@Override
	public boolean isLocked() {
		FileEntry fileEntry = getModel();

		try {
			return fileEntry.hasLock();
		}
		catch (Exception exception) {
		}

		return false;
	}

	private static String _getName(FileEntry fileEntry, boolean appendPath) {
		if (appendPath) {
			String name = fileEntry.getTitle();

			return DLWebDAVUtil.escapeRawTitle(name);
		}

		return StringPool.BLANK;
	}

}