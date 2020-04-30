/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.reference.closure;

import java.util.List;
import java.util.Map;

/**
 * @author Preston Crary
 */
public interface CTClosure {

	public Map<Long, List<Long>> getChildPKsMap(long classNameId, long classPK);

	public long getCTCollectionId();

	public Map<Long, List<Long>> getRootPKsMap();

}