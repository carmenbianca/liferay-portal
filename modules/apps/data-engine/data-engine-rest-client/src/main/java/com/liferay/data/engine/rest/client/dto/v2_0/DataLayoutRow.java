/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.client.dto.v2_0;

import com.liferay.data.engine.rest.client.function.UnsafeSupplier;
import com.liferay.data.engine.rest.client.serdes.v2_0.DataLayoutRowSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Jeyvison Nascimento
 * @generated
 */
@Generated("")
public class DataLayoutRow implements Cloneable {

	public DataLayoutColumn[] getDataLayoutColumns() {
		return dataLayoutColumns;
	}

	public void setDataLayoutColumns(DataLayoutColumn[] dataLayoutColumns) {
		this.dataLayoutColumns = dataLayoutColumns;
	}

	public void setDataLayoutColumns(
		UnsafeSupplier<DataLayoutColumn[], Exception>
			dataLayoutColumnsUnsafeSupplier) {

		try {
			dataLayoutColumns = dataLayoutColumnsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected DataLayoutColumn[] dataLayoutColumns;

	@Override
	public DataLayoutRow clone() throws CloneNotSupportedException {
		return (DataLayoutRow)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataLayoutRow)) {
			return false;
		}

		DataLayoutRow dataLayoutRow = (DataLayoutRow)object;

		return Objects.equals(toString(), dataLayoutRow.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DataLayoutRowSerDes.toJSON(this);
	}

}