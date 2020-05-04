/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.indexer;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.search.indexer.BaseModelRetriever;

import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = BaseModelRetriever.class)
public class BaseModelRetrieverImpl implements BaseModelRetriever {

	@Override
	public Optional<BaseModel<?>> fetchBaseModel(
		String className, long classPK) {

		PersistedModel persistModel = _getPersistedModel(className, classPK);

		if (persistModel == null) {
			return Optional.empty();
		}

		if (!(persistModel instanceof BaseModel)) {
			if (_log.isWarnEnabled()) {
				_log.warn(persistModel + " is not a base model");
			}

			return Optional.empty();
		}

		return Optional.ofNullable((BaseModel<?>)persistModel);
	}

	private PersistedModel _getPersistedModel(String className, long classPK) {
		PersistedModelLocalService persistedModelLocalService =
			_getPersistedModelLocalService(className);

		try {
			return persistedModelLocalService.getPersistedModel(classPK);
		}
		catch (PortalException portalException) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					StringBundler.concat(
						"No ", className, " found for class PK ", classPK),
					portalException);
			}

			return null;
		}
	}

	private PersistedModelLocalService _getPersistedModelLocalService(
		String className) {

		PersistedModelLocalService persistedModelLocalService =
			_persistedModelLocalServiceRegistry.getPersistedModelLocalService(
				className);

		if (persistedModelLocalService == null) {
			throw new SystemException(
				"No persisted model local service found for class " +
					className);
		}

		return persistedModelLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseModelRetrieverImpl.class);

	@Reference
	private PersistedModelLocalServiceRegistry
		_persistedModelLocalServiceRegistry;

}