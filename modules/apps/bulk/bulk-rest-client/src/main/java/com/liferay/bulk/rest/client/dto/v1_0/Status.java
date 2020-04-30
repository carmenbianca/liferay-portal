/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.rest.client.dto.v1_0;

import com.liferay.bulk.rest.client.function.UnsafeSupplier;
import com.liferay.bulk.rest.client.serdes.v1_0.StatusSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Alejandro Tardín
 * @generated
 */
@Generated("")
public class Status implements Cloneable {

	public Boolean getActionInProgress() {
		return actionInProgress;
	}

	public void setActionInProgress(Boolean actionInProgress) {
		this.actionInProgress = actionInProgress;
	}

	public void setActionInProgress(
		UnsafeSupplier<Boolean, Exception> actionInProgressUnsafeSupplier) {

		try {
			actionInProgress = actionInProgressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean actionInProgress;

	@Override
	public Status clone() throws CloneNotSupportedException {
		return (Status)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Status)) {
			return false;
		}

		Status status = (Status)object;

		return Objects.equals(toString(), status.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return StatusSerDes.toJSON(this);
	}

}