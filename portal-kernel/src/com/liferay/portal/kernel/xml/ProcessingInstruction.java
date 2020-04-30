/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xml;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface ProcessingInstruction extends Node {

	public String getTarget();

	@Override
	public String getText();

	public String getValue(String name);

	public Map<String, String> getValues();

	public boolean removeValue(String name);

	public void setTarget(String target);

	public void setValue(String name, String value);

	public void setValues(Map<String, String> data);

}