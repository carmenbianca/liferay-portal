/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.util;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.xml.Element;

import java.io.InputStream;

import java.util.Set;

/**
 * @author Sergio González
 */
public interface VideoProcessor {

	public static final String THUMBNAIL_TYPE = "jpg";

	public void exportGeneratedFiles(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			Element fileEntryElement)
		throws Exception;

	public void generateVideo(
			FileVersion sourceFileVersion, FileVersion destinationFileVersion)
		throws Exception;

	public InputStream getPreviewAsStream(FileVersion fileVersion, String type)
		throws Exception;

	public long getPreviewFileSize(FileVersion fileVersion, String type)
		throws Exception;

	public InputStream getThumbnailAsStream(FileVersion fileVersion, int index)
		throws Exception;

	public long getThumbnailFileSize(FileVersion fileVersion, int index)
		throws Exception;

	public Set<String> getVideoMimeTypes();

	public boolean hasVideo(FileVersion fileVersion);

	public void importGeneratedFiles(
			PortletDataContext portletDataContext, FileEntry fileEntry,
			FileEntry importedFileEntry, Element fileEntryElement)
		throws Exception;

	public boolean isSupported(String mimeType);

	public boolean isVideoSupported(FileVersion fileVersion);

	public boolean isVideoSupported(String mimeType);

	public void trigger(
		FileVersion sourceFileVersion, FileVersion destinationFileVersion);

}