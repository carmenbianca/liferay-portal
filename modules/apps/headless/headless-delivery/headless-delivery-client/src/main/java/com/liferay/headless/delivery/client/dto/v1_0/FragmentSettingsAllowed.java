/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.client.dto.v1_0;

import com.liferay.headless.delivery.client.function.UnsafeSupplier;
import com.liferay.headless.delivery.client.serdes.v1_0.FragmentSettingsAllowedSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class FragmentSettingsAllowed implements Cloneable {

	public Fragment[] getAllowedFragments() {
		return allowedFragments;
	}

	public void setAllowedFragments(Fragment[] allowedFragments) {
		this.allowedFragments = allowedFragments;
	}

	public void setAllowedFragments(
		UnsafeSupplier<Fragment[], Exception> allowedFragmentsUnsafeSupplier) {

		try {
			allowedFragments = allowedFragmentsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Fragment[] allowedFragments;

	@Override
	public FragmentSettingsAllowed clone() throws CloneNotSupportedException {
		return (FragmentSettingsAllowed)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FragmentSettingsAllowed)) {
			return false;
		}

		FragmentSettingsAllowed fragmentSettingsAllowed =
			(FragmentSettingsAllowed)object;

		return Objects.equals(toString(), fragmentSettingsAllowed.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FragmentSettingsAllowedSerDes.toJSON(this);
	}

}