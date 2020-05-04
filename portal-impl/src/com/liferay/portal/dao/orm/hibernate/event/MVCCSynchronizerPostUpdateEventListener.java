/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate.event;

import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.change.tracking.CTModel;

import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;

/**
 * @author Shuyang Zhou
 */
public class MVCCSynchronizerPostUpdateEventListener
	implements PostUpdateEventListener {

	public static final MVCCSynchronizerPostUpdateEventListener INSTANCE =
		new MVCCSynchronizerPostUpdateEventListener();

	@Override
	public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
		Object entity = postUpdateEvent.getEntity();

		if (entity instanceof MVCCModel) {
			if (entity instanceof CTModel) {
				CTModel<?> ctModel = (CTModel<?>)entity;

				if (ctModel.getCtCollectionId() != 0) {
					return;
				}
			}

			BaseModel<?> baseModel = (BaseModel<?>)entity;

			EntityCacheUtil.putResult(
				baseModel.isEntityCacheEnabled(), entity.getClass(),
				baseModel.getPrimaryKeyObj(), baseModel, false);
		}
	}

}