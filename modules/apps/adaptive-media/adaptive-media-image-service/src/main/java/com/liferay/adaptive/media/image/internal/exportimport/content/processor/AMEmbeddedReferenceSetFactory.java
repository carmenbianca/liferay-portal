/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.internal.exportimport.content.processor;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = AMEmbeddedReferenceSetFactory.class)
public class AMEmbeddedReferenceSetFactory {

	public AMEmbeddedReferenceSet create(
		PortletDataContext portletDataContext, StagedModel stagedModel) {

		Map<String, Long> embeddedReferences = new HashMap<>();

		List<Element> referenceElements =
			portletDataContext.getReferenceElements(
				stagedModel, DLFileEntry.class);

		for (Element referenceElement : referenceElements) {
			long classPK = GetterUtil.getLong(
				referenceElement.attributeValue("class-pk"));

			Element referenceDataElement =
				portletDataContext.getReferenceDataElement(
					stagedModel, DLFileEntry.class, classPK);

			String path = null;

			if (referenceDataElement != null) {
				path = referenceDataElement.attributeValue("path");
			}

			if (Validator.isNull(path)) {
				long groupId = GetterUtil.getLong(
					referenceElement.attributeValue("group-id"));
				String className = referenceElement.attributeValue(
					"class-name");

				path = ExportImportPathUtil.getModelPath(
					groupId, className, classPK);
			}

			embeddedReferences.put(path, classPK);
		}

		return new AMEmbeddedReferenceSet(
			portletDataContext, stagedModel, embeddedReferences);
	}

}