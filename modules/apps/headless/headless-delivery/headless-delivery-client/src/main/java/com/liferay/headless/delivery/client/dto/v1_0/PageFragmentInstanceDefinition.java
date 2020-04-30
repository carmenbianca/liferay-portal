/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.client.dto.v1_0;

import com.liferay.headless.delivery.client.function.UnsafeSupplier;
import com.liferay.headless.delivery.client.serdes.v1_0.PageFragmentInstanceDefinitionSerDes;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class PageFragmentInstanceDefinition implements Cloneable {

	public Fragment getFragment() {
		return fragment;
	}

	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}

	public void setFragment(
		UnsafeSupplier<Fragment, Exception> fragmentUnsafeSupplier) {

		try {
			fragment = fragmentUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Fragment fragment;

	public Map<String, Object> getFragmentConfig() {
		return fragmentConfig;
	}

	public void setFragmentConfig(Map<String, Object> fragmentConfig) {
		this.fragmentConfig = fragmentConfig;
	}

	public void setFragmentConfig(
		UnsafeSupplier<Map<String, Object>, Exception>
			fragmentConfigUnsafeSupplier) {

		try {
			fragmentConfig = fragmentConfigUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Map<String, Object> fragmentConfig;

	public FragmentField[] getFragmentFields() {
		return fragmentFields;
	}

	public void setFragmentFields(FragmentField[] fragmentFields) {
		this.fragmentFields = fragmentFields;
	}

	public void setFragmentFields(
		UnsafeSupplier<FragmentField[], Exception>
			fragmentFieldsUnsafeSupplier) {

		try {
			fragmentFields = fragmentFieldsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected FragmentField[] fragmentFields;

	@Override
	public PageFragmentInstanceDefinition clone()
		throws CloneNotSupportedException {

		return (PageFragmentInstanceDefinition)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PageFragmentInstanceDefinition)) {
			return false;
		}

		PageFragmentInstanceDefinition pageFragmentInstanceDefinition =
			(PageFragmentInstanceDefinition)object;

		return Objects.equals(
			toString(), pageFragmentInstanceDefinition.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PageFragmentInstanceDefinitionSerDes.toJSON(this);
	}

}