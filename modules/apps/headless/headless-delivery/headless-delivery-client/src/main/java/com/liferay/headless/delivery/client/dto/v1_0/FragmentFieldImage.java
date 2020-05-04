/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.client.dto.v1_0;

import com.liferay.headless.delivery.client.function.UnsafeSupplier;
import com.liferay.headless.delivery.client.serdes.v1_0.FragmentFieldImageSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class FragmentFieldImage implements Cloneable {

	public FragmentImage getFragmentImage() {
		return fragmentImage;
	}

	public void setFragmentImage(FragmentImage fragmentImage) {
		this.fragmentImage = fragmentImage;
	}

	public void setFragmentImage(
		UnsafeSupplier<FragmentImage, Exception> fragmentImageUnsafeSupplier) {

		try {
			fragmentImage = fragmentImageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected FragmentImage fragmentImage;

	public FragmentLink getFragmentLink() {
		return fragmentLink;
	}

	public void setFragmentLink(FragmentLink fragmentLink) {
		this.fragmentLink = fragmentLink;
	}

	public void setFragmentLink(
		UnsafeSupplier<FragmentLink, Exception> fragmentLinkUnsafeSupplier) {

		try {
			fragmentLink = fragmentLinkUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected FragmentLink fragmentLink;

	@Override
	public FragmentFieldImage clone() throws CloneNotSupportedException {
		return (FragmentFieldImage)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FragmentFieldImage)) {
			return false;
		}

		FragmentFieldImage fragmentFieldImage = (FragmentFieldImage)object;

		return Objects.equals(toString(), fragmentFieldImage.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FragmentFieldImageSerDes.toJSON(this);
	}

}