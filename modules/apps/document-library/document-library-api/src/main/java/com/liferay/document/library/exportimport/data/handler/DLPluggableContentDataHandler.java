/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.exportimport.data.handler;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.xml.Element;

/**
 * @author Adolfo Pérez
 */
public interface DLPluggableContentDataHandler<T extends StagedModel> {

	public void exportContent(
			PortletDataContext portletDataContext, Element element,
			T stagedModel)
		throws Exception;

	public void importContent(
			PortletDataContext portletDataContext, Element element,
			T stagedModel, T importedModel)
		throws Exception;

}