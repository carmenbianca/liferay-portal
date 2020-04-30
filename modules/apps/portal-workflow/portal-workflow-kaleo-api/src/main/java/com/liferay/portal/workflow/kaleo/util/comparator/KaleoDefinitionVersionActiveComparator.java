/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.util.comparator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinitionVersion;

/**
 * @author Inácio Nery
 */
public class KaleoDefinitionVersionActiveComparator
	extends OrderByComparator<KaleoDefinitionVersion> {

	public KaleoDefinitionVersionActiveComparator() {
		this(false);
	}

	public KaleoDefinitionVersionActiveComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		KaleoDefinitionVersion kaleoDefinitionVersion1,
		KaleoDefinitionVersion kaleoDefinitionVersion2) {

		int value = Boolean.compare(
			_isActive(kaleoDefinitionVersion1),
			_isActive(kaleoDefinitionVersion2));

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _isActive(KaleoDefinitionVersion kaleoDefinitionVersion) {
		try {
			KaleoDefinition kaleoDefinition =
				kaleoDefinitionVersion.getKaleoDefinition();

			return kaleoDefinition.isActive();
		}
		catch (PortalException portalException) {
			if (_log.isDebugEnabled()) {
				_log.debug(portalException, portalException);
			}

			return false;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		KaleoDefinitionVersionActiveComparator.class);

	private final boolean _ascending;

}