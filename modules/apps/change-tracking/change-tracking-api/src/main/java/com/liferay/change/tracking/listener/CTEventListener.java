/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.listener;

import com.liferay.change.tracking.exception.CTEventException;
import com.liferay.change.tracking.model.CTCollection;

/**
 * @author Preston Crary
 */
public interface CTEventListener {

	public default void onAfterCopy(
			CTCollection sourceCTCollection, CTCollection targetCTCollection)
		throws CTEventException {
	}

	public default void onAfterPublish(long ctCollectionId)
		throws CTEventException {
	}

	public default void onBeforePublish(long ctCollectionId)
		throws CTEventException {
	}

	public default void onBeforeRemove(long ctCollectionId)
		throws CTEventException {
	}

}