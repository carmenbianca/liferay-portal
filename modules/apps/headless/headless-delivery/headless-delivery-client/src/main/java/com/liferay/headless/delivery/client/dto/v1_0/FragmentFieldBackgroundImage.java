/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.client.dto.v1_0;

import com.liferay.headless.delivery.client.function.UnsafeSupplier;
import com.liferay.headless.delivery.client.serdes.v1_0.FragmentFieldBackgroundImageSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class FragmentFieldBackgroundImage implements Cloneable {

	public FragmentImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(FragmentImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public void setBackgroundImage(
		UnsafeSupplier<FragmentImage, Exception>
			backgroundImageUnsafeSupplier) {

		try {
			backgroundImage = backgroundImageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected FragmentImage backgroundImage;

	@Override
	public FragmentFieldBackgroundImage clone()
		throws CloneNotSupportedException {

		return (FragmentFieldBackgroundImage)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FragmentFieldBackgroundImage)) {
			return false;
		}

		FragmentFieldBackgroundImage fragmentFieldBackgroundImage =
			(FragmentFieldBackgroundImage)object;

		return Objects.equals(
			toString(), fragmentFieldBackgroundImage.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FragmentFieldBackgroundImageSerDes.toJSON(this);
	}

}