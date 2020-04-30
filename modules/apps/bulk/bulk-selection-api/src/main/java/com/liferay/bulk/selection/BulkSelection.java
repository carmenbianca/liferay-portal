/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.selection;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.exception.PortalException;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Adolfo Pérez
 */
public interface BulkSelection<T> {

	public <E extends PortalException> void forEach(
			UnsafeConsumer<T, E> unsafeConsumer)
		throws PortalException;

	public Class<? extends BulkSelectionFactory> getBulkSelectionFactoryClass();

	public Map<String, String[]> getParameterMap();

	public long getSize() throws PortalException;

	public Serializable serialize();

	public BulkSelection<AssetEntry> toAssetEntryBulkSelection();

}