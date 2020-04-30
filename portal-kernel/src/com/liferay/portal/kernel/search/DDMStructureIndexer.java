/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import java.util.List;

/**
 * @author Michael C. Han
 */
public interface DDMStructureIndexer {

	public void reindexDDMStructures(List<Long> ddmStructureIds)
		throws SearchException;

}