/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.util;

import com.liferay.analytics.message.sender.model.EntityModelListener;

import java.util.Collection;

/**
 * @author Rachael Koestartyo
 */
public interface EntityModelListenerRegistry {

	public EntityModelListener getEntityModelListener(String className);

	public Collection<EntityModelListener> getEntityModelListeners();

}