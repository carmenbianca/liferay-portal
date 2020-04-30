/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.selection;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Adolfo Pérez
 */
public class EmptyBulkSelection<T> implements BulkSelection<T> {

	@Override
	public <E extends PortalException> void forEach(
		UnsafeConsumer<T, E> unsafeConsumer) {
	}

	@Override
	public Class<? extends BulkSelectionFactory>
		getBulkSelectionFactoryClass() {

		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getSize() {
		return 0;
	}

	@Override
	public Serializable serialize() {
		return StringPool.BLANK;
	}

	@Override
	public BulkSelection<AssetEntry> toAssetEntryBulkSelection() {
		return new EmptyBulkSelection<>();
	}

}