/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.exception.ModelListenerException;

/**
 * @author Brian Wing Shun Chan
 */
public class BaseModelListener<T extends BaseModel<T>>
	implements ModelListener<T> {

	@Override
	public void onAfterAddAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	@Override
	public void onAfterCreate(T model) throws ModelListenerException {
	}

	@Override
	public void onAfterRemove(T model) throws ModelListenerException {
	}

	@Override
	public void onAfterRemoveAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	@Override
	public void onAfterUpdate(T model) throws ModelListenerException {
	}

	@Override
	public void onBeforeAddAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	@Override
	public void onBeforeCreate(T model) throws ModelListenerException {
	}

	@Override
	public void onBeforeRemove(T model) throws ModelListenerException {
	}

	@Override
	public void onBeforeRemoveAssociation(
			Object classPK, String associationClassName,
			Object associationClassPK)
		throws ModelListenerException {
	}

	@Override
	public void onBeforeUpdate(T model) throws ModelListenerException {
	}

}