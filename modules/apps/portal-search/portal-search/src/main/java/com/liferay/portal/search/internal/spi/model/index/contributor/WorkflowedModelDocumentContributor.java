/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.spi.model.index.contributor;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentContributor;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = DocumentContributor.class)
public class WorkflowedModelDocumentContributor implements DocumentContributor {

	@Override
	public void contribute(Document document, BaseModel baseModel) {
		if (!(baseModel instanceof WorkflowedModel)) {
			return;
		}

		WorkflowedModel workflowedModel = (WorkflowedModel)baseModel;

		document.addKeyword(Field.STATUS, workflowedModel.getStatus());
	}

}