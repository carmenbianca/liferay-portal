/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.internal.model.listener;

import com.liferay.app.builder.service.AppBuilderAppLocalService;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gabriel Albuquerque
 */
@Component(immediate = true, service = ModelListener.class)
public class DDMStructureModelListener extends BaseModelListener<DDMStructure> {

	@Override
	public void onBeforeRemove(DDMStructure ddmStructure)
		throws ModelListenerException {

		try {
			_appBuilderAppLocalService.deleteAppBuilderApps(
				ddmStructure.getStructureId());
		}
		catch (Exception exception) {
			_log.error("Unable to delete app builder apps", exception);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DDMStructureModelListener.class);

	@Reference
	private AppBuilderAppLocalService _appBuilderAppLocalService;

}