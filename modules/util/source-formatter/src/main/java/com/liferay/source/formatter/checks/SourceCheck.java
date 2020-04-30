/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.source.formatter.SourceFormatterExcludes;
import com.liferay.source.formatter.SourceFormatterMessage;

import java.util.List;
import java.util.Set;

/**
 * @author Hugo Huijser
 */
public interface SourceCheck {

	public Set<SourceFormatterMessage> getSourceFormatterMessages(
		String fileName);

	public boolean isEnabled(String absolutePath);

	public boolean isLiferaySourceCheck();

	public boolean isModuleSourceCheck();

	public void setAllFileNames(List<String> allFileNames);

	public void setAttributes(String attributes) throws JSONException;

	public void setBaseDirName(String baseDirName);

	public void setExcludes(String excludes) throws JSONException;

	public void setFileExtensions(List<String> fileExtenstions);

	public void setMaxLineLength(int maxLineLength);

	public void setPluginsInsideModulesDirectoryNames(
		List<String> pluginsInsideModulesDirectoryNames);

	public void setPortalSource(boolean portalSource);

	public void setProjectPathPrefix(String projectPathPrefix);

	public void setSourceFormatterExcludes(
		SourceFormatterExcludes sourceFormatterExcludes);

	public void setSubrepository(boolean subrepository);

}