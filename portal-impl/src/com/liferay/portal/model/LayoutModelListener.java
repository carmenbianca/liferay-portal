/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model;

import com.liferay.exportimport.kernel.staging.LayoutStagingUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutRevisionLocalServiceUtil;
import com.liferay.portal.servlet.filters.cache.CacheUtil;

/**
 * @author Alexander Chow
 * @author Raymond Augé
 */
public class LayoutModelListener extends BaseModelListener<Layout> {

	@Override
	public void onAfterCreate(Layout layout) {
		clearCache(layout);
	}

	@Override
	public void onAfterRemove(Layout layout) {
		clearCache(layout);
	}

	@Override
	public void onAfterUpdate(Layout layout) {
		clearCache(layout);
	}

	@Override
	public void onBeforeRemove(Layout layout) throws ModelListenerException {
		try {
			if ((layout == null) ||
				!LayoutStagingUtil.isBranchingLayout(layout)) {

				return;
			}

			LayoutRevisionLocalServiceUtil.deleteLayoutLayoutRevisions(
				layout.getPlid());
		}
		catch (IllegalStateException illegalStateException) {

			// This is only needed because of LayoutPersistenceTest but should
			// never happen in a deployed environment

		}
		catch (PortalException portalException) {
			throw new ModelListenerException(portalException);
		}
		catch (SystemException systemException) {
			throw new ModelListenerException(systemException);
		}
	}

	protected void clearCache(Layout layout) {
		if (layout == null) {
			return;
		}

		if (!layout.isPrivateLayout()) {
			CacheUtil.clearCache(layout.getCompanyId());
		}
	}

}