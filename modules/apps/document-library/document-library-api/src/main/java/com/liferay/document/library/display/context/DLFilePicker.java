/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.display.context;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Iván Zaera
 */
public interface DLFilePicker {

	public String getDescriptionFieldName();

	public String getIconFieldName();

	public String getJavaScript() throws PortalException;

	public String getJavaScriptModuleName();

	public String getOnClickCallback();

	public String getTitleFieldName();

}