/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

module.exports = {
	// Mock this because we can't evaluate React JSX from a Metal-using module
	// like dynamic-data-mapping-form-builder.
	openModal: () => {},
};
