/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.model.uid;

import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.document.DocumentBuilder;

/**
 * @author André de Oliveira
 */
public interface UIDFactory {

	public String getUID(ClassedModel classedModel);

	public String getUID(com.liferay.portal.kernel.search.Document document);

	public String getUID(Document document);

	public void setUID(
		ClassedModel classedModel,
		com.liferay.portal.kernel.search.Document document);

	public void setUID(
		ClassedModel classedModel, DocumentBuilder documentBuilder);

}