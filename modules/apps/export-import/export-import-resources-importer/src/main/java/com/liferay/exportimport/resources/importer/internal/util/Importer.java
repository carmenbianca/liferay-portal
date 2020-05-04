/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.resources.importer.internal.util;

import com.liferay.journal.util.JournalConverter;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public interface Importer {

	public void afterPropertiesSet() throws Exception;

	public long getGroupId();

	public String getTargetClassName();

	public long getTargetClassPK();

	public void importResources() throws Exception;

	public boolean isCompanyGroup() throws Exception;

	public boolean isDeveloperModeEnabled();

	public boolean isExisting();

	public boolean isIndexAfterImport();

	public void setAppendVersion(boolean appendVersion);

	public void setCompanyId(long companyId);

	public void setDeveloperModeEnabled(boolean developerModeEnabled);

	public void setGroupId(long groupId);

	public void setIndexAfterImport(boolean indexAfterImport);

	public void setJournalConverter(JournalConverter journalConverter);

	public void setResourcesDir(String resourcesDir);

	public void setServletContext(ServletContext servletContext);

	public void setServletContextName(String servletContextName);

	public void setTargetClassName(String className);

	public void setTargetValue(String targetValue);

	public void setUpdateModeEnabled(boolean updateModeEnabled);

	public void setVersion(String version);

}