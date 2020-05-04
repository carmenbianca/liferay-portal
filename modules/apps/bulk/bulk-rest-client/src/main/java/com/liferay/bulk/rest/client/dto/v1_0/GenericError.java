/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.rest.client.dto.v1_0;

import com.liferay.bulk.rest.client.function.UnsafeSupplier;
import com.liferay.bulk.rest.client.serdes.v1_0.GenericErrorSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Alejandro Tardín
 * @generated
 */
@Generated("")
public class GenericError implements Cloneable {

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String message;

	@Override
	public GenericError clone() throws CloneNotSupportedException {
		return (GenericError)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GenericError)) {
			return false;
		}

		GenericError genericError = (GenericError)object;

		return Objects.equals(toString(), genericError.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return GenericErrorSerDes.toJSON(this);
	}

}