/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.rest.builder.internal.freemarker;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.tools.rest.builder.internal.util.FileUtil;

import freemarker.cache.ClassTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Template;

import java.io.File;
import java.io.StringWriter;

import java.util.Map;

/**
 * @author Peter Shin
 */
public class FreeMarker {

	public FreeMarker() {
		_configuration.setNumberFormat("computer");

		DefaultObjectWrapperBuilder defaultObjectWrapperBuilder =
			new DefaultObjectWrapperBuilder(Configuration.getVersion());

		_configuration.setObjectWrapper(defaultObjectWrapperBuilder.build());

		ClassTemplateLoader classTemplateLoader = new ClassTemplateLoader(
			FreeMarker.class, "/");

		_configuration.setTemplateLoader(classTemplateLoader);

		_configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
	}

	public String processTemplate(
			File copyrightFile, String name, Map<String, Object> context)
		throws Exception {

		Template template = _configuration.getTemplate(name);

		StringWriter stringWriter = new StringWriter();

		template.process(context, stringWriter);

		StringBuffer stringBuffer = stringWriter.getBuffer();

		String content = stringBuffer.toString();

		if ((copyrightFile != null) && copyrightFile.exists()) {
			content = FileUtil.read(copyrightFile) + "\n\n" + content;
		}

		return StringUtil.replace(content, "\r\n", "\n");
	}

	private static final Configuration _configuration = new Configuration(
		Configuration.getVersion());

}