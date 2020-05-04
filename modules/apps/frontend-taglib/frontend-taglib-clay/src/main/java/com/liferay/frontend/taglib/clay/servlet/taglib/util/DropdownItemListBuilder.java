/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeSupplier;

/**
 * @author Hugo Huijser
 */
public class DropdownItemListBuilder {

	public static DropdownItemListWrapper add(DropdownItem dropdownItem) {
		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.add(dropdownItem);
	}

	public static DropdownItemListWrapper add(
		UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.add(unsafeConsumer);
	}

	public static DropdownItemListWrapper add(
		UnsafeSupplier<Boolean, Exception> unsafeSupplier,
		DropdownItem dropdownItem) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.add(unsafeSupplier, dropdownItem);
	}

	public static DropdownItemListWrapper add(
		UnsafeSupplier<Boolean, Exception> unsafeSupplier,
		UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.add(unsafeSupplier, unsafeConsumer);
	}

	public static DropdownItemListWrapper addCheckbox(
		UnsafeConsumer<DropdownCheckboxItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addCheckbox(unsafeConsumer);
	}

	public static DropdownItemListWrapper addCheckbox(
		UnsafeSupplier<Boolean, Exception> unsafeSupplier,
		UnsafeConsumer<DropdownCheckboxItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addCheckbox(
			unsafeSupplier, unsafeConsumer);
	}

	public static DropdownItemListWrapper addGroup(
		UnsafeConsumer<DropdownGroupItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addGroup(unsafeConsumer);
	}

	public static DropdownItemListWrapper addGroup(
		UnsafeSupplier<Boolean, Exception> unsafeSupplier,
		UnsafeConsumer<DropdownGroupItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addGroup(unsafeSupplier, unsafeConsumer);
	}

	public static DropdownItemListWrapper addRadio(
		UnsafeConsumer<DropdownRadioItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addRadio(unsafeConsumer);
	}

	public static DropdownItemListWrapper addRadio(
		UnsafeSupplier<Boolean, Exception> unsafeSupplier,
		UnsafeConsumer<DropdownRadioItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addRadio(unsafeSupplier, unsafeConsumer);
	}

	public static DropdownItemListWrapper addRadioGroup(
		UnsafeConsumer<DropdownRadioGroupItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addRadioGroup(unsafeConsumer);
	}

	public static DropdownItemListWrapper addRadioGroup(
		UnsafeSupplier<Boolean, Exception> unsafeSupplier,
		UnsafeConsumer<DropdownRadioGroupItem, Exception> unsafeConsumer) {

		DropdownItemListWrapper dropdownItemListWrapper =
			new DropdownItemListWrapper();

		return dropdownItemListWrapper.addRadioGroup(
			unsafeSupplier, unsafeConsumer);
	}

	public static final class DropdownItemListWrapper {

		public DropdownItemListWrapper add(DropdownItem dropdownItem) {
			_dropdownItemList.add(dropdownItem);

			return this;
		}

		public DropdownItemListWrapper add(
			UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

			_dropdownItemList.add(unsafeConsumer);

			return this;
		}

		public DropdownItemListWrapper add(
			UnsafeSupplier<Boolean, Exception> unsafeSupplier,
			DropdownItem dropdownItem) {

			try {
				if (unsafeSupplier.get()) {
					_dropdownItemList.add(dropdownItem);
				}
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}

			return this;
		}

		public DropdownItemListWrapper add(
			UnsafeSupplier<Boolean, Exception> unsafeSupplier,
			UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

			try {
				if (unsafeSupplier.get()) {
					_dropdownItemList.add(unsafeConsumer);
				}
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}

			return this;
		}

		public DropdownItemListWrapper addCheckbox(
			UnsafeConsumer<DropdownCheckboxItem, Exception> unsafeConsumer) {

			_dropdownItemList.addCheckbox(unsafeConsumer);

			return this;
		}

		public DropdownItemListWrapper addCheckbox(
			UnsafeSupplier<Boolean, Exception> unsafeSupplier,
			UnsafeConsumer<DropdownCheckboxItem, Exception> unsafeConsumer) {

			try {
				if (unsafeSupplier.get()) {
					_dropdownItemList.addCheckbox(unsafeConsumer);
				}
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}

			return this;
		}

		public DropdownItemListWrapper addGroup(
			UnsafeConsumer<DropdownGroupItem, Exception> unsafeConsumer) {

			_dropdownItemList.addGroup(unsafeConsumer);

			return this;
		}

		public DropdownItemListWrapper addGroup(
			UnsafeSupplier<Boolean, Exception> unsafeSupplier,
			UnsafeConsumer<DropdownGroupItem, Exception> unsafeConsumer) {

			try {
				if (unsafeSupplier.get()) {
					_dropdownItemList.addGroup(unsafeConsumer);
				}
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}

			return this;
		}

		public DropdownItemListWrapper addRadio(
			UnsafeConsumer<DropdownRadioItem, Exception> unsafeConsumer) {

			_dropdownItemList.addRadio(unsafeConsumer);

			return this;
		}

		public DropdownItemListWrapper addRadio(
			UnsafeSupplier<Boolean, Exception> unsafeSupplier,
			UnsafeConsumer<DropdownRadioItem, Exception> unsafeConsumer) {

			try {
				if (unsafeSupplier.get()) {
					_dropdownItemList.addRadio(unsafeConsumer);
				}
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}

			return this;
		}

		public DropdownItemListWrapper addRadioGroup(
			UnsafeConsumer<DropdownRadioGroupItem, Exception> unsafeConsumer) {

			_dropdownItemList.addRadioGroup(unsafeConsumer);

			return this;
		}

		public DropdownItemListWrapper addRadioGroup(
			UnsafeSupplier<Boolean, Exception> unsafeSupplier,
			UnsafeConsumer<DropdownRadioGroupItem, Exception> unsafeConsumer) {

			try {
				if (unsafeSupplier.get()) {
					_dropdownItemList.addRadioGroup(unsafeConsumer);
				}
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}

			return this;
		}

		public DropdownItemList build() {
			return _dropdownItemList;
		}

		private final DropdownItemList _dropdownItemList =
			new DropdownItemList();

	}

}