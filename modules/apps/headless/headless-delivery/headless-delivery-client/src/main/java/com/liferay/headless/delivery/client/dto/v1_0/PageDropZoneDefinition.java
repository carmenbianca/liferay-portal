/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.client.dto.v1_0;

import com.liferay.headless.delivery.client.function.UnsafeSupplier;
import com.liferay.headless.delivery.client.serdes.v1_0.PageDropZoneDefinitionSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class PageDropZoneDefinition implements Cloneable {

	public Object getFragmentSettings() {
		return fragmentSettings;
	}

	public void setFragmentSettings(Object fragmentSettings) {
		this.fragmentSettings = fragmentSettings;
	}

	public void setFragmentSettings(
		UnsafeSupplier<Object, Exception> fragmentSettingsUnsafeSupplier) {

		try {
			fragmentSettings = fragmentSettingsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Object fragmentSettings;

	@Override
	public PageDropZoneDefinition clone() throws CloneNotSupportedException {
		return (PageDropZoneDefinition)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PageDropZoneDefinition)) {
			return false;
		}

		PageDropZoneDefinition pageDropZoneDefinition =
			(PageDropZoneDefinition)object;

		return Objects.equals(toString(), pageDropZoneDefinition.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PageDropZoneDefinitionSerDes.toJSON(this);
	}

}