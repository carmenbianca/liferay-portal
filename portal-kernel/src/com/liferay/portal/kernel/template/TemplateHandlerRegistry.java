/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.template;

import java.util.List;

/**
 * @author Michael C. Han
 */
public interface TemplateHandlerRegistry {

	public long[] getClassNameIds();

	public TemplateHandler getTemplateHandler(long classNameId);

	public TemplateHandler getTemplateHandler(String className);

	public List<TemplateHandler> getTemplateHandlers();

}