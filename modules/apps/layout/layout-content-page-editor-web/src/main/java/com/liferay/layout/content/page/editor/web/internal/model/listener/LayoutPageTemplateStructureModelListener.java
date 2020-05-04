/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.content.page.editor.web.internal.model.listener;

import com.liferay.layout.page.template.model.LayoutPageTemplateStructure;
import com.liferay.layout.service.LayoutClassedModelUsageLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(service = ModelListener.class)
public class LayoutPageTemplateStructureModelListener
	extends BaseModelListener<LayoutPageTemplateStructure> {

	@Override
	public void onBeforeRemove(
			LayoutPageTemplateStructure layoutPageTemplateStructure)
		throws ModelListenerException {

		_layoutClassedModelUsageLocalService.deleteLayoutClassedModelUsages(
			String.valueOf(
				layoutPageTemplateStructure.getLayoutPageTemplateStructureId()),
			_portal.getClassNameId(LayoutPageTemplateStructure.class),
			layoutPageTemplateStructure.getClassPK());
	}

	@Reference
	private LayoutClassedModelUsageLocalService
		_layoutClassedModelUsageLocalService;

	@Reference
	private Portal _portal;

}