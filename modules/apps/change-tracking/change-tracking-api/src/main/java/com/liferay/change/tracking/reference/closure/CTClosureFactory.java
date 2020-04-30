/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.reference.closure;

/**
 * @author Preston Crary
 */
public interface CTClosureFactory {

	public CTClosure create(long ctCollectionId);

}