/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.reference;

import com.liferay.change.tracking.reference.helper.TableReferenceDefinitionHelper;
import com.liferay.petra.sql.dsl.Table;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * @author Preston Crary
 */
public interface TableReferenceDefinition<T extends Table<T>> {

	public void defineTableReferences(
		TableReferenceDefinitionHelper<T> tableReferenceDefinitionHelper);

	public BasePersistence<?> getBasePersistence();

	public T getTable();

}