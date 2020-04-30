/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import com.liferay.source.formatter.checks.configuration.SourceFormatterConfiguration;
import com.liferay.source.formatter.checks.configuration.SourceFormatterSuppressions;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

/**
 * @author Hugo Huijser
 */
public interface SourceProcessor {

	public void format() throws Exception;

	public String[] getIncludes();

	public List<String> getModifiedFileNames();

	public SourceFormatterArgs getSourceFormatterArgs();

	public Set<SourceFormatterMessage> getSourceFormatterMessages();

	public List<SourceMismatchException> getSourceMismatchExceptions();

	public boolean isPortalSource();

	public boolean isSubrepository();

	public void setAllFileNames(List<String> allFileNames);

	public void setPluginsInsideModulesDirectoryNames(
		List<String> pluginsInsideModulesDirectoryNames);

	public void setPortalSource(boolean portalSource);

	public void setProgressStatusQueue(
		BlockingQueue<ProgressStatusUpdate> progressStatusQueue);

	public void setProjectPathPrefix(String projectPathPrefix);

	public void setPropertiesMap(Map<String, Properties> propertiesMap);

	public void setSourceFormatterArgs(SourceFormatterArgs sourceFormatterArgs);

	public void setSourceFormatterConfiguration(
		SourceFormatterConfiguration sourceFormatterConfiguration);

	public void setSourceFormatterExcludes(
		SourceFormatterExcludes sourceFormatterExcludes);

	public void setSourceFormatterSuppressions(
		SourceFormatterSuppressions sourceFormatterSuppressions);

	public void setSubrepository(boolean subrepository);

}